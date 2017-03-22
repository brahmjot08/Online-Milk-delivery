package com.example.inteli3.milkdeliveryapp.model.networkConnection;

import com.example.inteli3.milkdeliveryapp.model.networkConnection.properties.login.LoginResultPrp;
import com.example.inteli3.milkdeliveryapp.model.networkConnection.properties.login.register.RegisterResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by intel i3 on 3/5/2017.
 */
public interface WebInterface {
    @FormUrlEncoded
    @POST("milkwala/ws/login.php")
    Call<LoginResultPrp> requestLogin(@Field("email")String email,@Field("password") String password);

    @FormUrlEncoded
    @POST("milkwala/ws/forgetPassword.php")
    Call<ResponseBody> requestForgetPassword(@Field("email")String email);


    @FormUrlEncoded
    @POST("milkwala/ws/register.php")
    Call<RegisterResponse> requestRegister(@Field("email")String email, @Field("password") String password, @Field("userName")String username, @Field("phone") String phone, @Field("deviceToken")String deviceToken);
}
