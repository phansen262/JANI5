package com.stickware.jani5.logic.app_objects_2.exercise;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity
public class EPlanSO {

    //Contains: "exerciseName<@>workoutRecord<@>workoutIndex"
    @PrimaryKey @NonNull private String recordKey;

    @Embedded(prefix = "exercise") private ExerciseSO exerciseSO;
    @Embedded(prefix = "variant") private EVariantSO eVariantSO;

    @ColumnInfo(name = "sets") private int sets;
    @ColumnInfo(name = "reps") private int reps;

    @Embedded(prefix = "set_values") ArrayList<Integer> setValues;
    @Embedded(prefix = "durations") ArrayList<Integer> durations;

    public EPlanSO(@NonNull String recordKey, ExerciseSO exerciseSO, EVariantSO eVariantSO,
                     int sets, int reps, ArrayList<Integer> setValues, ArrayList<Integer> durations){
        this.recordKey = recordKey;
        this.exerciseSO = exerciseSO;
        this.eVariantSO = eVariantSO;
        this.sets = sets;
        this.reps = reps;
        this.setValues = setValues;
        this.durations = durations;
    }

    @Ignore
    public EPlanSO(){}

    @NonNull
    public String getRecordKey() {
        return recordKey;
    }

    public void setRecordKey(@NonNull String recordKey) {
        this.recordKey = recordKey;
    }

    public ExerciseSO getExerciseSO() {
        return exerciseSO;
    }

    public void setExerciseSO(ExerciseSO exerciseSO) {
        this.exerciseSO = exerciseSO;
    }

    public EVariantSO getEVariantSO() {
        return eVariantSO;
    }

    public void setEVariantSO(EVariantSO eVariantSO) {
        this.eVariantSO = eVariantSO;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public ArrayList<Integer> getSetValues() {
        return setValues;
    }

    public void setSetValues(ArrayList<Integer> setValues) {
        this.setValues = setValues;
    }

    public ArrayList<Integer> getDurations() {
        return durations;
    }

    public void setDurations(ArrayList<Integer> durations) {
        this.durations = durations;
    }
}
