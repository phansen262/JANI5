package com.stickware.jani5.logic.app_objects.type_converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class JavaConverters {

    /*
    @TypeConverter
    public static ArrayList<String> fromString(String value){
        Type listType = new TypeToken<ArrayList<String>>(){}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromStringArrayList(ArrayList<String> list){

        return new Gson().toJson(list);
    }*/
}
