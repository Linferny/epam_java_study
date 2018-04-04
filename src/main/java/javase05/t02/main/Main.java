package javase05.t02.main;

import javase05.t02.logic.PropertiesReader;

public class Main {
    public static void main(String[] args) {
        PropertiesReader reader = new PropertiesReader();
        reader.loadProperties("javase05.t02/test.properties");
        System.out.println(reader.getProperty("wrong"));
        System.out.println(reader.getProperty("test1"));
    }
}
