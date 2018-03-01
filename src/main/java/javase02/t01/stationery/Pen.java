package javase02.t01.stationery;

import javase02.t01.stationery.characteristics.InkColor;
import javase02.t01.stationery.characteristics.PenMaterial;
import javase02.t01.stationery.characteristics.PenType;

import java.util.Objects;

public class Pen {
    private double length;
    private double ballSize;
    private InkColor inkColor;
    private PenMaterial bodyMaterial;
    private PenType penType;
    private double price;

    public double getLength() {
        return length;
    }

    public double getBallSize() {
        return ballSize;
    }

    public InkColor getInkColor() {
        return inkColor;
    }

    public PenMaterial getBodyMaterial() {
        return bodyMaterial;
    }

    public PenType getPenType() {
        return penType;
    }

    public double getPrice() {
        return price;
    }

    public Pen(int length, double ballSize, InkColor inkColor, PenMaterial bodyMaterial, PenType penType, double price) {
        this.length = length;
        this.ballSize = ballSize;
        this.inkColor = inkColor;
        this.bodyMaterial = bodyMaterial;
        this.penType = penType;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null)
            return false;
        if (obj.getClass() != getClass())
            return true;
        Pen pen = (Pen) obj;
        return Math.abs(price - pen.price) < 0.01 &&
                Math.abs(length - pen.length) < 0.01 &&
                Math.abs(ballSize - pen.ballSize) < 0.01 &&
                inkColor == pen.inkColor &&
                bodyMaterial == pen.bodyMaterial &&
                penType == pen.penType;
    }

    @Override
    public String toString() {
        return String.format("%s;penType=%s;bodyMaterial=%s;inkColor=%s;ballSize=%f;length=%f;price=%f", getClass().getName(), penType, bodyMaterial, inkColor, ballSize, length, price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, ballSize, inkColor, bodyMaterial, penType, price);
    }
}
