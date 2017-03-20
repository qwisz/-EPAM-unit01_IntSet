package task01;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@AllArgsConstructor
@Log
public class AccountOperator implements Runnable {

    private Account account1;

    private Account account2;

    private double credit;


    @Override
    public void run() {

        account1.withdraw(credit);
        account2.recharge(credit);
    }
}