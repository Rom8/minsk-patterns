package factory.configurers.objectconfigurers;

import factory.annotations.Inject;
import factory.ObjectFactory;

import java.lang.reflect.Field;

/**
 * Created by Roma on 15 Nov 2015.
 */
public class InjectConfigurer implements ObjectConfigurer {
    @Override
    public void configure(Object o) throws Exception {
        Class<?> clazz = o.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);
                field.set(o, ObjectFactory.getInstance().createObject(field.getType()));
            }
        }

    }
}
