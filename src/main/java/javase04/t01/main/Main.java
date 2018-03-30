package javase04.t01.main;

import javase04.t01.logic.JavaReader;

public class Main {
    public static void main(String[] args) {
        JavaReader javaReader = new JavaReader();

        javaReader.analyzeJavaCode("Javase04-t01-result.txt");
    }
}
