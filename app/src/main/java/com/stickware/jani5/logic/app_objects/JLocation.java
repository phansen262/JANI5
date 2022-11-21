package com.stickware.jani5.logic.app_objects;

import android.location.Location;

public class JLocation {

    private String mName;
    private String mDescription;
    private Location mLocation;

    //Constructors
    public JLocation(){

    }

    //Setters
    public void setmName(String name){mName = name;}
    public void setmDescription(String description){mDescription = description;}
    public void setmLocation(Location location){mLocation = location;}

    //Getters
    public String getmName(){return mName;}
    public String getmDescription(){return mDescription;}
    public Location getMLocation(){return mLocation;}
}
