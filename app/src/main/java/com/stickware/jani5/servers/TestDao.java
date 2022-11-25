package com.stickware.jani5.servers;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.stickware.jani5.logic.app_objects.TestDataObject;

import java.util.List;

@Deprecated
@Dao
public interface TestDao {

    @Query("SELECT * FROM testdataobject")
    List<TestDataObject> getAll();

    @Query("SELECT * FROM testdataobject WHERE uid IN (:userIds)")
    List<TestDataObject> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM testdataobject WHERE first_string LIKE :first AND testNumber LIKE :index LIMIT 1")
    TestDataObject findByName(String first, int index);

    @Insert
    void insertAll(TestDataObject... testDataObjects2);

    @Delete
    void delete(TestDataObject testDataObject2);

}

