package factory;

import factory.config.Config;
import factory.config.JavaConfig;
import factory.configurers.objectconfigurers.ObjectConfigurer;
import factory.configurers.proxyconfigurers.ProxyConfigurer;
import org.reflections.Reflections;

import javax.annotation.PostConstruct;
import java.lang.reflect.*;
import java.util.*;

/**
 * Created by Jeka on 26/09/2015.
 */
public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private final Reflections reflections = new Reflections();

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {
        Set<Class<? extends ObjectConfigurer>> classes = reflections.getSubTypesOf(ObjectConfigurer.class);
        for (Class<? extends ObjectConfigurer> configurerClass : classes) {
            try {
                objectConfigurers.add(configurerClass.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        Set<Class<? extends ProxyConfigurer>> proxyConfigurerClasses = reflections.getSubTypesOf(ProxyConfigurer.class);
        for (Class<? extends ProxyConfigurer> proxyConfigurerClass : proxyConfigurerClasses) {
            try {
                proxyConfigurers.add(proxyConfigurerClass.newInstance());
            }catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Config config = new JavaConfig();

    private Set<ObjectConfigurer> objectConfigurers = new HashSet<>();
    private Set<ProxyConfigurer> proxyConfigurers = new HashSet<>();


    public <T> T createObject(Class<T> type) throws Exception {
        type = resolveImpl(type);   //вернуть класс, если передан интерфейс
        T t = type.newInstance();
        configure(t);               //все аннотации в классе прочитать
        invokeInitMethods(type, t);     //ПостКонсткакт запустить
        t = configureProxies(type, t);
        return t;
    }

    private <T> T configureProxies(Class<T> type, T t) {
        for (ProxyConfigurer proxyConfigurer : proxyConfigurers) {
            t = proxyConfigurer.wrapWithProxy(t, type);
        }
        return t;
    }


    private <T> Class<T> resolveImpl(Class<T> type) {
        if (type.isInterface()) {

            Class<T> impl = config.getImpl(type);
            if (impl == null) {
                Set<Class<? extends T>> classes = reflections.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new RuntimeException("you have 0 or more than 1 impl for interface " + type + " please map needed impl in your config");
                }
                type = (Class<T>) classes.iterator().next();
            } else {
                type = impl;
            }
        }
        return type;
    }


    private <T> void invokeInitMethods(Class<T> type, T t) throws IllegalAccessException, InvocationTargetException {
        Method[] methods = type.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PostConstruct.class)) {
                method.setAccessible(true);
                method.invoke(t);
            }
        }
    }

    private <T> void configure(T t) throws Exception {
        for (ObjectConfigurer objectConfigurer : objectConfigurers) {
            objectConfigurer.configure(t);
        }
    }

}