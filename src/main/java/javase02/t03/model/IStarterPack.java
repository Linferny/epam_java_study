package javase02.t03.model;

import javase02.t02.stationery.*;

public interface IStarterPack {
    Stationery[] getStationeries();

    interface Builder<T extends IStarterPack, V extends Builder<T,V>>{
        T build();
        V addPen(Pen pen);
        V addPencil(Pencil pencil);
        V addEraser(Eraser eraser);
        V addRuler(Ruler ruler);
    }
}
