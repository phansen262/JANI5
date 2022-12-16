package com.stickware.jani5.logic.dictionaries;

public enum Sport {

    NONE("None"),
    BIKING("Biking"),
    RUNNING("Running"),
    SWIMMING("Swimming"),
    WEIGHTS("Weights"),
    YOGA("Yoga");

    public final String label;

    Sport(String label){
        this.label = label;
    }
}


