package com.stickware.jani5.logic.app_objects.equipment;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Single;

@Dao
public interface EquipmentTemplateDao {

    @Query("SELECT * FROM EquipmentTemplate")
    List<EquipmentTemplate> getAll();

    @Query("SELECT * FROM EquipmentTemplate WHERE name LIKE :searchName")
    EquipmentTemplate getByName(String searchName);

    @Insert
    void insertItem(EquipmentTemplate equipmentTemplate);

    @Insert
    void insertAll(EquipmentTemplate... equipmentTemplates);

    @Delete
    void deleteItem(EquipmentTemplate equipmentTemplate);

    @Delete
    void deleteItems(EquipmentTemplate... equipmentTemplates);
}
