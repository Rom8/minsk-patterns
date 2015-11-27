package school;

/**
 * Created by Jeka on 26/09/2015.
 */
public class Main {
    public static void main(String[] args) {
        SchoolService schoolService = new SchoolService();
        for (int i = 0; i < 10; i++) {
            System.out.println(schoolService.getExercise());
        }
    }
}
