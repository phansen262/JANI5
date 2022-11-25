package com.stickware.jani5.logic.app_objects.jlocation;

import android.location.Location;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;

@Dao
public interface JLocationDao {

    @Query("SELECT * FROM jlocation")
    Single<List<JLocation>> getAll();

    @Query("SELECT * FROM jlocation WHERE uid IN (:userIds)")
    Single<List<JLocation>> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM jlocation WHERE location_category LIKE :search_category")
    Single<List<JLocation>> searchByCategory(JLocation.LocationCategory search_category);

    @Query("SELECT * FROM jlocation WHERE name LIKE :search_name")
    Single<List<JLocation>> searchByName(String search_name);

    @Query("SELECT * FROM jlocation WHERE location LIKE :search_location")
    Single<List<JLocation>> searchByLocation(Location search_location);

    @Query("SELECT * FROM jlocation WHERE name LIKE '%'||:substring||'%'")
    Single<List<JLocation>> searchSubStringName(String substring);

    @Query("SELECT name FROM jlocation")
    Single<List<String>> getAllNames();

    @Query("SELECT location FROM jlocation WHERE name LIKE :search_name")
    Single<Location> getLocation(String search_name);

    @Insert
    Completable insertAll(JLocation... jLocations);

    @Delete
    Completable deleteItem(JLocation jLocation);

    @Delete
    Completable deleteItems(JLocation... jLocations);
}
