package command.gradle;

import command.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeka on 10/03/14.
 */
public abstract class Task implements Command {
    private List<Task> dependsOn = new ArrayList<>();

    public void addDependency(Task... tasks) {
        for (Task task : tasks) {
            dependsOn.add(task);
        }
    }

    public void removeDependency(Task task) {
        dependsOn.remove(task);
    }

    @Override
    public void execute() {
        for (Task task : dependsOn) {
            task.execute();
        }
        executeCurrentTask();
    }

    protected abstract void executeCurrentTask();
}
