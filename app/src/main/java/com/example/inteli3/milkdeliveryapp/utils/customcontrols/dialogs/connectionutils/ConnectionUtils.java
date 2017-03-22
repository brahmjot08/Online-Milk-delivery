package com.example.inteli3.milkdeliveryapp.utils.customcontrols.dialogs.connectionutils;

import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by intel i3 on 3/22/2017.
 */
public class ConnectionUtils {
    public boolean checkInternetConnection(Activity activity) {
        ConnectivityManager connectionService = (ConnectivityManager) activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectionService.getActiveNetworkInfo(); boolean isNetworkConnected=false; try { if (networkInfo.isConnected()==true) isNetworkConnected=true; else
            isNetworkConnected=false;
        }
        catch (NullPointerException e)
        {
            isNetworkConnected=false;
        }


        try
        {
            if(networkInfo.isConnectedOrConnecting()==true)
            {
                isNetworkConnected=true;
            }
            else
            {
                isNetworkConnected=false;
            }
        }
        catch (NullPointerException e)
        {
            isNetworkConnected=false;
        }

        return isNetworkConnected;


    }
}
