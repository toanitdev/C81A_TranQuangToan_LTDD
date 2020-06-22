package com.toanitdev.nowfake.interactor;

import com.toanitdev.nowfake.features.login.LoginView;
import com.toanitdev.nowfake.models.Response.LoginResponse;
import com.toanitdev.nowfake.rest_adapter.RestAdapter;
import com.toanitdev.nowfake.services.CustomerService;

import retrofit2.Retrofit;
import rx.Observable;

public class Login {

    Retrofit retrofit;

    CustomerService customerService;

    public Login() {
        retrofit = RestAdapter.create();
        customerService = retrofit.create(CustomerService.class);
    }

    public Observable<LoginResponse> excute(String user ,String password){

        return customerService.login(user,password);
    }
}
