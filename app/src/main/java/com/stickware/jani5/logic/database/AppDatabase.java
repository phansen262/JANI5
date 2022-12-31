package com.stickware.jani5.logic.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.stickware.jani5.logic.app_objects.equipment.EquipmentLifespan;
import com.stickware.jani5.logic.app_objects.equipment.EquipmentModel;
import com.stickware.jani5.logic.app_objects.equipment.EquipmentTemplate;
import com.stickware.jani5.logic.app_objects.equipment.EquipmentTemplateDao;
import com.stickware.jani5.logic.app_objects.excercise.Exercise;
import com.stickware.jani5.logic.app_objects.excercise.ExerciseDao;
import com.stickware.jani5.logic.app_objects.excercise.log.ExerciseLog;
import com.stickware.jani5.logic.app_objects.excercise.log.ExerciseLogDao;
import com.stickware.jani5.logic.app_objects.excercise.variant.ExerciseVariant;
import com.stickware.jani5.logic.app_objects.excercise.variant.ExerciseVariantDao;
import com.stickware.jani5.logic.app_objects.jlocation.JLocation;
import com.stickware.jani5.logic.app_objects.jlocation.JLocationDao;
import com.stickware.jani5.logic.app_objects.type_converters.AndroidConverters;
import com.stickware.jani5.logic.app_objects.type_converters.AppConverters;
import com.stickware.jani5.logic.app_objects.type_converters.ArrayConverters;
import com.stickware.jani5.logic.app_objects.type_converters.JavaConverters;

@Database(entities = {
        JLocation.class,
        EquipmentTemplate.class,
        EquipmentModel.class,
        EquipmentLifespan.class,
        ExerciseLog.class,
        Exercise.class,
        ExerciseVariant.class}, version = 3)

public abstract class AppDatabase extends RoomDatabase {

    public abstract JLocationDao jLocationDao();
    public abstract EquipmentTemplateDao equipmentTemplateDao();
    public abstract ExerciseDao exerciseDao();
    public abstract ExerciseLogDao exerciseLogDao();
    public abstract ExerciseVariantDao exerciseVariantDao();
}
