package javase02.t03.model;

import javase02.t02.stationery.*;
import javase02.t04.logic.PackSorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StarterPack implements PackSorting {
    private List<Stationery> pack;

    public void addStationery(Stationery... stationery) {
        for (Stationery s :
                stationery) {
            if (!pack.contains(s))
                pack.add(s);
        }
    }

    public boolean removeStationery(Stationery stationery) {
        return pack.remove(stationery);
    }

    public Stationery[] getStationery() {
        Stationery[] stationeries = new Stationery[pack.size()];
        return pack.toArray(stationeries);
    }

    public StarterPack() {
        pack = new ArrayList<>();
    }

    /**
     * Приватный метод для уменьшения дублирования кода при создании объекта StarterPack с несколькими канцелярскими товарами
     *
     * @param stationery
     */
    private StarterPack(Stationery... stationery) {
        pack = new ArrayList<>();
        for (Stationery s :
                stationery) {
            if (!pack.contains(s))
                pack.add(s);
        }
    }

    public StarterPack(Pen pen, Eraser eraser, Ruler ruler, Pencil pencil) {
        this(pencil, ruler, eraser, pen);
    }

    public StarterPack(Pencil pencil, Eraser eraser, Ruler ruler) {
        this(ruler, eraser, pencil);
    }

    public StarterPack(Pen pen, Pencil pencil, Eraser eraser) {
        this(eraser, pencil, pen);
    }

    public StarterPack(Pen pen) {
        pack = new ArrayList<Stationery>();

        pack.add(pen);
    }

    public void sortByName() {
        pack.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
    }

    public void sortByPrice() {
        pack.sort((o1, o2) -> {
            if (o1.getPrice() - o2.getPrice() + 0.001 > 0)
                return 1;
            else if (Math.abs(o1.getPrice() - o2.getPrice()) < 0.001)
                return 0;
            else
                return -1;
        });
    }

    public void sortByNamePrice() {
        pack.sort((o1, o2) -> {
            if (o1.getPrice() - o2.getPrice() + 0.001 > 0)
                return 1;
            else if (Math.abs(o1.getPrice() - o2.getPrice()) < 0.001)
                return o1.getName().compareToIgnoreCase(o2.getName());
            else
                return -1;
        });
    }

    public String getString(){
        StringBuilder builder = new StringBuilder();
        for (Stationery s:
             pack) {
            builder.append(String.format("name: %s\nprice: %f\ntype: %s\n--------------\n", s.getName(), s.getPrice(), s.getType()));
        }
        return builder.toString();
    }
}
