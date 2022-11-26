package com.stickware.jani5.logic.app_objects.equipment;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class EquipmentLifespan {

    public enum LifespanType {

        MILEAGE,
        UNIT,
        WORKOUTS;
    }

    @PrimaryKey(autoGenerate = true) public int uid;
    @ColumnInfo(name = "type") private LifespanType lifespanType;
    @ColumnInfo(name = "increment_factor") private int lifeIncrementFactor;

    public EquipmentLifespan(LifespanType lifespanType, int lifeIncrementFactor){

        this.lifespanType = lifespanType;
        this.lifeIncrementFactor = lifeIncrementFactor;
    }

    //Getters and Setters


    public LifespanType getLifespanType() {
        return lifespanType;
    }

    public void setLifespanType(LifespanType lifespanType) {
        this.lifespanType = lifespanType;
    }

    public int getLifeIncrementFactor() {
        return lifeIncrementFactor;
    }

    public void setLifeIncrementFactor(int lifeIncrementFactor) {
        this.lifeIncrementFactor = lifeIncrementFactor;
    }
}
