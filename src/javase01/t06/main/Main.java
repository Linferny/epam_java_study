package javase01.t06.main;

import javase01.t06.notepad.Notepad;
import javase01.t06.exception.InvalidNodeIndexException;

public class Main {
    public static void main(String[] args) {
        Notepad notepad = new Notepad();

        notepad.addNote("First note!");
        notepad.addNote("Second NOTE?");
        try {
            notepad.deleteNote(-12);
        } catch (InvalidNodeIndexException e) {
            System.out.println(e);
        }
        for (String s :
                notepad.getAllNotes()) {
            System.out.println(s);
        }
        System.out.println("--------------------");

        try {
            notepad.editNote(0, 0, 5, "THIRD GREATFULL");
        } catch (InvalidNodeIndexException e) {
            System.out.println(e);
        }
        for (String s :
                notepad.getAllNotes()) {
            System.out.println(s);
        }
        System.out.println("--------------------");
        try {
            notepad.deleteNote(1);
        } catch (InvalidNodeIndexException e) {
            System.out.println(e);
        }
        for (String s :
                notepad.getAllNotes()) {
            System.out.println(s);
        }
        System.out.println("--------------------");

        notepad.addNote("4th last note...");

        for (String s :
                notepad.getAllNotes()) {
            System.out.println(s);
        }
        System.out.println("--------------------");
    }
}
