package task01;

import lombok.AllArgsConstructor;

@AllArgsConstructor()
public class SynchronizedAccount implements Account {

    private final int id;
    private double credit;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public double getBalance() {
        return credit;
    }

    @Override
    public void recharge(double credit) {

        proceed(credit);
    }

    @Override
    public void withdraw(double credit) {

        proceed(-credit);
    }

    private void proceed(double credit){

        synchronized (this){
            this.credit += credit;
        }
    }
}