package javase07.t01.logic;

import java.io.*;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Bank extends Account {
    Map<String, Account> accounts;
    List<Transaction> transactions;

    public Bank(String name) {
        super(name, Double.MAX_VALUE);
        accounts = new HashMap<>();
        transactions = new ArrayList<>();
    }

    public void parseLogs(String path) {
        File logs = new File(path);
        if (!logs.exists())
            return;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            ExecutorService service = Executors.newCachedThreadPool();
            String line;
            while ((line = reader.readLine()) != null && line.length() != 0) {
                String[] data = line.split(" ");
                Account source = getAccount(data[0]);
                Account destination = getAccount(data[1]);
                double money = 0;
                try {
                    money = Double.parseDouble(data[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Wrong double format!");
                    continue;
                }

                Transaction transaction = new Transaction(source, destination, money);

                transactions.add(transaction);
                service.execute(transaction);
            }
            Thread.sleep(5000);
            service.shutdown();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printAll() {
        for (Account a : accounts.values()) {
            System.out.println(a.toString());
        }
    }

    public Account getAccount(String name) {
        if (name.equals(this.name))
            return this;
        Account account = accounts.get(name);
        if (account == null) {
            Account a = new Account(name, 0);
            accounts.put(name, a);
            return a;
        }
        return account;
    }
}
