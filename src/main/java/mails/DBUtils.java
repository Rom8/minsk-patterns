package mails;

import java.util.Random;

/**
 * Created by Jeka on 26/09/2015.
 */
public class DBUtils {
    public static int getTemplateCode() {
        Random random = new Random();
        return random.nextInt(4)+1;
    }
}
