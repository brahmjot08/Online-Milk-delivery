package com.example.inteli3.milkdeliveryapp.view.activity.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.inteli3.milkdeliveryapp.R;
import com.example.inteli3.milkdeliveryapp.model.networkConnection.properties.login.LoginResultPrp;
import com.example.inteli3.milkdeliveryapp.view.activity.BaseActivity;



public class LoginActivity extends BaseActivity implements LoginView, View.OnClickListener {

EditText editTextEmail;
    EditText editNumPass;
    Button buttonLogin;


    ILoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginPresenter=new LoginPresenter(this,this);
        editTextEmail=(EditText)findViewById(R.id.editTextEmail);
        editNumPass=(EditText)findViewById(R.id.editNumPass);
        buttonLogin=(Button)findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(this);

    }

    @Override
    public void onLoginComplete(LoginResultPrp loginResult) {
        Toast.makeText(this,loginResult.getResult().getMessage(), Toast.LENGTH_SHORT).show();


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


    @Override
    public void onClick(View view) {
        loginPresenter.requestLogin(editTextEmail.getText().toString(),editNumPass.getText().toString());

    }
    public void onForgotPasswordClick(View view)
    {
        loginPresenter.requestForgotPassword(editTextEmail.getText().toString());
    }

}
