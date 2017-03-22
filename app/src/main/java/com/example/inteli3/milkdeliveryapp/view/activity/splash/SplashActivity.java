package com.example.inteli3.milkdeliveryapp.view.activity.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Connection;

import com.example.inteli3.milkdeliveryapp.R;
import com.example.inteli3.milkdeliveryapp.utils.customcontrols.dialogs.ApplicationDialogs;
import com.example.inteli3.milkdeliveryapp.utils.customcontrols.dialogs.connectionutils.ConnectionUtils;
import com.example.inteli3.milkdeliveryapp.utils.customcontrols.dialogs.sharedpref.MW_SharedPref;
import com.example.inteli3.milkdeliveryapp.view.activity.login.LoginActivity;
import com.example.inteli3.milkdeliveryapp.view.activity.profile.ProfileActivity;

public class SplashActivity extends AppCompatActivity {

    //Splash Time
    int SPLASH_TIME=3000;

    //Splash screen load starts
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
    @Override
    protected void onResume()
    {
        super.onResume();
        checkConnection();
    }
//check internet connection
    private void checkConnection() {

        //show dialog if there is no internet connection
        ConnectionUtils connectionUtils=new ConnectionUtils();
        boolean value=connectionUtils.checkInternetConnection(this);
        if(value==true)
        {
            startSplash();
        }
        else
        {
            ApplicationDialogs applicationDialogs=new ApplicationDialogs();
            applicationDialogs.showMessageDialogWithFinish(this,getString(R.string.internetConnectionMessage));
        }
    }

    private void startSplash() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Navigate to login or home screen
                MW_SharedPref sharedPref=new MW_SharedPref();
                if(sharedPref.getInt(SplashActivity.this,sharedPref.USER_ID)>0)
                {
                    Intent intent=new Intent(SplashActivity.this,ProfileActivity.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        },SPLASH_TIME);
    }


}

