package com.stickware.jani5.logic.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.stickware.jani5.logic.app_objects.TestDataObject;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Deprecated
@Dao
public interface TestDao {

    @Query("SELECT * FROM testdataobject")
    Single<List<TestDataObject>> getAll();

    @Query("SELECT * FROM testdataobject WHERE uid IN (:userIds)")
    Single<List<TestDataObject>> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM testdataobject WHERE first_string LIKE :first AND testNumber LIKE :index LIMIT 1")
    TestDataObject findByName(String first, int index);

    @Insert
    void insertAll(TestDataObject... testDataObjects2);

    @Delete
    Completable delete(TestDataObject testDataObject2);

}

