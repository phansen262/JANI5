package com.stickware.jani5.logic.app_objects.equipment;

public class EquipmentLifespan {

    public enum LifespanType {

        MILEAGE,
        UNIT;
    }

    private int maxLife;
    private int lifeIncrementFactor;

    public EquipmentLifespan(int currentLife, int maxLife, int lifeIncrementFactor){

        this.maxLife = maxLife;
        this.lifeIncrementFactor = lifeIncrementFactor;
    }

    //Getters and Setters
    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getLifeIncrementFactor() {
        return lifeIncrementFactor;
    }

    public void setLifeIncrementFactor(int lifeIncrementFactor) {
        this.lifeIncrementFactor = lifeIncrementFactor;
    }
}
