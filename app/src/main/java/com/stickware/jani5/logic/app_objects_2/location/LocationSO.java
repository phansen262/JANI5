package com.stickware.jani5.logic.app_objects_2.location;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;


@Entity
public class LocationSO {

    @PrimaryKey @NonNull
    private String name;

    @ColumnInfo(name = "category") private Location.LocationCategory category;
    @ColumnInfo(name = "image_id") private int imageID;
    @ColumnInfo(name = "latitude") private double latitude;
    @ColumnInfo(name = "longitude") private double longitude;

    public LocationSO(@NonNull String name, Location.LocationCategory category, int imageID, double latitude, double longitude){

        this.name = name;
        this.category = category;
        this.imageID = imageID;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Ignore
    public LocationSO(){}

    @NonNull public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public Location.LocationCategory getCategory() {
        return category;
    }

    public void setCategory(Location.LocationCategory category) {
        this.category = category;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
