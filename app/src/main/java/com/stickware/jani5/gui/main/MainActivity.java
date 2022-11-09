package com.stickware.jani5.gui.main;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.stickware.jani5.R;
import com.stickware.jani5.gui.library.navigation.MainNavBar;

public class MainActivity extends AppCompatActivity {

    public MainNavBar mainNavBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        //Initiate layout aspects
        setContentView(R.layout.main_activity);

        mainNavBar = new MainNavBar(this, R.string.app_name, true);

        //Set Listeners for bNav
        BottomNavigationView bNav = findViewById(R.id.bnav_ma);
        bNav.setOnItemSelectedListener(item -> {
            navigateLocation(item);
            return true;
        });
        bNav.setOnItemReselectedListener(this::navigateLocation);
        //Navigate to default Day
        //Todo:  Add navigate to last persistence
        bNav.setSelectedItemId(R.id.bnav_day);
    }

    //Navigate to main location based on MenuItem from Bnav listener
    private void navigateLocation(MenuItem item){

        for(MainLocations loc : MainLocations.values()){
            if(item.getTitle().equals(getResources().getString(loc.mKey))){
                System.out.println("HERE");
                getSupportFragmentManager().beginTransaction().replace(R.id.frag_container_ma, loc.mFrag).commit();
                break;
            }
        }
    }

    //Handle Options Selected From ActionBar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        if(mainNavBar.getmToggle().onOptionsItemSelected(item)){
            mainNavBar.setNavViewListener(this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
