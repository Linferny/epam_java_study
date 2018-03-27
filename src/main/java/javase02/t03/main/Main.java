package javase02.t03.main;

import javase02.t02.stationery.Eraser;
import javase02.t02.stationery.Pen;
import javase02.t02.stationery.Pencil;
import javase02.t02.stationery.Ruler;
import javase02.t02.stationery.characteristics.Color;
import javase02.t02.stationery.characteristics.Hardness;
import javase02.t02.stationery.characteristics.Material;
import javase02.t03.logic.BadList;
import javase02.t03.model.StarterPack;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main<T> {
    public static void main(String[] args) {
        Pen pen1;
        Pen pen2;
        Pencil pencil1;
        Pencil pencil2;
        Pencil pencil3;
        Ruler ruler1;
        Eraser eraser1;
        Eraser eraser2;


        pen1 = Pen.getBuilder()
                .setName("Parker 1")
                .setPrice(46.75)
                .setColor(Color.BLUE)
                .setLength(7)
                .setMaterial(Material.METAL)
                .build();
        pen2 = Pen.getBuilder()
                .setName("Parker 0")
                .setPrice(15)
                .setColor(Color.BLACK)
                .setLength(11)
                .setMaterial(Material.PLASTIC)
                .build();
        pencil1 = Pencil.getBuilder()
                .setPrice(10)
                .setName("Constructor 1")
                .setMaterial(Material.WOOD)
                .setColor(Color.GREY)
                .setHardness(Hardness.HB)
                .setLength(10)
                .build();
        pencil2 = Pencil.getBuilder()
                .setPrice(20)
                .setName("Constructor 2")
                .setMaterial(Material.WOOD)
                .setColor(Color.GREY)
                .setHardness(Hardness.B2)
                .setLength(10)
                .build();
        pencil3 = Pencil.getBuilder()
                .setPrice(30)
                .setName("Constructor 3")
                .setMaterial(Material.WOOD)
                .setColor(Color.GREY)
                .setHardness(Hardness.H)
                .setLength(10)
                .build();
        ruler1 = Ruler.getBuilder()
                .setName("RULA")
                .setPrice(30)
                .setLength(40)
                .setMaterial(Material.METAL)
                .build();
        eraser1 = Eraser.getBuilder()
                .setName("Milan")
                .setPrice(30)
                .setWeight(10)
                .build();
        eraser2 = Eraser.getBuilder()
                .setName("Milan big")
                .setPrice(46.75)
                .setWeight(20)
                .build();

        StarterPack pack1;
        StarterPack pack2;
        StarterPack pack3;
        StarterPack pack4;

        pack1 = StarterPack.getBuilder(pen2)
                .addEraser(eraser1)
                .addRuler(ruler1)
                .addPencil(pencil2)
                .build();
        pack2 = StarterPack.getBuilder(pencil3)
                .addEraser(eraser1)
                .addRuler(ruler1)
                .build();
        pack3 = StarterPack.getBuilder(pen1)
                .addPencil(pencil1)
                .addEraser(eraser2)
                .build();
        pack4 = StarterPack.getBuilder(pen2)
                .build();

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
