package com.example.inteli3.milkdeliveryapp.view.activity.register;

import com.example.inteli3.milkdeliveryapp.R;
import com.example.inteli3.milkdeliveryapp.model.networkConnection.IBaseUrl;
import com.example.inteli3.milkdeliveryapp.model.networkConnection.WebInterface;
import com.example.inteli3.milkdeliveryapp.model.networkConnection.properties.login.register.RegisterBody;
import com.example.inteli3.milkdeliveryapp.model.networkConnection.properties.login.register.RegisterResponse;
import com.example.inteli3.milkdeliveryapp.view.activity.BaseActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by intel i3 on 3/14/2017.
 */
public class RegisterPresenter implements IRegisterPresenter,IBaseUrl
{
    BaseActivity activity;
    RegisterView registerView;


    public RegisterPresenter(BaseActivity activity,RegisterView registerView)
    {
        this.activity=activity;
        this.registerView=registerView;
    }

    @Override
    public void requestRegister(RegisterBody registerBody) {

        if(!isFieldEmpty(registerBody.getUserName()))
        {
            registerView.showFeedbackMessage(activity.getString(R.string.usernameempty));
        }
        else if(!isFieldEmpty(registerBody.getEmail()))
        {
            registerView.showFeedbackMessage(activity.getString(R.string.emailempty));
        }
        else if(!isFieldEmpty(registerBody.getMobileNumber()))
        {
            registerView.showFeedbackMessage(activity.getString(R.string.phoneEmpty));

        }
        else
        {
            makeRegisterRequest(registerBody);

        }

    }

    private void makeRegisterRequest(RegisterBody registerBody) {
        registerView.startProgress();
        Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        final Call<RegisterResponse> result=retrofit.create(WebInterface.class).requestRegister(registerBody.getEmail(),registerBody.getPassword(),registerBody.getUserName(),registerBody.getMobileNumber(),registerBody.getDeviceToken());
        result.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                registerView.stopProgress();

                if(response.body().getResult().getStatus()>0) {
                    registerView.onRegistrationComplete(response.body());
                }
                else if(response.body().getResult().getStatus()==-2)
                {
                    registerView.showFeedbackMessage(activity.getString(R.string.thisemailidallreadyexist));
                }


            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {
                registerView.stopProgress();
                registerView.showFeedbackMessage(activity.getString(R.string.wrongusernamepassword));

            }
        });
    }

    private boolean isFieldEmpty(String value)
    {
        if(value.trim().length()==0)
        {
            return false;
        }
        return  true;
    }

}
