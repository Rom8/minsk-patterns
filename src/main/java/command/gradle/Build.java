package command.gradle;

/**
 * Created by Jeka on 10/03/14.
 */
public class Build extends Task {
    @Override
    public void executeCurrentTask() {
        System.out.println("Build finished!!!");
    }
}
