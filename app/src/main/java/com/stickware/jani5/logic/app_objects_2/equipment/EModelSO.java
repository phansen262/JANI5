package com.stickware.jani5.logic.app_objects_2.equipment;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;

@Entity(primaryKeys = {"name", "template_name"})
public class EModelSO {

    @ColumnInfo(name = "name") @NonNull
    private String name;
    @ColumnInfo(name = "template_name") @NonNull private String templateName;

    @ColumnInfo(name = "life_value") private int lifeValue;

    public EModelSO(@NonNull String name, @NonNull String templateName, int lifeValue){

        this.name = name;
        this.templateName = templateName;
        this.lifeValue = lifeValue;
    }

    @Ignore
    public EModelSO(){}

    @NonNull public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(@NonNull String templateName) {
        this.templateName = templateName;
    }

    public int getLifeValue() {
        return lifeValue;
    }

    public void setLifeValue(int lifeValue) {
        this.lifeValue = lifeValue;
    }
}
