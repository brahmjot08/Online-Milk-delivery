package com.example.inteli3.milkdeliveryapp.view.activity.login;

import com.example.inteli3.milkdeliveryapp.R;
import com.example.inteli3.milkdeliveryapp.model.networkConnection.IBaseUrl;
import com.example.inteli3.milkdeliveryapp.model.networkConnection.WebInterface;
import com.example.inteli3.milkdeliveryapp.model.networkConnection.properties.login.LoginResultPrp;
import com.example.inteli3.milkdeliveryapp.view.activity.BaseActivity;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by intel i3 on 3/6/2017.
 */
public class LoginPresenter implements ILoginPresenter,IBaseUrl {
    LoginView loginView;
    BaseActivity activity;

    public LoginPresenter(LoginView loginView, BaseActivity activity) {
        this.loginView=loginView;
        this.activity=activity;
    }

    @Override
    public void requestLogin(String email, String password) {
if(checkFieldEmpty(email,"PASSWORD"))
{
    if(isEmailValid(email))
    {
        makeLoginRequest(email, password);
    }
}
    }

    private boolean isEmailValid(String email) {
        return true;
    }



    @Override
    public void requestForgotPassword(String email) {
        if(checkFieldEmpty(email,"PASSWORD"))
        {
            if(isEmailValid(email))
            {
                makeForgotPasswordRequest(email);
            }
        }

    }
    private boolean checkFieldEmpty(String email,String password)
    {
        if(email.trim().length()==0)
        {
            loginView.showFeedbackMessage(activity.getString(R.string.emailempty));
            return false;
        }
        else if(password.trim().length()==0)
        {
            loginView.showFeedbackMessage(activity.getString(R.string.passwordEmpty));
            return false;
        }
        else
        {
            return true;
        }
    }

    private void makeForgotPasswordRequest(String email) {
loginView.startProgress();
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        final Call<ResponseBody> result=retrofit.create(WebInterface.class).requestForgetPassword(email);
        result.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                loginView.stopProgress();
                loginView.onForgetPasswordComplete();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
             loginView.stopProgress();
                loginView.showFeedbackMessage(activity.getString(R.string.pleaseEnterValidEmail));
            }
        });
    }

    public void makeLoginRequest(String email,String password)
    {
        loginView.startProgress();
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        final Call<LoginResultPrp> result=retrofit.create(WebInterface.class).requestLogin(email,password);
        result.enqueue(new Callback<LoginResultPrp>() {
            @Override
            public void onResponse(Call<LoginResultPrp> call, Response<LoginResultPrp> response) {
                loginView.stopProgress();
                loginView.onLoginComplete(response.body());
            }

            @Override
            public void onFailure(Call<LoginResultPrp> call, Throwable t) {
                loginView.stopProgress();
                loginView.showFeedbackMessage(activity.getString(R.string.wrongusernamepassword));
            }
        });
    }
}
