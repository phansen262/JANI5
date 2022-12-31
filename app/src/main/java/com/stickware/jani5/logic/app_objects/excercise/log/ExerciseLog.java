package com.stickware.jani5.logic.app_objects.excercise.log;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ExerciseLog {

    public enum LogType{

        RUNNING,
        BIKING,
        SWIMMING,
        SETREP,
        DURATION
    }

    @PrimaryKey() @NonNull public String logID;

    @ColumnInfo(name = "log_type") private LogType logType;
    @ColumnInfo(name = "log_data") private String logString;
    @Embedded(prefix = "this_test") private ArrayList<String> testing;

    public ExerciseLog(@NonNull String logID, LogType logType, String logString, ArrayList<String> testing){

        this.logID = logID;
        this.logType = logType;
        this.logString = logString;
        this.testing = testing;
    }

    public static String getLogID(String exerciseName, String date, String time){
        return exerciseName + "<*>" + date + "<*>" + time;
    }

    @NonNull
    public String getLogID() {
        return logID;
    }

    public void setLogID(@NonNull String logID) {
        this.logID = logID;
    }

    public LogType getLogType() {
        return logType;
    }

    public void setLogType(LogType logType) {
        this.logType = logType;
    }

    public String getLogString() {
        return logString;
    }

    public void setLogString(String logString) {
        this.logString = logString;
    }

    public ArrayList<String> getTesting() {
        return testing;
    }

    public void setTesting(ArrayList<String> testing) {
        this.testing = testing;
    }
}
