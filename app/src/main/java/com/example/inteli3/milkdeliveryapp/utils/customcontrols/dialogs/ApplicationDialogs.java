package com.example.inteli3.milkdeliveryapp.utils.customcontrols.dialogs;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.example.inteli3.milkdeliveryapp.R;

/**
 * Created by intel i3 on 3/22/2017.
 */
public class ApplicationDialogs {

    //show dialog and close on press of ok
    public void showMessageDialogWithFinish(final Activity activity,String message)
    {
        AlertDialog.Builder dialog=new AlertDialog.Builder(activity);
        dialog.setCancelable(false);
        dialog.setMessage(message);
        dialog.setTitle(activity.getString(R.string.feedback));
        dialog.setPositiveButton(activity.getString(R.string.oK), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                activity.finish();
            }
        });
dialog.show();
    }

    //show dialog and keep activity running on press of ok

    public void showMessageDialog(Activity activity,String message)
    {
        AlertDialog.Builder dialog=new AlertDialog.Builder(activity);
        dialog.setCancelable(false);
        dialog.setMessage(message);
        dialog.setTitle(activity.getString(R.string.feedback));
        dialog.setPositiveButton(activity.getString(R.string.ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        dialog.show();
    }

}
