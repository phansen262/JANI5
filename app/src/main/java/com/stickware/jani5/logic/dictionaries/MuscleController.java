package com.stickware.jani5.logic.dictionaries;

import java.util.ArrayList;
import java.util.List;

public class MuscleController {

    public static List<String> getDisplayList(){
        List<String> returnList = new ArrayList<>();
        for(Muscle item : Muscle.values()){
            returnList.add(item.label);
        }
        return returnList;
    }

    public static Muscle getFromString(String input){

        for(Muscle i : Muscle.values()){
            if(i.label.equals(input)){
                return i;
            }
        }

        return null;
    }
}
