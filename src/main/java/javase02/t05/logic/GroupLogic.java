package javase02.t05.logic;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class GroupLogic {
    List<Group> groups;

    public GroupLogic() {
        groups = new ArrayList<>();
    }

    public <T extends Number & Comparable<? super T>> void addGroup(Discipline discipline, T min, T max) {
        groups.add(new Group<>(discipline, min, max));
    }
    public  void addGroup(Group group) {
        groups.add(group);
    }

    public HashMap<Group, Evaluations> getMarks(Student student) {
        HashMap<Group, Evaluations> marks = new HashMap<>();
        for (Group g :
                groups) {
            Evaluations evals = g.getEvaluations(student);
            if (evals != null)
                marks.put(g, evals);
        }
        return marks;
    }

    public Group[] getGroups() {
        return groups.toArray(new Group[groups.size()]);
    }
}
