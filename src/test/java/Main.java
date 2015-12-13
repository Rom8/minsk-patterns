import org.junit.Ignore;

/**
 * Created by Roma on 28 Nov 2015.
 */
public class Main {

    public static void main(String[] args) throws NoSuchMethodException {
        SampleClass sampleClass = new SampleClass();
        Class<?> clazz = sampleClass.getClass();
        System.out.println( clazz.getMethod("whatIsUp").getAnnotation(Ignore.class) );
    }


}
