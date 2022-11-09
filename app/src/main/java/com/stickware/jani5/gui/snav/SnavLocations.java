package com.stickware.jani5.gui.snav;

import androidx.fragment.app.Fragment;

import com.stickware.jani5.R;
import com.stickware.jani5.gui.snav.calendar.CalendarMainFrag;
import com.stickware.jani5.gui.snav.goals.GoalsMainFrag;
import com.stickware.jani5.gui.snav.my_bod.MyBodMainFrag;
import com.stickware.jani5.gui.snav.nutrition.NutritionMainFrag;
import com.stickware.jani5.gui.snav.plan.PlanMainFrag;
import com.stickware.jani5.gui.snav.profile.ProfileMainFrag;
import com.stickware.jani5.gui.snav.settings.SettingsMainFrag;
import com.stickware.jani5.gui.snav.support_library.SLibMainFrag;
import com.stickware.jani5.gui.snav.workout_library.WLibMainFrag;

public enum SnavLocations {

    Calendar(new CalendarMainFrag(), R.string.calendar_frag_name),
    Goals(new GoalsMainFrag(), R.string.goals_frag_name),
    MyBod(new MyBodMainFrag(), R.string.mybod_frag_name),
    Nutrition(new NutritionMainFrag(), R.string.nutrition_frag_name),
    Plan(new PlanMainFrag(), R.string.plan_frag_name),
    Profile(new ProfileMainFrag(), R.string.profile_frag_name),
    Settings(new SettingsMainFrag(), R.string.settings_frag_name),
    SupportLibrary(new SLibMainFrag(), R.string.slib_frag_name),
    WorkoutLibrary(new WLibMainFrag(), R.string.wlib_frag_name);

    final Fragment mFrag;
    final int mKey;

    SnavLocations(Fragment frag, int key) {
        mFrag = frag;
        mKey = key;
    }
}
