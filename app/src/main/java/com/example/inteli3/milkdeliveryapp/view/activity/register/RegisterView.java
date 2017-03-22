package com.example.inteli3.milkdeliveryapp.view.activity.register;

import com.example.inteli3.milkdeliveryapp.model.networkConnection.properties.login.register.RegisterResponse;

/**
 * Created by intel i3 on 3/14/2017.
 */
public interface RegisterView {
    void onRegistrationComplete(RegisterResponse response);
    void startProgress();
    void stopProgress();
    void showFeedbackMessage(String message);
}
