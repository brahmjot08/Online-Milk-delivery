package com.example.inteli3.milkdeliveryapp.view.activity.register;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.inteli3.milkdeliveryapp.R;
import com.example.inteli3.milkdeliveryapp.model.networkConnection.properties.login.register.RegisterBody;
import com.example.inteli3.milkdeliveryapp.model.networkConnection.properties.login.register.RegisterResponse;
import com.example.inteli3.milkdeliveryapp.view.activity.BaseActivity;

import okhttp3.ResponseBody;

public class RegisterActivity extends BaseActivity implements RegisterView, View.OnClickListener {
EditText editTextEmail;
    EditText editTextPassword;
    EditText editTextMobileNumber;
    EditText editTextUserName;
    IRegisterPresenter registerPresenter;
    Button buttonRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerPresenter=new RegisterPresenter(this,this);
        editTextEmail=(EditText)findViewById(R.id.editTextEmail);
        editTextPassword=(EditText)findViewById(R.id.editTextPassword);
        editTextMobileNumber=(EditText)findViewById(R.id.editTextMobileNumber);
        editTextUserName=(EditText)findViewById(R.id.editTextUserName);
        buttonRegister=(Button)findViewById(R.id.buttonSignUp);
        buttonRegister.setOnClickListener(this);

    }

    @Override
    public void onRegistrationComplete(RegisterResponse response) {
        Toast.makeText(this,getString(R.string.RegistrationSuccessful),Toast.LENGTH_SHORT).show();
        this.finish();
    }

    @Override
    public void startProgress() {
startProgressDialog(getString(R.string.registrationProcess));
    }

    @Override
    public void stopProgress() {
stopProgressDialog();
    }

    @Override
    public void showFeedbackMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();

    }
    public void onClick(View v)
    {
        RegisterBody registerBody=new RegisterBody();
        registerBody.setEmail(editTextEmail.getText().toString());
        registerBody.setMobileNumber(editTextMobileNumber.getText().toString());
        registerBody.setUserName(editTextUserName.getText().toString());
        registerBody.setPassword(editTextPassword.getText().toString());
        registerBody.setDeviceToken("dsfa");
        registerPresenter.requestRegister(registerBody);


    }
}
