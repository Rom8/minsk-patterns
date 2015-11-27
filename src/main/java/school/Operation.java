package school;

/**
 * Created by Jeka on 26/09/2015.
 */
public enum Operation {
    PLUS("+"),MINUS("-"),MULTIPLY("*");

    private final String sign;

    Operation(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }

    @Override
    public String toString() {
        return sign;
    }
}
