package com.stickware.jani5.logic.app_objects_2.equipment;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.stickware.jani5.logic.dictionaries.MSport;

@Entity
public class AbstractEquipmentSO {

    @PrimaryKey @NonNull private String name;

    @ColumnInfo(name = "description") private String description;
    @ColumnInfo(name = "sport") private MSport.Sport sport;
    @ColumnInfo(name = "icon_id") private int iconID;

    public AbstractEquipmentSO(@NonNull String name, String description, MSport.Sport sport, int iconID){

        this.name = name;
        this.description = description;
        this.sport = sport;
        this.iconID = iconID;
    }

    @Ignore
    public AbstractEquipmentSO(){}

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

    protected int getIconID() {
        return iconID;
    }

    protected void setIconID(int iconID) {
        this.iconID = iconID;
    }
}
