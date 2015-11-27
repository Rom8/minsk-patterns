package command;

/**
 * Created by Jeka on 09/03/14.
 */
public class Account {
    private int id;
    private int balance;

    public Account(int id) {
        this.id = id;
    }

    public int getBalance() {
        return balance;
    }

    public void increaseBalance(int sum) {
        balance += sum;
    }

    public void decreaseBalance(int sum) {
        balance -= sum;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
