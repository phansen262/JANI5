package com.stickware.jani5.logic.app_objects.equipment;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class EquipmentItem extends EquipmentTemplate {

    @PrimaryKey(autoGenerate = true) public int uid;
    @ColumnInfo(name = "model_name") private String modelName;
    @ColumnInfo(name = "model_iteration") private int modelIteration;
    @ColumnInfo(name = "current_life") private int currentLife;

    public EquipmentItem(){}

    //If just base item
    public EquipmentItem(EquipmentTemplate equipmentTemplate) {
        super(equipmentTemplate.getMName(), equipmentTemplate.getMDescription(), equipmentTemplate.getMSport(), equipmentTemplate.isLocationSpecific(),
                equipmentTemplate.isHasModels(), equipmentTemplate.isHasLifeSpan(), equipmentTemplate.getMEquipmentLifespan());
    }

    public EquipmentItem(EquipmentTemplate et, int currentLife) {
        super(et.getMName(), et.getMDescription(), et.getMSport(), et.isLocationSpecific(),
                et.isHasModels(), et.isHasLifeSpan(), et.getMEquipmentLifespan());
        this.currentLife = currentLife;
    }

    public EquipmentItem(EquipmentTemplate et, String modelName, int modelIteration) {

        super(et.getMName(), et.getMDescription(), et.getMSport(), et.isLocationSpecific(),
                et.isHasModels(), et.isHasLifeSpan(), et.getMEquipmentLifespan());

        this.modelName = modelName;
        this.modelIteration = modelIteration;
    }

    public EquipmentItem(EquipmentTemplate et, String modelName, int modelIteration, int currentLife) {

        super(et.getMName(), et.getMDescription(), et.getMSport(), et.isLocationSpecific(),
                et.isHasModels(), et.isHasLifeSpan(), et.getMEquipmentLifespan());

        this.modelName = modelName;
        this.modelIteration = modelIteration;
        this.currentLife = currentLife;
    }

    //Getters and Setters
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getModelIteration() {
        return modelIteration;
    }

    public void setModelIteration(int modelIteration) {
        this.modelIteration = modelIteration;
    }

    public int getCurrentLife() {
        return currentLife;
    }

    public void setCurrentLife(int currentLife) {
        this.currentLife = currentLife;
    }
}
