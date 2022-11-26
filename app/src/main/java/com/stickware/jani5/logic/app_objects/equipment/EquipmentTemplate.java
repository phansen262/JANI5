package com.stickware.jani5.logic.app_objects.equipment;

import android.graphics.Bitmap;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.stickware.jani5.logic.dictionaries.Sport;

@Entity
public class EquipmentTemplate {

    @PrimaryKey(autoGenerate = true) public int uid;
    @ColumnInfo(name = "name") private String mName;
    @ColumnInfo(name = "description") private String mDescription;
    @ColumnInfo(name = "sport") private Sport mSport;

    @Ignore
    private Bitmap mImage;

    @ColumnInfo(name = "location_specific") private boolean locationSpecific;
    @ColumnInfo(name = "has_models") private boolean hasModels;

    @ColumnInfo(name = "has_life_span") private boolean hasLifeSpan;

    @Ignore private EquipmentLifespan mEquipmentLifespan;

    public EquipmentTemplate(){}

    public EquipmentTemplate(String name, String description, Sport sport, boolean locationSpecific,
                             boolean hasModels, boolean hasLifeSpan, EquipmentLifespan equipmentLifespan){

        this.mName = name;
        this.mDescription = description;
        this.mSport = sport;
        this.locationSpecific = locationSpecific;
        this.hasModels = hasModels;
        this.hasLifeSpan = hasLifeSpan;
        this.mEquipmentLifespan = equipmentLifespan;
    }

    //Getters and Setters
    public String getMName() {
        return mName;
    }

    public void setMName(String mName) {
        this.mName = mName;
    }

    public String getMDescription() {
        return mDescription;
    }

    public void setMDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public Sport getMSport() {
        return mSport;
    }

    public void setMSport(Sport mSport) {
        this.mSport = mSport;
    }

    public boolean isLocationSpecific() {
        return locationSpecific;
    }

    public void setLocationSpecific(boolean locationSpecific) {
        this.locationSpecific = locationSpecific;
    }

    public boolean isHasModels() {
        return hasModels;
    }

    public void setHasModels(boolean hasModels) {
        this.hasModels = hasModels;
    }

    public boolean isHasLifeSpan() {
        return hasLifeSpan;
    }

    public void setHasLifeSpan(boolean hasLifeSpan) {
        this.hasLifeSpan = hasLifeSpan;
    }

    public EquipmentLifespan getMEquipmentLifespan() {
        return mEquipmentLifespan;
    }

    public void setMEquipmentLifespan(EquipmentLifespan mEquipmentLifespan) {
        this.mEquipmentLifespan = mEquipmentLifespan;
    }

    public Bitmap getMImage() {
        return mImage;
    }

    public void setMImage(Bitmap mImage) {
        this.mImage = mImage;
    }
}
