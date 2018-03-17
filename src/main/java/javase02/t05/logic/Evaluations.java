package javase02.t05.logic;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Evaluations <T extends Number & Comparable<? super T>> {
    List<Mark<T>> marks;

    public Evaluations(){
        marks = new ArrayList<Mark<T>>();
    }

    public void addMark(Mark mark){
        marks.add(mark);
    }

    public boolean removeMark(Mark mark){
        return marks.remove(mark);
    }

    public Mark[] getMarks(){
        return marks.toArray(new Mark[marks.size()]);
    }
}
