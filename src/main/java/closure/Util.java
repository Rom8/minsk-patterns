package closure;

import java.util.List;

/**
 * Created by Jeka on 27/09/2015.
 */
public class Util {
    public static <T> int countDuplicates(List<T> list, T t, Equalator<T> equalator) {
        int counter=0;
        for (T t1 : list) {
            if (equalator.equals(t1,t)){
                counter++;
            }

        }
        return counter;
    }
}
