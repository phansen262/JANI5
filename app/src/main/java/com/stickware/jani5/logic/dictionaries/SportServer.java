package com.stickware.jani5.logic.dictionaries;

import com.stickware.jani5.logic.app_objects.equipment.EquipmentLifespan;

import java.util.ArrayList;
import java.util.List;

public class SportServer {

    public static List<String> getEnumDisplayList(){
        List<String> returnList = new ArrayList<>();
        for(Sport item : Sport.values()){
            returnList.add(item.label);
        }
        return returnList;
    }
}
