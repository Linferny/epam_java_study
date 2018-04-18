package javase07.t02.main;

import javase07.t02.logic.PropSafeReader;

// Так как проблем с чтением из файла нет и все потоки могут чиатть одновременно
// В данном случае я просто добавил интерфейс Runnable к классу
public class Main {
    public static void main(String[] args) {
        PropSafeReader[] props = new PropSafeReader[20];
        String fileName = "javase05.t02/test.properties";

        for (int i = 0; i < props.length; i++) {
            props[i] = new PropSafeReader();
            props[i].setFileName(fileName);
            Thread t = new Thread(props[i]);
            t.start();
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < props.length; i++) {
            System.out.println(props[i].getProperty("test1"));
        }
    }
}
