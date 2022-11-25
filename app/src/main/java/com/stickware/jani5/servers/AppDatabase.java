package com.stickware.jani5.servers;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.stickware.jani5.logic.app_objects.TestDataObject;

@Database(entities = {TestDataObject.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public TestDao testDao;
}
