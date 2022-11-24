package com.stickware.jani5.logic.app_objects.equipment;

public class EquipmentItem extends EquipmentTemplate {

    private String modelName;
    private int modelIteration;
    private int currentLife;

    private EquipmentLifespan mLifespan;

    //If just base item with not
    public EquipmentItem(EquipmentTemplate et){
        super(et.getmName(), et.getmDescription(), et.getmSport(), et.isLocationSpecific(),
                et.isHasModels(), et.isHasLifeSpan(), et.getmEquipmentLifespan());
    }

    public EquipmentItem(EquipmentTemplate et, int currentLife){
        super(et.getmName(), et.getmDescription(), et.getmSport(), et.isLocationSpecific(),
                et.isHasModels(), et.isHasLifeSpan(), et.getmEquipmentLifespan());
        this.currentLife = currentLife;
    }

    public EquipmentItem(EquipmentTemplate et, String modelName, int modelIteration){

        super(et.getmName(), et.getmDescription(), et.getmSport(), et.isLocationSpecific(),
                et.isHasModels(), et.isHasLifeSpan(), et.getmEquipmentLifespan());

        this.modelName = modelName;
        this.modelIteration = modelIteration;
    }

    public EquipmentItem(EquipmentTemplate et, String modelName, int modelIteration, int currentLife){

        super(et.getmName(), et.getmDescription(), et.getmSport(), et.isLocationSpecific(),
                et.isHasModels(), et.isHasLifeSpan(), et.getmEquipmentLifespan());

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

    public EquipmentLifespan getmLifespan() {
        return mLifespan;
    }

    public void setmLifespan(EquipmentLifespan mLifespan) {
        this.mLifespan = mLifespan;
    }
}
