package javase02.t05.main;

import javase02.t05.logic.*;

import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        GroupLogic groupLogic = new GroupLogic();

        Student[] students = new Student[10];
        for (int i = 0; i < students.length; ++i) {
            students[i] = new Student();
            students[i].generateRandom();
        }

        Group<Integer> math1 = new Group<>(Discipline.MATHEMATICS, 0, 100);
        Group<Integer> math2 = new Group<>(Discipline.MATHEMATICS, 0, 100);
        Group<Double> philos = new Group<>(Discipline.PHILOSOPHY, 0.0, 10.0);
        Group<Integer> phys = new Group<>(Discipline.PHYSICS, 1, 5);
        Group<Integer> lang = new Group<>(Discipline.LANGUAGE, 1, 10);

        groupLogic.addGroup(math1);
        groupLogic.addGroup(math2);
        groupLogic.addGroup(philos);
        groupLogic.addGroup(phys);
        groupLogic.addGroup(lang);

        Random rand = new Random();

        for (Student student :
                students) {
            if (rand.nextBoolean())
                for (int i = 0; i < 10 + rand.nextInt(10); i++) {
                    math1.addMark(student, rand.nextInt(101));
                }
            if (rand.nextBoolean())
                for (int i = 0; i < 10 + rand.nextInt(10); i++) {
                    math2.addMark(student, rand.nextInt(101));
                }
            if (rand.nextBoolean())
                for (int i = 0; i < 10 + rand.nextInt(10); i++) {
                    philos.addMark(student, rand.nextInt(101) / 10.0);
                }
            if (rand.nextBoolean())
                for (int i = 0; i < 10 + rand.nextInt(10); i++) {
                    phys.addMark(student, 1 + rand.nextInt(5));
                }
            if (rand.nextBoolean())
                for (int i = 0; i < 10 + rand.nextInt(10); i++) {
                    lang.addMark(student, 1 + rand.nextInt(10));
                }
        }

        HashMap<Group, Evaluations> marks = groupLogic.getMarks(students[3]);

        System.out.println(students[3].toString());
        for (Group group :
                groupLogic.getGroups()) {
            if (marks.containsKey(group)) {
                System.out.println(String.format("%s: %s", group.getDiscipline().name(), marks.get(group).toString()));
            }
        }
    }
}
