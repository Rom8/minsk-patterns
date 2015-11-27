package school;

import school.exercisegenerators.ExerciseGenerator;

import java.util.List;
import java.util.Random;

/**
 * Created by Jeka on 26/09/2015.
 */
public class SchoolService {
    private List<ExerciseGenerator> generators;
    private Config config = new Config();

    public void setConfig(Config config) {
        this.config = config;
    }

    public SchoolService() {
        generators = config.getGenerators();
    }

    public Exercise getExercise() {
        Random random = new Random();
        ExerciseGenerator generator = generators.get(random.nextInt(generators.size()));
        return generator.generate();
    }
}
