package javase03.t02.logic;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Quiz {
    ResourceBundle quiz;
    @Getter
    @Setter
    String path = "javase03/t02/quiz";
    final Locale localeRU = new Locale("RU", "ru");
    final Locale localeEN = new Locale("EN", "us");
    int questionCount;

    public Quiz() {
        quiz = ResourceBundle.getBundle(path, localeRU);

        Enumeration<String> keys = quiz.getKeys();
        while (keys.hasMoreElements()) {
            keys.nextElement();
            questionCount++;
        }
        questionCount /= 2;
    }

    public void setLocaleRU() {
        if (quiz.getLocale().equals(localeRU))
            return;
        quiz = ResourceBundle.getBundle(path, localeRU);
    }

    public void setLocaleEN() {
        if (quiz.getLocale().equals(localeEN))
            return;
        quiz = ResourceBundle.getBundle(path, localeEN);
    }

    public String getQuestion(int questionId) {
        if (questionId < 1 || questionId > questionCount)
            return "";
        return getWithEncoding("", "", quiz.getString(String.format("q%d", questionId)));
    }

    public String getQuestionWithEncoding(int questionId, String to) {
        if (questionId < 1 || questionId > questionCount)
            return "";
        return getWithEncoding("", to, quiz.getString(String.format("q%d", questionId)));
    }

    public String getQuestionWithEncoding(int questionId, String from, String to) {
        if (questionId < 1 || questionId > questionCount)
            return "";
        return getWithEncoding(from, to, quiz.getString(String.format("q%d", questionId)));
    }

    public String getAnswer(int answerId) {
        if (answerId < 1 || answerId > questionCount)
            return "";
        return getWithEncoding("", "", quiz.getString(String.format("a%d", answerId)));
    }

    public String getAnswerWithEncoding(int answerId, String to) {
        if (answerId < 1 || answerId > questionCount)
            return "";
        return getWithEncoding("", to, quiz.getString(String.format("a%d", answerId)));
    }

    public String getAnswerWithEncoding(int answerId, String from, String to) {
        if (answerId < 1 || answerId > questionCount)
            return "";
        return getWithEncoding(from, to, quiz.getString(String.format("a%d", answerId)));
    }

    private String getWithEncoding(String from, String to, String s) {
        if (from == null || to == null || s == null)
            return "";
        if (from == "")
            from = "CP1252";
        if (to == "")
            to = "CP1251";

        try {
            return new String(s.getBytes(from), to);
        } catch (UnsupportedEncodingException e) {
            System.out.println("ERROR: Encoding error");
        }
        return "ERROR: Encoding error";
    }
}
