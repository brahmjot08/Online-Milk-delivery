package com.example.inteli3.milkdeliveryapp.view.activity.login;

/**
 * Created by intel i3 on 3/6/2017.
 */
public interface ILoginPresenter {
    public void requestLogin(String email,String password);
    public void requestForgotPassword(String email);


}
