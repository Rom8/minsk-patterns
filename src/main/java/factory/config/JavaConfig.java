package factory.config;

import factory.robotparts.Cleaner;
import factory.robotparts.CleanerImpl;
import factory.robotparts.ConsoleSpeaker;
import factory.robotparts.Speaker;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jeka on 26/09/2015.
 */
public class JavaConfig implements Config {

    private Map<Class, Class> ifc2Impl = new HashMap<>();


    public JavaConfig() {
        ifc2Impl.put(Speaker.class, ConsoleSpeaker.class);
        ifc2Impl.put(Cleaner.class, CleanerImpl.class);

    }


    @Override
    public <T, E extends T> Class<E> getImpl(Class<T> ifc) {
        return ifc2Impl.get(ifc);
    }
}
