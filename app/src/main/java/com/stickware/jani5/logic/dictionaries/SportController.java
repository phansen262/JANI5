package com.stickware.jani5.logic.dictionaries;

import java.util.ArrayList;
import java.util.List;

public class SportController {

    public static List<String> getDisplayList(){
        List<String> returnList = new ArrayList<>();
        for(Sport item : Sport.values()){
            returnList.add(item.label);
        }
        return returnList;
    }

    public static Sport getFromString(String input){

        for(Sport i : Sport.values()){
            if(i.label.equals(input)){
                return i;
            }
        }

        return null;
    }
}
