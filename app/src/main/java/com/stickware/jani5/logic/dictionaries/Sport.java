package com.stickware.jani5.logic.dictionaries;

import com.stickware.jani5.logic.app_objects.equipment.EquipmentLifespan;

import java.util.ArrayList;
import java.util.List;

public enum Sport {

    BIKING("Biking"),
    NONE("None"),
    RUNNING("Running"),
    SWIMMING("Swimming"),
    WEIGHTS("Weights"),
    YOGA("Yoga");

    public String label;

    Sport(String label){
        this.label = label;
    }
}


