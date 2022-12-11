package com.stickware.jani5.logic.database;

import android.app.Activity;

import androidx.room.Room;

public class AppServer {

    public static AppDatabase mdb;

    public static void setAppServer(Activity activity){

        mdb = Room.databaseBuilder(activity.getApplicationContext(), AppDatabase.class, "new-base").fallbackToDestructiveMigration().build();
    }
}
