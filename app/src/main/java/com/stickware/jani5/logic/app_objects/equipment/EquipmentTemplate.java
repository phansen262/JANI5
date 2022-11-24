package com.stickware.jani5.logic.app_objects.equipment;

import android.graphics.Bitmap;

import com.stickware.jani5.logic.dictionaries.Sport;

public class EquipmentTemplate {

    private String mName;
    private String mDescription;
    private Sport mSport;
    private Bitmap mImage;

    private boolean locationSpecific;
    private boolean hasModels;

    private boolean hasLifeSpan;
    private EquipmentLifespan mEquipmentLifespan;

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
    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public Sport getmSport() {
        return mSport;
    }

    public void setmSport(Sport mSport) {
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

    public EquipmentLifespan getmEquipmentLifespan() {
        return mEquipmentLifespan;
    }

    public void setmEquipmentLifespan(EquipmentLifespan mEquipmentLifespan) {
        this.mEquipmentLifespan = mEquipmentLifespan;
    }

    public Bitmap getmImage() {
        return mImage;
    }

    public void setmImage(Bitmap mImage) {
        this.mImage = mImage;
    }
}
