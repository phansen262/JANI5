package com.stickware.jani5.logic.app_objects_2.training_plan;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class TrainingPlanSO {

    @PrimaryKey @NonNull private String name;

    public TrainingPlanSO(@NonNull String name){
        this.name = name;
    }

    @Ignore public TrainingPlanSO(){}

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }
}
