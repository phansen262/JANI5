package com.stickware.jani5.logic.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.stickware.jani5.logic.app_objects_2.equipment.AbstractEquipmentDAO;
import com.stickware.jani5.logic.app_objects_2.equipment.AbstractEquipmentSO;
import com.stickware.jani5.logic.app_objects_2.equipment.EModelDAO;
import com.stickware.jani5.logic.app_objects_2.equipment.EModelSO;
import com.stickware.jani5.logic.app_objects_2.equipment.EquipmentDAO;
import com.stickware.jani5.logic.app_objects_2.equipment.EquipmentSO;
import com.stickware.jani5.logic.app_objects_2.exercise.EPlanDAO;
import com.stickware.jani5.logic.app_objects_2.exercise.EPlanSO;
import com.stickware.jani5.logic.app_objects_2.exercise.ERecordDAO;
import com.stickware.jani5.logic.app_objects_2.exercise.ERecordSO;
import com.stickware.jani5.logic.app_objects_2.exercise.EVariant;
import com.stickware.jani5.logic.app_objects_2.exercise.EVariantDAO;
import com.stickware.jani5.logic.app_objects_2.exercise.EVariantSO;
import com.stickware.jani5.logic.app_objects_2.exercise.ExerciseDAO;
import com.stickware.jani5.logic.app_objects_2.exercise.ExerciseSO;
import com.stickware.jani5.logic.app_objects_2.location.LocationDAO;
import com.stickware.jani5.logic.app_objects_2.location.LocationSO;
import com.stickware.jani5.logic.app_objects_2.training_plan.EventDAO;
import com.stickware.jani5.logic.app_objects_2.training_plan.EventSO;
import com.stickware.jani5.logic.app_objects_2.training_plan.GoalDAO;
import com.stickware.jani5.logic.app_objects_2.training_plan.GoalSO;
import com.stickware.jani5.logic.app_objects_2.training_plan.TpPhaseSO;
import com.stickware.jani5.logic.app_objects_2.training_plan.TrainingPlanDAO;
import com.stickware.jani5.logic.app_objects_2.training_plan.TrainingPlanSO;
import com.stickware.jani5.logic.app_objects_2.workout.WPlanDAO;
import com.stickware.jani5.logic.app_objects_2.workout.WPlanSO;
import com.stickware.jani5.logic.app_objects_2.workout.WRecordDAO;
import com.stickware.jani5.logic.app_objects_2.workout.WRecordSO;
import com.stickware.jani5.logic.app_objects_2.workout.WorkoutDAO;
import com.stickware.jani5.logic.app_objects_2.workout.WorkoutSO;

@Database(entities = {
        AbstractEquipmentSO.class,
        EModelSO.class,
        EquipmentSO.class,
        EPlanSO.class,
        ERecordSO.class,
        EVariantSO.class,
        ExerciseSO.class,
        EventSO.class,
        GoalSO.class,
        LocationSO.class,
        TpPhaseSO.class,
        TrainingPlanSO.class,
        WorkoutSO.class,
        WPlanSO.class,
        WRecordSO.class
}, version = 1)

public abstract class AppDatabase2 extends RoomDatabase {
    public abstract AbstractEquipmentDAO abstractEquipmentDAO();
    public abstract EModelDAO eModelDAO();
    public abstract EquipmentDAO equipmentDAO();
    public abstract EPlanDAO ePlanDAO();
    public abstract ERecordDAO eRecordDAO();
    public abstract EVariantDAO eVariantDAO();
    public abstract ExerciseDAO exerciseDAO();
    public abstract EventDAO eventDAO();
    public abstract GoalDAO goalDAO();
    public abstract LocationDAO locationDAO();
    public abstract TrainingPlanDAO trainingPlanDAO();
    public abstract WorkoutDAO workoutDAO();
    public abstract WPlanDAO wPlanDAO();
    public abstract WRecordDAO wRecordDAO();
}
