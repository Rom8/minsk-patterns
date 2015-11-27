package command;

/**
 * Created by Jeka on 13/03/14.
 */
public class WithdrawMoneyCommand implements Command {
    private Account account;
    private int amount;

    public WithdrawMoneyCommand(Account account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {

        account.decreaseBalance(amount);
    }
}
