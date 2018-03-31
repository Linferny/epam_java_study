package javase04.t02.main;

import javase04.t02.logic.JavaReader;

public class Main {
    public static void main(String[] args) {
        JavaReader reader = new JavaReader();

        reader.analyzeJavaCode("Javase04-t02-result.txt");
    }
}
