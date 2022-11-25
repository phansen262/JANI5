package com.stickware.jani5.servers;

import com.stickware.jani5.logic.app_objects.jlocation.JLocation;

public class LocationServer {

    public static JLocation activeJLocation;

    //Server set initialization
    public static void setLocationServer(){

        activeJLocation = new JLocation();
    }
}
