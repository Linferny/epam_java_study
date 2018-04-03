package javase04.t03.main;

import javase04.t03.logic.FileEncodingChanger;

public class Main {
    public static void main(String[] args) {
        String fileName = "Javase04-03-utf8.txt";
        FileEncodingChanger.generateFileWithUTF8(fileName);
        FileEncodingChanger.changeEncodingToUTF16(fileName);
    }
}
