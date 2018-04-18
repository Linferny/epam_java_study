package javase07.t01.logic;

import java.util.concurrent.TimeUnit;

public class Transaction implements Runnable {
    private static Integer currentId = 0;
    int id;
    Account source;
    Account destination;
    double money;

    public Transaction(Account source, Account destination, double money) {
        synchronized (currentId) {
            id = currentId;
            currentId++;
        }
        this.source = source;
        this.destination = destination;
        this.money = money;
    }

    public boolean completeTransactionS() {
        String transf = String.format("ID: %4d|Transfer from %s to %s", id, source.name, destination.name);
        synchronized (source) {
            System.out.println(String.format("%s: STARTED", transf));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println(String.format("%s: INTERRUPTED", transf));
            }
            if (source.withdrawMoney(money) <= 0) {
                System.out.println(String.format("%s: FAILED", transf));
                return false;
            }
            destination.putMoney(money);
            System.out.println(String.format("%s: SUCCESS: withdraw %f", transf, money));
            return true;
        }
    }

    public boolean completeTransactionC() {
        String transf = String.format("ID: %4d|Transfer from %s to %s", id, source.name, destination.name);
        System.out.println(String.format("%s: STARTED", transf));

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println(String.format("%s: INTERRUPTED", transf));
        }

        try {
            source.getLock().lock();
            if (source.withdrawMoney(money) <= 0) {
                System.out.println(String.format("%s: FAILED", transf));
                return false;
            }
            destination.putMoney(money);
            System.out.println(String.format("%s: SUCCESS: withdraw %f", transf, money));
        } finally {
            source.getLock().unlock();
        }
        return true;
    }

    @Override
    public void run() {
        completeTransactionC();
    }
}
