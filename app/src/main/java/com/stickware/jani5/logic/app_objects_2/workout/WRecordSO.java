package com.stickware.jani5.logic.app_objects_2.workout;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class WRecordSO {

    @PrimaryKey
    @NonNull
    private String key;

    public WRecordSO(@NonNull String key){
        this.key = key;
    }

    @Ignore
    public WRecordSO(){}

    @NonNull
    public String getKey() {
        return key;
    }

    public void setKey(@NonNull String key) {
        this.key = key;
    }
}
