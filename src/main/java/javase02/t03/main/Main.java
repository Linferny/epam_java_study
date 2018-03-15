package javase02.t03.main;

import javase02.t02.stationery.Eraser;
import javase02.t02.stationery.Pen;
import javase02.t02.stationery.Pencil;
import javase02.t02.stationery.Ruler;
import javase02.t02.stationery.characteristics.Color;
import javase02.t02.stationery.characteristics.Hardness;
import javase02.t02.stationery.characteristics.Material;
import javase02.t03.model.StarterPack;

public class Main {
    public static void main(String[] args) {
        Pen pen1;
        Pen pen2;
        Pencil pencil1;
        Pencil pencil2;
        Pencil pencil3;
        Ruler ruler1;
        Eraser eraser1;
        Eraser eraser2;

        pen1 = new Pen(46.75, "Parker Simple", 7,Material.METAL, Color.BLACK);
        pen2 = new Pen(15, "Parker Plastic", 11, Material.PLASTIC, Color.BLACK);
        pencil1 = new Pencil(10, "Constructor 1",Material.WOOD, Color.GREY, Hardness.HB, 10);
        pencil2 = new Pencil(15, "Constructor 2", Material.WOOD, Color.GREY, Hardness.B2, 10);
        pencil3 = new Pencil(30, "Constructor 3", Material.WOOD, Color.GREY, Hardness.H, 10);
        ruler1 = new Ruler(30, "Ruler", 30, Material.WOOD);
        eraser1 = new Eraser(30, "Milan", 10);
        eraser2 = new Eraser(46.75, "Milan big", 20);

        StarterPack pack1;
        StarterPack pack2;
        StarterPack pack3;
        StarterPack pack4;

        pack1 = new StarterPack(pen2, eraser1, ruler1, pencil2);
        pack2 = new StarterPack(pencil3, eraser1, ruler1);
        pack3 = new StarterPack(pen1, pencil1, eraser2);
        pack4 = new StarterPack(pen2);

        System.out.println("Pack1 before sort:");
        System.out.println(pack1.getString());
        System.out.println("Pack1 after sort by name:");
        pack1.sortByName();
        System.out.println(pack1.getString());
        System.out.println();


        System.out.println("Pack2 before sort:");
        System.out.println(pack2.getString());
        System.out.println("Pack2 after sort by price:");
        pack2.sortByPrice();
        System.out.println(pack2.getString());
        System.out.println();


        System.out.println("Pack3 before sort:");
        System.out.println(pack3.getString());
        System.out.println("Pack3 after sort by name and price:");
        pack3.sortByNamePrice();
        System.out.println(pack3.getString());
        System.out.println();


        System.out.println("Pack4 before sort:");
        System.out.println(pack4.getString());
        System.out.println("Pack4 after sort by name and price:");
        pack4.sortByNamePrice();
        System.out.println(pack4.getString());
    }
}
