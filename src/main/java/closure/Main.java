package closure;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jeka on 27/09/2015.
 */
public class Main {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("java", "Java", "JAVA", "GROOVY");
        Util.countDuplicates(words, "JAVa", new Equalator<String>() {
            @Override
            public boolean equals(String t1, String t2) {
                return t1.equalsIgnoreCase(t2);
            }
        });
    }
}
