package com.stickware.jani5.logic.app_objects.equipment;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;

@Dao
public interface EquipmentTemplateDao {

    @Query("SELECT * FROM EquipmentTemplate")
    List<EquipmentTemplate> getAll();

    @Insert
    void insertItem(EquipmentTemplate equipmentTemplate);

    @Insert
    void insertAll(EquipmentTemplate... equipmentTemplates);

    @Delete
    void deleteItem(EquipmentTemplate equipmentTemplate);

    @Delete
    void deleteItems(EquipmentTemplate... equipmentTemplates);

    @TypeConverter
    static ArrayList<EquipmentModel> fromString(String value){
        Type listType = new TypeToken<ArrayList<EquipmentModel>>(){}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    static String fromList(ArrayList<EquipmentModel> list){
        return new Gson().toJson(list);
    }
}
