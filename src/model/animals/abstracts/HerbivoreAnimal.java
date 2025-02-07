package model.animals.abstracts;

public abstract class HerbivoreAnimal extends Animal {
    protected HerbivoreAnimal(double weight, int maxCountOnLocation, int travelSpeed, double maxCountSaturation) {
        super(weight, maxCountOnLocation, travelSpeed, maxCountSaturation);
    }

    @Override
    public void reproduce() {

    }

    @Override
    public void eat() {

    }
}