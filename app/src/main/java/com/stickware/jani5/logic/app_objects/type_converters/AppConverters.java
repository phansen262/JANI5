package com.stickware.jani5.logic.app_objects.type_converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stickware.jani5.logic.app_objects.equipment.EquipmentModel;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class AppConverters {

    /*
    @TypeConverter
    public static ArrayList<EquipmentModel> fromString(String value){
        Type listType = new TypeToken<ArrayList<EquipmentModel>>(){}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromEquipmentLifespanArrayList(ArrayList<EquipmentModel> list){
        return new Gson().toJson(list);
    }*/
}
