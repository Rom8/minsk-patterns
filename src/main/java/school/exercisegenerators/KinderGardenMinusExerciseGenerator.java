package school.exercisegenerators;

import school.Exercise;

import java.util.Random;

import static school.Operation.MINUS;

/**
 * Created by Jeka on 26/09/2015.
 */
public class KinderGardenMinusExerciseGenerator implements ExerciseGenerator {
    @Override
    public Exercise generate() {
        Exercise exercise = new Exercise();
        Random random = new Random();
        exercise.setA(random.nextInt(10));
        exercise.setB(random.nextInt(exercise.getA()));
        exercise.setOperation(MINUS);
        exercise.setAnswer(exercise.getA()-exercise.getB());
        return exercise;
    }
}
