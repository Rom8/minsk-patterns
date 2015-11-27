package command;

import java.util.*;

/**
 * Created by Jeka on 09/03/14.
 */
public class AccountManager {
    private Deque<Command> commands = new LinkedList<>();

    public  void transferMoney(Account accountFrom, Account accountTo, int amount) {
        new TransferMoneyCommand(accountFrom,accountTo,amount).execute();
        commands.add(new TransferMoneyCommand(accountTo, accountFrom, amount));
    }

    public void depositMoney(Account account, int amount){
        new DepositMoneyCommand(account,amount).execute();
        commands.add(new WithdrawMoneyCommand(account, amount));
    }

    public void withdrawMoney(Account account, int amount){
        new WithdrawMoneyCommand(account,amount).execute();
        commands.add(new DepositMoneyCommand(account, amount));
    }

    public void undo() {
        commands.removeLast().execute();
    }
}
