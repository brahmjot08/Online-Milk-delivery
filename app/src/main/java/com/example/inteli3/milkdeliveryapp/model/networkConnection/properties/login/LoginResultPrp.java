package com.example.inteli3.milkdeliveryapp.model.networkConnection.properties.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by intel i3 on 3/5/2017.
 */


public class LoginResultPrp {

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

