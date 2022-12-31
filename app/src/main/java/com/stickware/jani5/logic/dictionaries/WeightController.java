package com.stickware.jani5.logic.dictionaries;

import java.util.ArrayList;
import java.util.List;

public class WeightController {

    public static List<String> getDisplayList(){
        List<String> returnList = new ArrayList<>();
        for(Muscle item : Muscle.values()){
            returnList.add(item.label);
        }
        return returnList;
    }

    public static Weight getFromString(String input){

        for(Weight i : Weight.values()){
            if(i.getLabel().equals(input)){
                return i;
            }
        }

        return null;
    }
}
