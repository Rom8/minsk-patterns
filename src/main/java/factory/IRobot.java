package factory;

import factory.annotations.Benchmark;
import factory.annotations.Inject;
import factory.robotparts.Cleaner;
import factory.robotparts.Speaker;

/**
 * Created by Jeka on 26/09/2015.
 */
public class IRobot {
    @Inject
    private Cleaner cleaner;
    @Inject
    private Speaker speaker;

    @Benchmark
    public void cleanRoom(){
        speaker.speak("I started my work");
        cleaner.clean();
        speaker.speak("I finished my work");
    }
}