package com.stickware.jani5.logic.app_objects.excercise.variant;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.stickware.jani5.logic.dictionaries.Muscle;
import com.stickware.jani5.logic.dictionaries.Weight;

import java.util.ArrayList;

@Entity
public class ExerciseVariant {

    @PrimaryKey @NonNull String name;
    @ColumnInfo(name = "description") private String description;
    @ColumnInfo(name = "weight") private Weight weight;
    //@ColumnInfo(name = "equipment") private ArrayList<Equipment> equipmentList;
    @Embedded(prefix = "this_test") ArrayList<Muscle> secondaryMuscles;

    public ExerciseVariant(@NonNull String name, String description, Weight weight, ArrayList<Muscle> secondaryMuscles){

        this.name = name;
        this.description = description;
        this.weight = weight;
        this.secondaryMuscles = secondaryMuscles;
    }

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

    public ArrayList<Muscle> getSecondaryMuscles() {
        return secondaryMuscles;
    }

    public void setSecondaryMuscles(ArrayList<Muscle> secondaryMuscles) {
        this.secondaryMuscles = secondaryMuscles;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }
}
