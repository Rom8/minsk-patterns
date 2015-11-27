package factory.robotparts;

import factory.annotations.Benchmark;
import factory.annotations.InjectRandomInt;

import javax.annotation.PostConstruct;

/**
 * Created by Jeka on 26/09/2015.
 */
public class CleanerImpl implements Cleaner {

    @InjectRandomInt(min = 4, max = 9)
    private int repeat;

    @PostConstruct
    public void init() {
        System.out.println(repeat);
    }

    @Override
//    @Benchmark
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("VVVVVVVVVVVVVVVvvvvvvvvvvvvvvvvvv");
        }
    }
}
