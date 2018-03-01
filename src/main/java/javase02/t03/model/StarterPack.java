package javase02.t03.model;

import javase02.t02.stationery.*;

public class StarterPack {
    private Pen pen;
    private Pencil pencil;
    private Eraser eraser;
    private Ruler ruler;

    public Pen getPen() {
        return pen;
    }

    public void setPen(Pen pen) {
        if (pen != null)
            this.pen = pen;
    }

    public Pencil getPencil() {
        return pencil;
    }

    public void setPencil(Pencil pencil) {
        if (pencil != null)
            this.pencil = pencil;
    }

    public Eraser getEraser() {
        return eraser;
    }

    public void setEraser(Eraser eraser) {
        if (eraser != null)
            this.eraser = eraser;
    }

    public Ruler getRuler() {
        return ruler;
    }

    public void setRuler(Ruler ruler) {
        if (ruler != null)
            this.ruler = ruler;
    }

    public StarterPack(Pen pen, Pencil pencil, Eraser eraser, Ruler ruler) {
        if (pen == null || pencil == null || eraser == null || ruler == null)
            return;
        this.pen = pen;
        this.pencil = pencil;
        this.eraser = eraser;
        this.ruler = ruler;
    }

    public Stationery[] getAllItems(){
        return new Stationery[]{pen, pencil, eraser, ruler};
    }
}
