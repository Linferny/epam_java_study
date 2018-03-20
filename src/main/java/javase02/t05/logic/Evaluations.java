package javase02.t05.logic;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Evaluations<T extends Number & Comparable<? super T>> {
    List<Mark<T>> marks;

    public Evaluations() {
        marks = new ArrayList<>();
    }

    public void addMark(T mark) {
        marks.add(new Mark<>(mark, LocalDateTime.now()));
    }

    public boolean removeMark(Mark mark) {
        return marks.remove(mark);
    }

    @Override
    public String toString() {
        StringBuilder strBld = new StringBuilder();
        for (Mark m :
                marks) {
            strBld.append(m.toString());
            strBld.append(",");
        }
        return strBld.toString();
    }
}
