package activity;


import model.animals.abstracts.Animal;
import model.animals.abstracts.ObjectIsland;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MapIsland {
    private int widthIsland;
    private int lengthIsland;
    private Location[][] locations;
    private ObjectIslandFactory factory;

    public MapIsland(int lengthIsland, int widthIsland) {
        this.widthIsland = widthIsland;
        this.lengthIsland = lengthIsland;
        this.locations = new Location[getLengthIsland()][getWidthIsland()];
        this.factory = new ObjectIslandFactory();
    }

    public Location[][] getLocations() {
        return locations;
    }

    public int getWidthIsland() {
        return widthIsland;
    }

    public int getLengthIsland() {
        return lengthIsland;
    }

    public void createLocations() {

        for (int row = 0; row < getLengthIsland(); row++) {
            for (int column = 0; column < getWidthIsland(); column++) {
                locations[row][column] = new Location(row, column);
            }
        }
    }

    public void fillingLocations() {
        for (int row = 0; row < getLengthIsland(); row++) {
            for (int column = 0; column < getWidthIsland(); column++) {
                String st = "";
                for (TypesOnIsland types : TypesOnIsland.values()) {
                    int random = ThreadLocalRandom.current().nextInt(1, factory.creatIsland(types).getMaxCountOnLocation());
                    ObjectIsland objectIsland = factory.creatIsland(types);
                    int count = 0;
                    for (int t = 0; t < random; t++) {
                        locations[row][column].getObjectIslands().add(objectIsland);
                        count++;
                    }
                    st += objectIsland.getClass().getSimpleName() + " -> " + count + " ";
                }
                System.out.print("[ " + st + "]");
            }
            System.out.println();
        }
    }

    private void move(Animal animal, Location location) {
        int numberSteps = ThreadLocalRandom.current().nextInt(0, animal.getTravelSpeed());

        while (numberSteps > 0) {
            DirectionOfMovement direction = DirectionOfMovement.values()[ThreadLocalRandom.current().nextInt(DirectionOfMovement.values().length)];
            switch (direction) {
                case FORWARD -> location = forwardStep(animal, location);
                case BACK -> location = backStep(animal, location);
                case LEFT -> location = leftStep(animal, location);
                case RIGHT -> location = rightStep(animal, location);
            }
        }
    }

    private Location forwardStep(Animal animal, Location thisLocation) {
        int thisColumn = thisLocation.getColumn();
        int thisRow = thisLocation.getRow();
        if (thisRow > 0) {
            Location newLocation = getLocations()[thisRow - 1][thisColumn];
            newLocation.addObjectIsland(animal);
            thisLocation.removeObjectIsland(animal);
            return newLocation;
        }
        return thisLocation;
    }

    private Location backStep(Animal animal, Location thisLocation) {
        int thisColumn = thisLocation.getColumn();
        int thisRow = thisLocation.getRow();
        if (thisRow < getLengthIsland() - 1) {
            Location newLocation = getLocations()[thisRow + 1][thisColumn];
            newLocation.addObjectIsland(animal);
            thisLocation.removeObjectIsland(animal);
            return newLocation;
        }
        return thisLocation;
    }

    private Location leftStep(Animal animal, Location thisLocation) {
        int thisColumn = thisLocation.getColumn();
        int thisRow = thisLocation.getRow();
        if (thisColumn > 0) {
            Location newLocation = getLocations()[thisRow][thisColumn - 1];
            newLocation.addObjectIsland(animal);
            thisLocation.removeObjectIsland(animal);
            return newLocation;
        }
        return thisLocation;
    }

    private Location rightStep(Animal animal, Location thisLocation) {
        int thisColumn = thisLocation.getColumn();
        int thisRow = thisLocation.getRow();
        if (thisColumn < getWidthIsland() - 1) {
            Location newLocation = getLocations()[thisRow][thisColumn + 1];
            newLocation.addObjectIsland(animal);
            thisLocation.removeObjectIsland(animal);
            return newLocation;
        }
        return thisLocation;
    }

    public void movingAroundLocations() {
        for (int row = 0; row < getLengthIsland(); row++) {
            for (int column = 0; column < getWidthIsland(); column++) {
                String st = "";
                int count = 0;
                List<Animal> animals = locations[row][column].getAnimals();
                Animal animal = null;
                for (int a = 0; a < animals.size(); a++) {
                    animal = animals.get(a);
                    move(animals.get(a), locations[row][column]);
                    count++;
                }
                st += animal.getClass().getSimpleName() + " -> " + count + " ";
                System.out.print("[ " + st + "]");
            }
            System.out.println();
        }
    }
}
