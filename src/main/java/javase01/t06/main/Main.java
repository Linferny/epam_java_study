package javase01.t06.main;

import javase01.t06.notepad.Notepad;

public class Main {
    public static void main(String[] args) {
        Notepad notepad = new Notepad();

        notepad.addNote("First note!");
        notepad.addNote("Second NOTE?");

        notepad.deleteNote(-12);

        for (String s :
                notepad.getAllNotes()) {
            System.out.println(s);
        }
        System.out.println("--------------------");

        notepad.editNote(0, 0, 5, "THIRD GREATFULL");

        for (String s :
                notepad.getAllNotes()) {
            System.out.println(s);
        }
        System.out.println("--------------------");

        notepad.deleteNote(1);

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
