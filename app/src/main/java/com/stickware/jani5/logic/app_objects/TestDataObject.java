package com.stickware.jani5.logic.app_objects;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Deprecated
@Entity
public class TestDataObject {

    @PrimaryKey(autoGenerate = true) public int uid;

    @ColumnInfo(name = "first_string") public String firstString;

    @ColumnInfo(name = "testNumber") public int testNumber;

    public TestDataObject(){

    }

    public TestDataObject(String first, int ind){
        firstString = first;
        testNumber = ind;
    }

    public void printName(){
        System.err.println(firstString);
    }
}
