package com.stickware.jani5.servers;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.stickware.jani5.logic.app_objects.TestDataObject;
import com.stickware.jani5.logic.app_objects.equipment.EquipmentItem;
import com.stickware.jani5.logic.app_objects.equipment.EquipmentTemplate;
import com.stickware.jani5.logic.app_objects.equipment.EquipmentTemplateDao;
import com.stickware.jani5.logic.app_objects.jlocation.JLocation;
import com.stickware.jani5.logic.app_objects.jlocation.JLocationDao;
import com.stickware.jani5.logic.app_objects.type_converters.AndroidConverters;
import com.stickware.jani5.logic.app_objects.type_converters.AppConverters;
import com.stickware.jani5.logic.app_objects.type_converters.ArrayConverters;
import com.stickware.jani5.logic.app_objects.type_converters.JavaConverters;

@Database(entities = {TestDataObject.class, JLocation.class, EquipmentTemplate.class,
        EquipmentItem.class}, version = 3)
@TypeConverters({AndroidConverters.class, AppConverters.class, JavaConverters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract TestDao testDao();

    public abstract JLocationDao jLocationDao();
    public abstract EquipmentTemplateDao equipmentTemplateDao();

}
