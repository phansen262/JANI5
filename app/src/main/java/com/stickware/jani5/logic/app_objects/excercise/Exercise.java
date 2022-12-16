package com.stickware.jani5.logic.app_objects.excercise;

import android.media.Image;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.stickware.jani5.logic.app_objects.excercise.variant.ExerciseVariant;
import com.stickware.jani5.logic.dictionaries.Muscle;

import java.util.ArrayList;

@Entity
public class Exercise {

    @PrimaryKey() @NonNull private String name;

    @ColumnInfo(name = "description") private String description;
    @ColumnInfo(name = "primary_muscle") private Muscle primaryMuscle;
    @Ignore private Image icon;
    @ColumnInfo(name = "variants") private ArrayList<ExerciseVariant> variants;

    public Exercise(@NonNull String name, String description, Muscle primaryMuscle, ArrayList<ExerciseVariant> variants){

        this.name = name;
        this.description = description;
        this.primaryMuscle = primaryMuscle;
        this.variants = variants;
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

    public Muscle getPrimaryMuscle() {
        return primaryMuscle;
    }

    public void setPrimaryMuscle(Muscle primaryMuscle) {
        this.primaryMuscle = primaryMuscle;
    }

    public Image getIcon() {
        return icon;
    }

    public void setIcon(Image icon) {
        this.icon = icon;
    }

    public ArrayList<ExerciseVariant> getVariants() {
        return variants;
    }

    public void setVariants(ArrayList<ExerciseVariant> variants) {
        this.variants = variants;
    }
}
