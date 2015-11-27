package school;

import school.exercisegenerators.ExerciseGenerator;
import school.exercisegenerators.FirstGradlePlusExerciseGenerator;
import school.exercisegenerators.KinderGardenMinusExerciseGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jeka on 26/09/2015.
 */
public class Config {
    private List<ExerciseGenerator> generators = new ArrayList<>();


    public Config() {

        generators.add(new FirstGradlePlusExerciseGenerator());
        generators.add(new KinderGardenMinusExerciseGenerator());
    }

    public List<ExerciseGenerator> getGenerators() {
        return generators;
    }
}
