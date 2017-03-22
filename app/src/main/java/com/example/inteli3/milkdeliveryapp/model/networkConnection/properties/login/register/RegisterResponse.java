package com.example.inteli3.milkdeliveryapp.model.networkConnection.properties.login.register;

import com.example.inteli3.milkdeliveryapp.model.networkConnection.properties.login.Result;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by intel i3 on 3/15/2017.
 */
public class RegisterResponse {
    @SerializedName("result")
    @Expose
    private Result result;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
