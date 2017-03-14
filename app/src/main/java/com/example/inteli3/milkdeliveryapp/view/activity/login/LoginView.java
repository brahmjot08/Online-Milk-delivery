package com.example.inteli3.milkdeliveryapp.view.activity.login;

import com.example.inteli3.milkdeliveryapp.model.networkConnection.properties.login.LoginResultPrp;

/**
 * Created by intel i3 on 3/3/2017.
 */
public interface LoginView {
    void onLoginComplete(LoginResultPrp loginResult);

    void startProgress();
    void stopProgress();

    void showFeedbackMessage(String message);

    void onForgetPasswordComplete();
}
