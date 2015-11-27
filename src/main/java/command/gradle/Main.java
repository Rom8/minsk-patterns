package command.gradle;

/**
 * Created by Jeka on 10/03/14.
 */
public class Main {
    public static void main(String[] args) {
        Build build = new Build();
        CompileSources compileSources = new CompileSources();
        CompileTests compileTests = new CompileTests();
        RunTests runTests = new RunTests();
        Pack pack = new Pack();
        Check check = new Check();
        Assemble assemble = new Assemble();
        Deploy deploy = new Deploy();

        compileTests.addDependency(compileSources);
        runTests.addDependency(compileTests);
        pack.addDependency(runTests);
        assemble.addDependency(pack);
        build.addDependency(assemble,check);
        deploy.addDependency(build);

        deploy.execute();


    }
}
