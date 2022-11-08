package com.stickware.jani5.gui.snav;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.stickware.jani5.R;
import com.stickware.jani5.gui.library.navigation.MainNavBar;

public class SnavActivity extends AppCompatActivity {

    public MainNavBar mainNavBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        //Initiate layout aspects
        setContentView(R.layout.snav_activity);

        mainNavBar = new MainNavBar(this, R.string.app_name, true);
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
