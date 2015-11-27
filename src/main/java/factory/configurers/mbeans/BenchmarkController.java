package factory.configurers.mbeans;

/**
 * Created by Jeka on 27/09/2015.
 */
public class BenchmarkController implements  BenchmarkControllerMBean{
    private boolean enabled;

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
