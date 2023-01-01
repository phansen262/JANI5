package com.stickware.jani5.logic.app_objects_2.exercise;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.stickware.jani5.logic.dictionaries.MMuscle;
import com.stickware.jani5.logic.dictionaries.MSport;

@Entity
public class ExerciseSO {

    @PrimaryKey @NonNull private String name;

    @ColumnInfo(name = "description") private String description;
    @ColumnInfo(name = "sport") private MSport.Sport sport;
    @ColumnInfo(name = "primary_muscle") private MMuscle.Muscle primaryMuscle;
    @ColumnInfo(name = "icon_id") private int iconID;

    public ExerciseSO(@NonNull String name, String description, MSport.Sport sport,
                      MMuscle.Muscle primaryMuscle, int iconID){
        this.name = name;
        this.description = description;
        this.sport = sport;
        this.primaryMuscle = primaryMuscle;
        this.iconID = iconID;
    }

    @Ignore public ExerciseSO() {}

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

    public MSport.Sport getSport() {
        return sport;
    }

    public void setSport(MSport.Sport sport) {
        this.sport = sport;
    }

    public MMuscle.Muscle getPrimaryMuscle() {
        return primaryMuscle;
    }

    public void setPrimaryMuscle(MMuscle.Muscle primaryMuscle) {
        this.primaryMuscle = primaryMuscle;
    }

    protected int getIconID() {
        return iconID;
    }

    protected void setIconID(int iconID) {
        this.iconID = iconID;
    }
}
