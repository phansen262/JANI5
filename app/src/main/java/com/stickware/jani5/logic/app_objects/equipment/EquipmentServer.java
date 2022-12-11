package com.stickware.jani5.logic.app_objects.equipment;

import androidx.fragment.app.FragmentActivity;

import com.stickware.jani5.gui.library.components.edit.EditEquipmentFrag;
import com.stickware.jani5.gui.library.navigation.MainNavBar;
import com.stickware.jani5.logic.database.AppServer;
import com.stickware.jani5.logic.database.MExecutor;

import java.util.ArrayList;
import java.util.Arrays;

public class EquipmentServer {

    public static EquipmentTemplate activeTemplate;
    public static ArrayList<EquipmentTemplate> activeTemplates;

    private static EquipmentTemplateDao templateDao;

    //Server set initialization
    public static void setEquipmentServer(){

        activeTemplate = new EquipmentTemplate();
        templateDao = AppServer.mdb.equipmentTemplateDao();
        resetActiveList();
    }

    //Set active elements
    public static void setActiveTemplate(EquipmentTemplate input){
        activeTemplate = input;
    }

    public static void setActiveList(EquipmentTemplate... equipmentTemplates){
        activeTemplates = new ArrayList<>(Arrays.asList(equipmentTemplates));
    }

    public static void resetActiveList(){
        MExecutor.loadTask(() -> activeTemplates = new ArrayList<>(templateDao.getAll()),
                () -> System.out.println("Reset Loaded Equipment Templates"));
    }

    //Launch fragment for new equipment
    public static void launchNewEquipmentFrag(FragmentActivity activity, int fragContainerID, MainNavBar mBar){

        activity.getSupportFragmentManager().beginTransaction().
                replace(fragContainerID, new EditEquipmentFrag(mBar, null)).addToBackStack("").commit();
    }

    //Save equipment template
    public static void saveEquipmentTemplate(EquipmentTemplate input){

        MExecutor.loadTask(() -> templateDao.insertAll(input), () -> System.out.println("Saved Equipment Template"));
    }
}
