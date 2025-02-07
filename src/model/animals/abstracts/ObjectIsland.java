package model.animals.abstracts;

public abstract class ObjectIsland {
    private double weight;
    private int maxCountOnLocation;

    protected ObjectIsland(double weight, int maxCountOnLocation) {
        this.weight = weight;
        this.maxCountOnLocation = maxCountOnLocation;
    }

    public double getWeight() {
        return weight;
    }

    public int getMaxCountOnLocation() {
        return maxCountOnLocation;
    }

    public abstract void reproduce();
}