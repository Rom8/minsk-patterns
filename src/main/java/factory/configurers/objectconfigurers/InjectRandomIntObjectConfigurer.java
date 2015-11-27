package factory.configurers.objectconfigurers;

import factory.annotations.InjectRandomInt;

import java.lang.reflect.Field;
import java.util.Random;

/**
 * Created by Jeka on 26/09/2015.
 */
public class InjectRandomIntObjectConfigurer implements ObjectConfigurer {
    @Override
    public void configure(Object t) throws Exception {
        Class<?> type = t.getClass();
        for (Field field : type.getDeclaredFields()) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                Random random = new Random();
                int randomInt = min + random.nextInt(max - min) + 1;
                field.setAccessible(true);
                field.set(t, randomInt);
            }
        }
    }
}
