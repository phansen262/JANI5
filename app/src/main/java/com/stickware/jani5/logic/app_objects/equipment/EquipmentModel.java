package com.stickware.jani5.logic.app_objects.equipment;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class EquipmentModel {

    @PrimaryKey @NonNull private String modelName;
    @ColumnInfo(name = "label") private String label;
    @ColumnInfo(name = "model_iteration") private int modelIteration;
    @ColumnInfo(name = "max_life") private int maxLife;
    @ColumnInfo(name = "current_life") private int currentLife;

    public EquipmentModel(@NonNull String modelName, String label, int modelIteration, int maxLife, int currentLife) {

        this.modelName = modelName;
        this.label = label;
        this.modelIteration = modelIteration;
        this.maxLife = maxLife;
        this.currentLife = currentLife;
    }

    //Getters and Setters
    @NonNull public String getModelName() {
        return modelName;
    }

    public void setModelName(@NonNull String modelName) {
        this.modelName = modelName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getModelIteration() {
        return modelIteration;
    }

    public void setModelIteration(int modelIteration) {
        this.modelIteration = modelIteration;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public int getCurrentLife() {
        return currentLife;
    }

    public void setCurrentLife(int currentLife) {
        this.currentLife = currentLife;
    }
}
