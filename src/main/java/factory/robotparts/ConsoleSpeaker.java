package factory.robotparts;

import factory.annotations.Benchmark;

/**
 * Created by Jeka on 26/09/2015.
 */
public class ConsoleSpeaker implements Speaker {

    @Override
//    @Benchmark
    public void speak(String message) {
        System.out.println(message);
    }
}
