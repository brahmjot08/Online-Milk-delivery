package com.example.inteli3.milkdeliveryapp.utils.customcontrols.dialogs.sharedpref;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by intel i3 on 3/20/2017.
 */
public class MW_SharedPref {
    public String USER_ID="USER_ID";
    String PREF_NAME="MW_SharedPrefAMIT";

    public void setInt(Activity activity,String variable,int value)
    {
        SharedPreferences sharedPreferences=activity.getSharedPreferences(PREF_NAME,0);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(variable,value);
        editor.commit();
    }
    public int getInt(Activity activity,String variable)
    {
        SharedPreferences sharedPreferences=activity.getSharedPreferences(PREF_NAME,0);
        int value=sharedPreferences.getInt(variable,-1);
        return value;
    }
    public void clearAll(Activity activity)
    {
        SharedPreferences sharedPreferences=activity.getSharedPreferences(PREF_NAME,0);
        sharedPreferences.edit().clear().commit();
    }

}
