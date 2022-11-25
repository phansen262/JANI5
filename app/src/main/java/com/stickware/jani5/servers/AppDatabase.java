package com.stickware.jani5.servers;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.stickware.jani5.logic.app_objects.TestDataObject;
import com.stickware.jani5.logic.app_objects.jlocation.JLocation;
import com.stickware.jani5.logic.app_objects.jlocation.JLocationDao;
import com.stickware.jani5.logic.app_objects.type_converters.AndroidConverters;

@Database(entities = {TestDataObject.class, JLocation.class}, version = 2)
@TypeConverters({AndroidConverters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract TestDao testDao();
    public JLocationDao jLocationDao;
}
