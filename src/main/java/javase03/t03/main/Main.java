package javase03.t03.main;

import javase03.t03.logic.HtmlParser;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        HtmlParser parser = new HtmlParser();

        parser.parse();
    }
}
