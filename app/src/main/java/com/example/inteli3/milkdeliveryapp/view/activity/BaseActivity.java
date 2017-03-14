package com.example.inteli3.milkdeliveryapp.view.activity;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.inteli3.milkdeliveryapp.R;

public class BaseActivity extends AppCompatActivity {

    ProgressDialog progressDialog;
    public void startProgressDialog(String message)
    {
        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage(message);
        progressDialog.show();
    }
    public void stopProgressDialog()
    {
        if(progressDialog!=null) {
            progressDialog.dismiss();
        }
    }


}
