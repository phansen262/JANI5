package com.stickware.jani5.logic.app_objects.excercise;

import android.media.Image;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.stickware.jani5.logic.app_objects.excercise.log.ExerciseLog;
import com.stickware.jani5.logic.app_objects.excercise.variant.ExerciseVariant;
import com.stickware.jani5.logic.dictionaries.Muscle;
import com.stickware.jani5.logic.dictionaries.Weight;

import java.util.ArrayList;

@Entity
public class Exercise {

    @PrimaryKey() @NonNull private String name;

    @ColumnInfo(name = "primary_muscle") private Muscle primaryMuscle;
    @ColumnInfo(name = "record_type") private ExerciseLog.LogType logType;

    @Ignore private Image icon;
    @Embedded(prefix = "variants") private ArrayList<ExerciseVariant> variants;

    public Exercise(@NonNull String name, Muscle primaryMuscle, ExerciseLog.LogType logType, ArrayList<ExerciseVariant> variants){

        this.name = name;
        this.primaryMuscle = primaryMuscle;
        this.logType = logType;
        this.variants = variants;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public Muscle getPrimaryMuscle() {
        return primaryMuscle;
    }

    public void setPrimaryMuscle(Muscle primaryMuscle) {
        this.primaryMuscle = primaryMuscle;
    }

    public ExerciseLog.LogType getLogType() {
        return logType;
    }

    public void setLogType(ExerciseLog.LogType logType) {
        this.logType = logType;
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
