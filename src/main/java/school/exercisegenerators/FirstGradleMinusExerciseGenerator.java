package school.exercisegenerators;

import school.Exercise;
import school.generatorassistants.ExerciseGeneratorAssistant;
import school.generatorassistants.ExerciseGeneratorAssistantImpl;

import static school.Operation.MINUS;

/**
 * Created by Jeka on 26/09/2015.
 */
public class FirstGradleMinusExerciseGenerator implements ExerciseGenerator {

    private ExerciseGeneratorAssistant assistant = new ExerciseGeneratorAssistantImpl(100);
    @Override
    public Exercise generate() {
        Exercise exercise = assistant.generateExerciseTemplate();
        exercise.setOperation(MINUS);
        exercise.setAnswer(exercise.getA() - exercise.getB());
        return exercise;
    }
}
