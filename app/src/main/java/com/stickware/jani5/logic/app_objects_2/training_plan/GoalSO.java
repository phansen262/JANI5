package com.stickware.jani5.logic.app_objects_2.training_plan;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;

@Entity(primaryKeys = {"initiate_time", "name"})
public class GoalSO {

    @ColumnInfo(name = "initiate_time") @NonNull private int initiateTime;
    @ColumnInfo(name = "name") @NonNull private String name;

    @ColumnInfo(name = "goal_type") private Goal.Type goalType;

    public GoalSO(int initiateTime, String name, Goal.Type goalType){
        this.initiateTime = initiateTime;
        this.name = name;
        this.goalType = goalType;
    }

    @Ignore public GoalSO(){}

    public int getInitiateTime() {
        return initiateTime;
    }

    public void setInitiateTime(int initiateTime) {
        this.initiateTime = initiateTime;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public Goal.Type getGoalType() {
        return goalType;
    }

    public void setGoalType(Goal.Type goalType) {
        this.goalType = goalType;
    }
}
