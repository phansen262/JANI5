package com.stickware.jani5.logic.app_objects_2.training_plan;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class TpPhaseSO {

    //ID is "phaseName<@>phaseIndex<@>trainingPlanName"
    @PrimaryKey @NonNull String phaseID;

    @ColumnInfo(name = "phase_type") private TpPhase.Type phaseType;
    @ColumnInfo(name = "start_date") private int startDate;
    @ColumnInfo(name = "end_date") private int endDate;

    public TpPhaseSO(String phaseID, TpPhase.Type phaseType, int startDate, int endDate){
        this.phaseID = phaseID;
        this.phaseType = phaseType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Ignore public TpPhaseSO(){}

    @NonNull
    public String getPhaseID() {
        return phaseID;
    }

    public void setPhaseID(@NonNull String phaseID) {
        this.phaseID = phaseID;
    }

    public TpPhase.Type getPhaseType() {
        return phaseType;
    }

    public void setPhaseType(TpPhase.Type phaseType) {
        this.phaseType = phaseType;
    }

    public int getStartDate() {
        return startDate;
    }

    public void setStartDate(int startDate) {
        this.startDate = startDate;
    }

    public int getEndDate() {
        return endDate;
    }

    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }
}
