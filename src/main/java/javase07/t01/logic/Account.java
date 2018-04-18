package javase07.t01.logic;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.concurrent.locks.ReentrantLock;

@Getter
@EqualsAndHashCode(exclude = "deposit")
public class Account {
    protected String name;
    protected double deposit;
    @Getter
    private ReentrantLock lock;

    public Account(String name, double deposit) {
        lock = new ReentrantLock();
        this.name = name;
        this.deposit = deposit;
    }

    public void putMoney(double money) {
        deposit += money;
    }

    public double withdrawMoney(double money) {
        if (deposit - money < 0)
            return 0;
        deposit -= money;
        return money;
    }

    @Override
    public String toString() {
        return name + ": " + deposit;
    }
}
