package com.stickware.jani5.logic.app_objects_2.equipment;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.stickware.jani5.logic.dictionaries.MSport;

import io.reactivex.rxjava3.annotations.NonNull;

@Entity
public class EquipmentSO extends AbstractEquipmentSO {

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

    @ColumnInfo(name = "lifespan_type") private LifespanType lifespanType;
    @ColumnInfo(name = "max_life") private int maxLife;

    public EquipmentSO(String name, String description, MSport.Sport sport, int iconID, LifespanType lifespanType, int maxLife) {
        super(name, description, sport, iconID);
        this.lifespanType = lifespanType;
        this.maxLife = maxLife;
    }

    @Ignore
    protected EquipmentSO(){}

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
}
