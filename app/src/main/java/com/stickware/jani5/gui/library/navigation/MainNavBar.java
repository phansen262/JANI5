package com.stickware.jani5.gui.library.navigation;

import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.stickware.jani5.R;
import com.stickware.jani5.gui.main.MainActivity;
import com.stickware.jani5.gui.snav.SnavActivity;
import com.stickware.jani5.gui.snav.calendar.CalendarMainFrag;
import com.stickware.jani5.gui.snav.goals.GoalsMainFrag;
import com.stickware.jani5.gui.snav.my_bod.MyBodMainFrag;
import com.stickware.jani5.gui.snav.nutrition.NutritionMainFrag;
import com.stickware.jani5.gui.snav.plan.PlanMainFrag;
import com.stickware.jani5.gui.snav.settings.SettingsMainFrag;
import com.stickware.jani5.gui.snav.support_library.SLibMainFrag;
import com.stickware.jani5.gui.snav.workout_library.WLibMainFrag;

public class MainNavBar {

    private final ActionBarDrawerToggle mToggle;
    private final ActionBar mBar;

    public MainNavBar(@NonNull AppCompatActivity activity, int barTitle, boolean menu){

        //Handle Action Bar Itself
        mBar = activity.getSupportActionBar();
        if(menu) {
            mBar.setHomeAsUpIndicator(R.drawable.ic_baseline_menu_24);
        } else {
            mBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        }
        mBar.setDisplayHomeAsUpEnabled(true);
        setBarTitle(barTitle);

        //Handle drawer layout and toggle
        DrawerLayout drawerLayout = activity.findViewById(R.id.drawer_ma);
        mToggle = new ActionBarDrawerToggle(activity, drawerLayout, barTitle, R.string.app_name);
        drawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
    }

    public void setNavViewListener(AppCompatActivity activity){

        //Set Listener for Navigation
        NavigationView navigationView = activity.findViewById(R.id.navigation_view_gsm);
        navigationView.setNavigationItemSelectedListener(item -> {

            if(item.getTitle().toString().equals("Home")){
                activity.startActivity(new Intent(activity, MainActivity.class));
            } else {
                activity.startActivity(new Intent(activity, SnavActivity.class).putExtra("Starter", item.getTitle().toString()));
            }
            activity.finish();
            return false;
        });
    }

    //Need to supply as String Resource
    public void setBarTitle(int barTitle){
        mBar.setTitle(barTitle);
    }

    //Allow toggle to be "got"
    public ActionBarDrawerToggle getmToggle(){return mToggle;}
}
