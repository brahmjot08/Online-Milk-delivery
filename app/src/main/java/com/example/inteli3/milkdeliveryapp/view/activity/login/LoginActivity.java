package com.example.inteli3.milkdeliveryapp.view.activity.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.inteli3.milkdeliveryapp.R;
import com.example.inteli3.milkdeliveryapp.model.networkConnection.properties.login.LoginResultPrp;
import com.example.inteli3.milkdeliveryapp.utils.customcontrols.dialogs.sharedpref.MW_SharedPref;
import com.example.inteli3.milkdeliveryapp.view.activity.BaseActivity;
import com.example.inteli3.milkdeliveryapp.view.activity.profile.ProfileActivity;
import com.example.inteli3.milkdeliveryapp.view.activity.register.RegisterActivity;


public class LoginActivity extends BaseActivity implements LoginView {

EditText editTextEmail;
    EditText editNumPass;
    Button buttonLogin;
    TextView textViewRegister;


    ILoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter=new LoginPresenter(this,this);
        editTextEmail=(EditText)findViewById(R.id.editTextEmail);
        editNumPass=(EditText)findViewById(R.id.editNumPass);
        buttonLogin=(Button)findViewById(R.id.buttonLogin);
     /*   buttonLogin.setOnClickListener(this);*/
        textViewRegister=(TextView) findViewById(R.id.textViewRegister);
        /*textViewRegister.setOnClickListener(this);*/


    }

    @Override
    public void onLoginComplete(LoginResultPrp loginResult) {
        if(loginResult.getResult().getStatus()==1)
        {
            MW_SharedPref sharedPref=new MW_SharedPref();
            sharedPref.setInt(this,sharedPref.USER_ID,loginResult.getResult().getId());
            startActivity(new Intent(this, ProfileActivity.class));
            finish();

        }
        else
        {
            Toast.makeText(this,getString(R.string.wrongusernamepassword),Toast.LENGTH_SHORT).show();
        }



    }

    @Override
    public void startProgress() {
        startProgressDialog(getString(R.string.loadingPleasewait));


    }

    @Override
    public void stopProgress() {
        stopProgressDialog();
    }

    @Override
    public void showFeedbackMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onForgetPasswordComplete() {

    }



    public void onLoginClick(View view) {
        loginPresenter.requestLogin(editTextEmail.getText().toString(),editNumPass.getText().toString());

    }

    public void onForgotPasswordClick(View view)
    {
        loginPresenter.requestForgotPassword(editTextEmail.getText().toString());
    }
    public void onRegisterClick(View view)
    {
        startActivity(new Intent(this, RegisterActivity.class));
    }

/*    @Override
    public void onClick(View view) {
        if(R.id.buttonLogin==1)
        {
            loginPresenter.requestLogin(editTextEmail.getText().toString(),editNumPass.getText().toString());
        }
        else
        {
            startActivity(new Intent(this, RegisterActivity.class));
        }
    }*/
}
