package javase03.t03.main;

import javase03.t03.logic.HtmlParser;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        HtmlParser parser = new HtmlParser();

        String[] sentences = parser.parse();
        Arrays.stream(sentences).forEach(System.out::println);
        System.out.println(String.format("------------------\nRight order: %s\n------------------", parser.checkForOrder(sentences)));
    }
}
