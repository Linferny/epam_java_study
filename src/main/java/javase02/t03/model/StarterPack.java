package javase02.t03.model;

import javase02.t02.stationery.*;
import javase02.t03.logic.BadList;
import javase02.t04.logic.PackSorting;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StarterPack implements PackSorting, IStarterPack {
    private BadList<IStationery> pack;

    private StarterPack(Pen pen) {
        pack = new BadList<>();
        pack.add(pen);
    }

    private StarterPack(Pencil pencil) {
        pack = new BadList<>();
        pack.add(pencil);
    }

    public static class Builder implements IStarterPack.Builder<StarterPack, Builder> {

        private StarterPack starterPack;

        private Builder init(StarterPack starterPack) {
            this.starterPack = starterPack;
            return this;
        }

        @Override
        public StarterPack build() {
            try {
                return starterPack;
            } finally {
                starterPack = null;
            }
        }

        @Override
        public Builder addPen(Pen pen) {
            starterPack.pack.add(pen);
            return this;
        }

        @Override
        public Builder addPencil(Pencil pencil) {
            starterPack.pack.add(pencil);
            return this;
        }

        @Override
        public Builder addEraser(Eraser eraser) {
            starterPack.pack.add(eraser);
            return this;
        }

        @Override
        public Builder addRuler(Ruler ruler) {
            starterPack.pack.add(ruler);
            return this;
        }
    }

    private static Builder builder;

    public static Builder getBuilder(Pen pen) {
        if (builder == null)
            builder = new Builder();
        return builder.init(new StarterPack(pen));
    }

    public static Builder getBuilder(Pencil pencil) {
        if (builder == null)
            builder = new Builder();
        return builder.init(new StarterPack(pencil));
    }

    @Override
    public void sortByName() {
        pack.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
    }

    @Override
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

    @Override
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

    public String getString() {
        StringBuilder sb = new StringBuilder();
        for (IStationery s :
                pack.toArray(IStationery.class)) {
            sb.append(s.toString());
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override
    public Stationery[] getStationeries() {
        Stationery[] stationeries = new Stationery[pack.getSize()];
        return (Stationery[])pack.toArray(IStationery.class);
    }
}
