package javase02.t05.logic;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.HashMap;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Group<T extends Number & Comparable<? super T>> {

    private Discipline discipline;
    private T min,
            max;
    private HashMap<Student, Evaluations<T>> studentsEvaluations;

    public Group(Discipline discipline, T min, T max) {
        this.discipline = discipline;
        this.min = min;
        this.max = max;
        this.studentsEvaluations = new HashMap<Student, Evaluations<T>>();
    }

    public Mark[] getEvaluations(Student student) {
        Evaluations evals = studentsEvaluations.get(student);
        if (evals == null)
            return null;
        return evals.getMarks();
    }

    public void addMark(Student student, Mark mark) {
        if (mark.compare(min) < 0 || mark.compare(max) > 0)
            return;
        studentsEvaluations.get(student)
                .addMark(mark);
    }

    public boolean removeMark(Student student, Mark mark) {
        return studentsEvaluations.get(student)
                .removeMark(mark);
    }
}
