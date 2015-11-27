package factory.config;

/**
 * Created by Jeka on 26/09/2015.
 */
public interface Config {
   <T,E extends T> Class<E> getImpl(Class<T> ifc);
}
