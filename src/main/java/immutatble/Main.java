package immutatble;

/**
 * Created by Jeka on 27/09/2015.
 */
public class Main {
    public static void main(String[] args) {
        Customer.Builder builder = new Customer.Builder();
        Customer customer = builder.bonus(100).name("Vasya").debt(50).build();
        System.out.println(customer);
        Customer masha = builder.bonus(1001).debt(5666).build();
        System.out.println(masha);
    }
}
