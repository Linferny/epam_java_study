package javase03.t02.main;

import javase03.t02.logic.Quiz;

public class Main {
    public static void main(String[] args) {
        Quiz quiz = new Quiz();
        System.out.println(quiz.getQuestion(1));
        System.out.println(quiz.getAnswer(1));
        quiz.setLocaleEN();
        System.out.println(quiz.getQuestion(2));
        System.out.println(quiz.getAnswer(2));
    }
}
