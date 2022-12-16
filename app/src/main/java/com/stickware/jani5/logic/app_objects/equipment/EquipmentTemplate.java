package com.stickware.jani5.logic.app_objects.equipment;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.RoomWarnings;


import com.stickware.jani5.logic.dictionaries.Sport;

import java.util.ArrayList;

@Entity
public class EquipmentTemplate {

    @PrimaryKey @NonNull private String mName;
    @ColumnInfo(name = "description") private String mDescription;
    @ColumnInfo(name = "sport") private Sport mSport;
    @Ignore private Bitmap mImage;

    @ColumnInfo(name = "location_specific") private boolean locationSpecific;


    @Embedded(prefix = "lifespan")
    private EquipmentLifespan mEquipmentLifespan;

    @ColumnInfo(name = "active_models") private ArrayList<EquipmentModel> activeModels;
    @Ignore private ArrayList<EquipmentModel> retiredModels;

    @Ignore
    public EquipmentTemplate(){this.mName = "";}

    public EquipmentTemplate(@NonNull String name, String description, Sport sport, boolean locationSpecific, EquipmentLifespan equipmentLifespan){

        this.mName = name;
        this.mDescription = description;
        this.mSport = sport;
        this.locationSpecific = locationSpecific;
        this.mEquipmentLifespan = equipmentLifespan;
    }

    //Add model
    public void addModel(EquipmentModel equipmentModel){
        activeModels.add(equipmentModel);
    }
    //TODO: Should add check to make sure that item is in corresponding array list
    //Retire and restore model
    public void retireModel(EquipmentModel equipmentModel){
        activeModels.remove(equipmentModel);
        retiredModels.add(equipmentModel);
    }
    public void restoreModel(EquipmentModel equipmentModel){
        retiredModels.remove(equipmentModel);
        activeModels.add(equipmentModel);
    }

    //Getters and Setters
    @NonNull public String getMName() {
        return mName;
    }

    public void setMName(@NonNull String mName) {
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

    public ArrayList<EquipmentModel> getActiveModels() {
        return activeModels;
    }

    public void setActiveModels(ArrayList<EquipmentModel> mEquipmentModels) {
        this.activeModels = mEquipmentModels;
    }

    public ArrayList<EquipmentModel> getRetiredModels() {
        return retiredModels;
    }

    public void setRetiredModels(ArrayList<EquipmentModel> retiredModels) {
        this.retiredModels = retiredModels;
    }
}
