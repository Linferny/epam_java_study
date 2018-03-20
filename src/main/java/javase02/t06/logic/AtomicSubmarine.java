package javase02.t06.logic;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AtomicSubmarine {
    Engine engine;
    double depth;
    double x;
    double y;

    public AtomicSubmarine(double maxFuel, double fuelPerMove) {
        depth = 0;
        x = 0;
        y = 0;
        engine = new Engine(maxFuel, fuelPerMove);
    }

    public void startEngine() {
        engine.start();
    }

    public void stopEngine() {
        engine.stop();
    }

    public boolean move(Direction direction) {
        if (engine.move()) {
            switch (direction) {
                case UP:
                    depth++;
                    break;
                case DOWN:
                    depth--;
                    break;
                case LEFT:
                    x--;
                    break;
                case RIGHT:
                    x++;
                    break;
                case FORWARD:
                    y++;
                    break;
                case BACKWARD:
                    y--;
                    break;
            }
            System.out.println(String.format("Current position:\ndepht:% 4f| x:% 4f| y:% 4f", depth, x, y));
            return true;
        }
        return false;
    }

    public double fillFuel(double fuel) {
        return engine.fillFuel(fuel);
    }

    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE)
    private class Engine {
        double fuel;
        double maxFuel;
        double fuelPerMove;
        boolean running;

        public Engine(double maxFuel, double fuelPerMove) {
            this.maxFuel = maxFuel;
            this.fuelPerMove = fuelPerMove;
            fuel = 0;
        }

        public void start() {
            try {
                System.out.println("Starting engine...");
                Thread.sleep(500);
            } catch (InterruptedException e) {

            }
            running = true;
            System.out.println("Engine is running!");
        }

        public void stop() {
            try {
                System.out.println("Stopping engine...");
                Thread.sleep(300);
            } catch (InterruptedException e) {

            }
            running = false;
            System.out.println("Engine stopped!");
        }

        public boolean move() {
            if (!running) {
                System.out.println("Start engine first!");
                return false;
            }
            if (fuel - fuelPerMove < 0)
                return false;
            try {
                System.out.println("Engine move vehicle!");
                System.out.println(String.format("Current fuel: %f", fuel));
                Thread.sleep(300);
            } catch (InterruptedException e) {

            }
            fuel -= fuelPerMove;
            return true;
        }

        public double fillFuel(double fuel) {
            if (fuel <= 0) {
                System.out.println("Wrong fuel count!");
                return 0;
            }
            System.out.println("Fill engine with fuel!");
            if (this.fuel + fuel > maxFuel) {
                double surplus = fuel + this.fuel - maxFuel;
                this.fuel = maxFuel;
                return surplus;
            }
            this.fuel += fuel;
            return 0;
        }
    }
}
