package com.stickware.jani5.logic.app_objects.excercise.variant;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.stickware.jani5.logic.dictionaries.Muscle;

import java.util.ArrayList;

@Entity
public class ExerciseVariant {

    @PrimaryKey @NonNull String name;

    @ColumnInfo(name = "description") String description;
    @ColumnInfo(name = "secondary_muscles") ArrayList<Muscle> secondaryMuscles;

    public ExerciseVariant(@NonNull String name, String description, ArrayList<Muscle> secondaryMuscles){

        this.name = name;
        this.description = description;
        this.secondaryMuscles = secondaryMuscles;
    }
}
