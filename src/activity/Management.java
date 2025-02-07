package activity;

public class Management {
    private MapIsland mapIsland;

    public Management() {
        this.mapIsland = new MapIsland(100, 20);
    }

    public void start() {
        mapIsland.createLocations();
        mapIsland.fillingLocations();
        //mapIsland.movingAroundLocations();
    }
}