package model.animals.abstracts;

public abstract class Animal extends ObjectIsland {
    private int travelSpeed;
    private double maxCountSaturation;

    protected Animal(double weight, int maxCountOnLocation, int travelSpeed, double maxCountSaturation) {
        super(weight, maxCountOnLocation);
        this.travelSpeed = travelSpeed;
        this.maxCountSaturation = maxCountSaturation;
    }

    public int getTravelSpeed() {
        return travelSpeed;
    }

    public double getMaxCountSaturation() {
        return maxCountSaturation;
    }

    @Override
    public abstract void reproduce();

    public abstract void eat();
}
