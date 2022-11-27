package com.stickware.jani5.logic.app_objects.equipment;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity
public class EquipmentLifespan {

    public enum LifespanType {

        MILEAGE("Miles", "Miles"),
        UNIT("Unit", "Uses"),
        WORKOUTS("Workouts", "Workouts");

        private final String display;
        private final String unit;

        LifespanType(String display, String unit){
            this.display = display;
            this.unit = unit;
        }
    }

    public static List<String> getEnumDisplayList(){
        List<String> returnList = new ArrayList<>();
        for(LifespanType item : LifespanType.values()){
            returnList.add(item.display);
        }
        return returnList;
    }

    public static LifespanType getTypeFromDisplay(String display){
        LifespanType retType = null;
        for(LifespanType item : LifespanType.values()){
            if(item.display.equals(display)){
                retType = item;
            }
        }
        return retType;
    }

    @PrimaryKey(autoGenerate = true) public int uid;
    @ColumnInfo(name = "type") private LifespanType lifespanType;
    @ColumnInfo(name = "increment_factor") private int lifeIncrementFactor;

    public EquipmentLifespan(){}

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
