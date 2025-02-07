package activity;


import model.animals.abstracts.Animal;
import model.animals.abstracts.ObjectIsland;

import java.util.ArrayList;
import java.util.*;

public class Location {
    private int row;
    private int column;
    private List<ObjectIsland> objectIslands;

    public Location(int posX, int posY) {
        this.row = posX;
        this.column = posY;
        this.objectIslands = new ArrayList<>();
    }

    public void addObjectIsland(ObjectIsland objectIsland) {
        objectIslands.add(objectIsland);
    }

    public void removeObjectIsland(ObjectIsland objectIsland) {
        objectIslands.remove(objectIsland);
    }

    public List<ObjectIsland> getObjectIslands() {
        return objectIslands;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public List<Animal> getAnimals() {
        return objectIslands.stream()
                .filter(objectIslands -> objectIslands instanceof Animal)
                .map(objectIslands -> (Animal) objectIslands)
                .toList();
    }
}

