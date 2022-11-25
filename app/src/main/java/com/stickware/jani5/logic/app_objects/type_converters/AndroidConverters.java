package com.stickware.jani5.logic.app_objects.type_converters;

import android.location.Location;

import androidx.room.TypeConverter;

public class AndroidConverters {

    @TypeConverter
    public static Location fromString(String latLng) {
        Location loc = new Location("");
        loc.setLatitude(Double.parseDouble(latLng.split(":")[0]));
        loc.setLongitude(Double.parseDouble(latLng.split(":")[1]));
        return loc;
    }

    @TypeConverter
    public static String locationToString(Location loc){
        return loc.getLatitude() + ":" + loc.getLongitude();
    }
}
