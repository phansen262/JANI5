package com.stickware.jani5.logic.app_objects_2.workout;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.stickware.jani5.logic.app_objects_2.equipment.EModelSO;
import com.stickware.jani5.logic.app_objects_2.location.LocationSO;

import java.util.ArrayList;

@Entity
public class WorkoutSO {

    @PrimaryKey @NonNull private String name;

    @Embedded(prefix = "location") private LocationSO location;
    @Embedded(prefix = "equipment") private ArrayList<EModelSO> equipment;

    public WorkoutSO(String name, LocationSO location, ArrayList<EModelSO> equipment){
        this.name = name;
        this.location = location;
        this.equipment = equipment;
    }

    @Ignore public WorkoutSO(){}

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public LocationSO getLocation() {
        return location;
    }

    public void setLocation(LocationSO location) {
        this.location = location;
    }

    public ArrayList<EModelSO> getEquipment() {
        return equipment;
    }

    public void setEquipment(ArrayList<EModelSO> equipment) {
        this.equipment = equipment;
    }
}
