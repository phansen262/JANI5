package com.stickware.jani5.gui.startup;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.stickware.jani5.R;
import com.stickware.jani5.gui.main.MainActivity;
import com.stickware.jani5.servers.LocationServer;

public class LauncherActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        //Entrance time log to set control for minimum splashscreen display
        long start = System.currentTimeMillis();

        /*Start Initialization Methods*/
        setContentView(R.layout.start_launcher_activity);

        setServers();
        /*End Initialization Methods*/

        //Exit time log to set control for minimum splashscreen display
        long end = System.currentTimeMillis();

        //Check startup timer and log
        long elapsed = end - start;
        Log.d("JANI INFO", "Startup time in Millie's for initialization:  " + elapsed);

        //Proceed to Next Activity
        if(elapsed > 1500){
            toMainActivity();
        } else {
            //Set remaining time to wait
            new Handler(Looper.getMainLooper()).postDelayed(this::toMainActivity, 1500 - elapsed);
        }
    }

    private void toMainActivity(){
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void setServers(){
        LocationServer.setLocationServer();
    }
}
