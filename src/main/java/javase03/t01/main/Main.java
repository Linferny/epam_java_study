package javase03.t01.main;

import javase03.t01.logic.CrazyLogger;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        CrazyLogger logger = new CrazyLogger();

        logger.log("Hello");
        logger.log("What do you want?");
        logger.log("Bye");
        logger.printLogs(2);
        logger.searchByMessage(true, "123");
        System.out.println();
        logger.searchByDate(true, "mm-YYYY", LocalDateTime.now());
    }
}
