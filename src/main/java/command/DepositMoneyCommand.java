package command;

/**
 * Created by Jeka on 13/03/14.
 */
public class DepositMoneyCommand implements Command {
    private Account account;
    private int amount;

    public DepositMoneyCommand(Account account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.increaseBalance(amount);
    }
}
