package javase02.t06.main;

import javase02.t06.logic.AtomicSubmarine;
import javase02.t06.logic.Direction;

public class Main {
    public static void main(String[] args) {
        AtomicSubmarine submarine = new AtomicSubmarine(100.0, 0.1);

        submarine.move(Direction.BACKWARD);
        submarine.fillFuel(20.0);
        submarine.startEngine();
        submarine.move(Direction.UP);
        submarine.move(Direction.FORWARD);
        submarine.stopEngine();
    }
}
