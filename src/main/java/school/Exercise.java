package school;

/**
 * Created by Jeka on 26/09/2015.
 */
public class Exercise {
    private int a;
    private int b;
    private Operation operation;
    private int answer;

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public Operation getOperation() {
        return operation;
    }

    public int getAnswer() {
        return answer;
    }

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return a + " " + operation + " " + b + " = " + answer;
    }
}
