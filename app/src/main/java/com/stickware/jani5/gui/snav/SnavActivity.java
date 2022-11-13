package com.stickware.jani5.gui.snav;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.stickware.jani5.R;
import com.stickware.jani5.gui.library.navigation.MainNavBar;

public class SnavActivity extends AppCompatActivity {

    public static MainNavBar mainNavBar;
    public static boolean hasMenuBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        //Initiate layout aspects
        setContentView(R.layout.snav_activity);
        mainNavBar = new MainNavBar(this, R.string.app_name, true);

        //Initiate selected Snav Fragment Desired
        for (SnavLocations loc : SnavLocations.values()) {
            if (this.getResources().getString(loc.mKey).equals(getIntent().getExtras().getString("Starter"))) {
                getSupportFragmentManager().beginTransaction().add(R.id.frag_container_sa, loc.mFrag).commit();
                break;
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    //Handle Options Selected From ActionBar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        if(!hasMenuBar){
            return false;
        }
        else if(mainNavBar.getmToggle().onOptionsItemSelected(item)){
            mainNavBar.setNavViewListener(this);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
