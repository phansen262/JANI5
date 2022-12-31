package com.stickware.jani5.logic.app_objects.equipment;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class EquipmentModel {

    @PrimaryKey @NonNull private String modelName;
    @ColumnInfo(name = "template_name") private String templateName;
    @ColumnInfo(name = "model_iteration") private int modelIteration;
    @ColumnInfo(name = "max_life") private int maxLife;
    @ColumnInfo(name = "current_life") private int currentLife;

    public EquipmentModel(@NonNull String modelName, String templateName, int modelIteration, int maxLife, int currentLife) {

        this.modelName = modelName;
        this.templateName = templateName;
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

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
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
