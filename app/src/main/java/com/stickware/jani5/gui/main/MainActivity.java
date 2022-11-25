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
import com.stickware.jani5.servers.AppDatabase;
import com.stickware.jani5.servers.TestDao;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.BiConsumer;
import io.reactivex.rxjava3.functions.Consumer;

public class MainActivity extends AppCompatActivity {

    public MainNavBar mainNavBar;

    /*
    private class MyTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params){
            String url = params[0];
            AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "new-base").fallbackToDestructiveMigration().build();
            UserDao userDao = db.userDao();
            TestDataObject[] testing = new TestDataObject[]{new TestDataObject("Codl", 5)};
            userDao.insertAll(testing);
            TestDataObject copy = userDao.findByName("Codl", 5);
            copy.printName();
            db.close();
            return doSomeWork(url);
        }

        @Override
        protected void onPostExecute(String result){
            super.onPostExecute(result);
            System.err.println(result);
        }
    }

    public String doSomeWork(String input){
        return input;
    }*/

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
        //new MyTask().execute("Test");



        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());
        executorService.execute(() -> {

            AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "new-base").fallbackToDestructiveMigration().build();
            TestDao userDao = db.testDao();
            TestDataObject[] testing = new TestDataObject[]{new TestDataObject("Codl", 5)};
            userDao.insertAll(testing);
            TestDataObject copy = userDao.findByName("Codl", 5);


            handler.post(new Runnable() {
                @Override
                public void run() {

                    System.out.println("POST THE RUNNABLE?");
                    copy.printName();
                }
            });
        });

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
