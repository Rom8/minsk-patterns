package school.generatorassistants;

import school.Exercise;

import java.util.Random;

/**
 * Created by Jeka on 26/09/2015.
 */
public class ExerciseGeneratorAssistantImpl implements ExerciseGeneratorAssistant {
    private Random random = new Random();
    private int max;

    public ExerciseGeneratorAssistantImpl(int max) {
        this.max = max;
    }

    @Override
    public Exercise generateExerciseTemplate() {

        Exercise exercise = new Exercise();
        exercise.setA(random.nextInt(max));
        exercise.setB(random.nextInt(max));
        return exercise;
    }
}
