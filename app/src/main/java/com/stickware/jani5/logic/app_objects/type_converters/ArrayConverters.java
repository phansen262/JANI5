package com.stickware.jani5.logic.app_objects.type_converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ArrayConverters {

    @TypeConverter
    public static ArrayList<?> listFromString(String value){
        Type listType = new TypeToken<ArrayList<?>>(){}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String stringFromList(ArrayList<?> list){
        return new Gson().toJson(list);
    }
}
