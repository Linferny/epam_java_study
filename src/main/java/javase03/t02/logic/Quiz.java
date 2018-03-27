package javase03.t02.logic;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.Locale;
import java.util.ResourceBundle;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Quiz {
    ResourceBundle quiz;
    Locale localeRU;
    Locale localeEN;
    int questionId;

    public Quiz(){
        questionId = 1;
        localeRU = new Locale("RU", "ru");
        localeEN = new Locale("EN", "us");
        quiz = ResourceBundle.getBundle("quiz", localeRU);
    }

    public void setLocaleRU(){
        if (quiz.getLocale().equals(localeRU))
            return;
        quiz = ResourceBundle.getBundle("quiz", localeRU);
    }

    public void setLocaleEN(){
        if (quiz.getLocale().equals(localeEN))
            return;
        quiz = ResourceBundle.getBundle("quiz", localeEN);
    }

    public String getQuestion(){
        return quiz.getString(String.format("q%d", questionId));
    }
}
