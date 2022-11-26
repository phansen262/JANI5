package com.stickware.jani5.logic.app_objects.equipment;

public class EquipmentLifespan {

    public enum LifespanType {

        MILEAGE,
        UNIT;
    }

    private LifespanType lifespanType;
    private int maxLife;
    private int lifeIncrementFactor;

    public EquipmentLifespan(LifespanType lifespanType, int maxLife, int lifeIncrementFactor){

        this.lifespanType = lifespanType;
        this.maxLife = maxLife;
        this.lifeIncrementFactor = lifeIncrementFactor;
    }

    //Getters and Setters


    public LifespanType getLifespanType() {
        return lifespanType;
    }

    public void setLifespanType(LifespanType lifespanType) {
        this.lifespanType = lifespanType;
    }

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
