package com.stickware.jani5.logic.dictionaries;

public enum Weight {

    BARBELL("Barbell"),
    DUMBBELL("Dumbbell"),
    MACHINE("Machine"),
    BODYWEIGHT("Body-weight");

    private final String label;

    Weight(String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
