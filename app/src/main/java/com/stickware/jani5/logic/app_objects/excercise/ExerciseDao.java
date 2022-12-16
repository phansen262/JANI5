package com.stickware.jani5.logic.app_objects.excercise;

import androidx.room.Dao;
import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.stickware.jani5.logic.app_objects.equipment.EquipmentModel;
import com.stickware.jani5.logic.app_objects.excercise.variant.ExerciseVariant;

import java.lang.reflect.Type;
import java.util.ArrayList;

@Dao
public interface ExerciseDao {

    /*@TypeConverter
    static ArrayList<ExerciseVariant> fromString(String value){
        Type listType = new TypeToken<ArrayList<ExerciseVariant>>(){}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    static String fromExerciseVariantArrayList(ArrayList<ExerciseVariant> list){
        return new Gson().toJson(list);
    }*/
}
