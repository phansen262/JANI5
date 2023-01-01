package com.stickware.jani5.logic.app_objects_2.exercise;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.stickware.jani5.logic.dictionaries.MMuscle;
import com.stickware.jani5.logic.dictionaries.MWeight;

import java.util.ArrayList;

@Entity
public class EVariantSO {

    @PrimaryKey @NonNull private String name;

    @ColumnInfo(name = "description") private String description;
    @ColumnInfo(name = "instructions") private String instructions;
    @ColumnInfo(name = "weight_type") private MWeight.WeightType weightType;

    @Embedded(prefix = "secondary_muscles") private ArrayList<MMuscle.Muscle> secondaryMuscles;

    public EVariantSO(@NonNull String name, String description, String instructions, MWeight.WeightType weightType,
                      ArrayList<MMuscle.Muscle> secondaryMuscles){

        this.name = name;
        this.description = description;
        this.instructions = instructions;
        this.weightType = weightType;
        this.secondaryMuscles = secondaryMuscles;
    }

    @Ignore
    public EVariantSO(){}

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public MWeight.WeightType getWeightType() {
        return weightType;
    }

    public void setWeightType(MWeight.WeightType weightType) {
        this.weightType = weightType;
    }

    public ArrayList<MMuscle.Muscle> getSecondaryMuscles() {
        return secondaryMuscles;
    }

    public void setSecondaryMuscles(ArrayList<MMuscle.Muscle> secondaryMuscles) {
        this.secondaryMuscles = secondaryMuscles;
    }
}
