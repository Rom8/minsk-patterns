package factory.configurers.proxyconfigurers;

/**
 * Created by Jeka on 27/09/2015.
 */
public interface ProxyConfigurer {
    <T> T wrapWithProxy (T t, Class<T> originalClass);
}
