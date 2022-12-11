package com.stickware.jani5.gui.main;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.stickware.jani5.R;
import com.stickware.jani5.gui.library.navigation.MainNavBar;
import com.stickware.jani5.logic.app_objects.TestDataObject;
import com.stickware.jani5.logic.database.AppDatabase;
import com.stickware.jani5.logic.database.TestDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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

        //Testing database and dao stuff
        //<editor-fold desc="Testing database and dao stuff">
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executorService.execute(() -> {

            AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "new-base").fallbackToDestructiveMigration().build();
            TestDao userDao = db.testDao();
            TestDataObject[] testing = new TestDataObject[]{new TestDataObject("Codl", 5)};
            userDao.insertAll(testing);
            TestDataObject copy = userDao.findByName("Codl", 5);
            db.close();

            handler.post(() -> {

                System.out.println("POST THE RUNNABLE?");
                copy.printName();
            });
        });
        //</editor-fold>
        //End Data base test

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
