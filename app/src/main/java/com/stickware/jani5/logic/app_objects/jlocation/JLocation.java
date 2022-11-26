package com.stickware.jani5.logic.app_objects.jlocation;

import android.graphics.Bitmap;
import android.location.Location;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.Relation;

import java.util.List;

@Entity
public class JLocation {

    public enum LocationCategory {
        RUNNING_START,
        GYM,
        POOL,
        HIKING_SPOT;
    }

    @PrimaryKey(autoGenerate = true) public int uid;
    @ColumnInfo(name = "name") private String mName;
    @ColumnInfo(name = "description") private String mDescription;
    @ColumnInfo(name = "location") private Location mLocation; //Is converted
    @ColumnInfo(name = "location_category") private LocationCategory mCategory;

    //TODO: need to be able to move bitmap image to internal storage and store reference string. Should replace object with path instead of actual image?
    @Ignore private Bitmap mImage;


    //Constructors
    public JLocation(){

    }

    //Setters
    public void setMName(String name){mName = name;}
    public void setMDescription(String description){mDescription = description;}
    public void setMLocation(Location location){mLocation = location;}
    public void setMImage(Bitmap image){mImage = image;}
    public void setMCategory(LocationCategory locationCategory){mCategory = locationCategory;}

    //Getters
    public String getMName(){return mName;}
    public String getMDescription(){return mDescription;}
    public Location getMLocation(){return mLocation;}
    public Bitmap getMImage(){return mImage;}
    public LocationCategory getMCategory(){return mCategory;}
}
