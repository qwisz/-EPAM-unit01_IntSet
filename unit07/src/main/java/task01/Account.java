package task01;

public interface Account {

    int getId();
    double getBalance();
    void recharge(double credit);
    void withdraw(double credit);
}