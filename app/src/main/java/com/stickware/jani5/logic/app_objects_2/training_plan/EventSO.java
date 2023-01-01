package com.stickware.jani5.logic.app_objects_2.training_plan;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.stickware.jani5.logic.app_objects_2.location.LocationSO;

@Entity
public class EventSO {

    @PrimaryKey @NonNull private String name;

    @ColumnInfo(name = "event_type") private Event.Type eventType;
    @ColumnInfo(name = "image_id") private int imageID;

    @Embedded(prefix = "location") private LocationSO eventLocation;

    public EventSO(@NonNull String name, Event.Type eventType, int imageID, LocationSO eventLocation){
        this.name = name;
        this.eventType = eventType;
        this.imageID = imageID;
        this.eventLocation = eventLocation;
    }

    @Ignore public EventSO(){}

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public Event.Type getEventType() {
        return eventType;
    }

    public void setEventType(Event.Type eventType) {
        this.eventType = eventType;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public LocationSO getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(LocationSO eventLocation) {
        this.eventLocation = eventLocation;
    }
}
