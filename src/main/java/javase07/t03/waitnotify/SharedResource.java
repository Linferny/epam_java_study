package javase07.t03.waitnotify;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    private List<Integer> list;
    @Getter
    private ReentrantLock locker = new ReentrantLock();

    public SharedResource() {
        list = new ArrayList<>();
    }

    public void setElement(Integer element) {
        list.add(element);
    }

    public Integer getELement() {
        if (list.size() > 0) {
            return list.remove(0);
        }
        return null;
    }
}
