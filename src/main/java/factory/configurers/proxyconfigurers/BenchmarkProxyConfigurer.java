package factory.configurers.proxyconfigurers;

import factory.annotations.Benchmark;
import factory.configurers.mbeans.BenchmarkController;
import net.sf.cglib.proxy.Enhancer;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Jeka on 27/09/2015.
 */
public class BenchmarkProxyConfigurer implements ProxyConfigurer {
    private BenchmarkController controller = new BenchmarkController();

    public BenchmarkProxyConfigurer() throws Exception {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        mBeanServer.registerMBean(controller, new ObjectName("emaguru", "name", "benchmark"));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T wrapWithProxy(T t, Class<T> originalClass) {
        Method[] methods = originalClass.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Benchmark.class)) {


                if (originalClass.getInterfaces().length > 0) {
                    return (T) Proxy.newProxyInstance(originalClass.getClassLoader(), originalClass.getInterfaces(), new InvocationHandler() {
                        @Override
                        public Object invoke(Object proxy, Method method, Object[] objects) throws Throwable {
                            return invoke2(t, originalClass, method, objects);
                        }
                    });
                } else {
                    return (T) Enhancer.create(originalClass, new net.sf.cglib.proxy.InvocationHandler() {
                        @Override
                        public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                            return invoke2(t, originalClass, method, objects);
                        }
                    });
                }
            }
        }
        return t;
    }

    private <T> Object invoke2(T t, Class<T> originalClass, Method method, Object[] objects) throws Exception {
        Object retVal = null;
        Method originalClassMethod = originalClass.getMethod(method.getName(), method.getParameterTypes());
        if (originalClassMethod.isAnnotationPresent(Benchmark.class) && controller.isEnabled()) {
            System.out.println("***********BENCHMARK***************");
            long before = System.nanoTime();
            retVal = method.invoke(t, objects);
            long after = System.nanoTime();
            System.out.println(method.getName() + " worked for " + (after - before) + " nanos");
            System.out.println("***********BENCHMARK***************");
            return retVal;
        } else {
            return method.invoke(t, objects);
        }
    }
}
