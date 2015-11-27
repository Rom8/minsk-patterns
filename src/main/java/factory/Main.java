package factory;

/**
 * Created by Jeka on 26/09/2015.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        IRobot robot = ObjectFactory.getInstance().createObject(IRobot.class);
        while (true) {
            robot.cleanRoom();
            Thread.sleep(1000);
        }
    }
}
