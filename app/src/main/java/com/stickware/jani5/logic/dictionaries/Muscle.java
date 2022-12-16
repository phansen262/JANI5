package com.stickware.jani5.logic.dictionaries;

public enum Muscle {

    NONE("None"),
    CALVES("Calves"),
    QUADS("Quadriceps"),
    HAMSTRINGS("Hamstrings"),
    GLUTES("Glutes"),
    HIPFLEXORS("Hip Flexors"),
    ABS("Abs"),
    OBLIQUES("Obliques"),
    LATS("Lats"),
    TRAPS("Traps"),
    SHOULDERS("Shoulders"),
    PECS("Pecs"),
    BICEPS("Biceps"),
    TRICEPS("Triceps"),
    FOREARMS("Forearms");

    public final String label;

    Muscle(String label){
        this.label = label;
    }
}
