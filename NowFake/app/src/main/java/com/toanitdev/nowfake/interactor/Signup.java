package com.toanitdev.nowfake.interactor;

import com.toanitdev.nowfake.models.Response.LoginResponse;
import com.toanitdev.nowfake.models.Response.ResultResponse;
import com.toanitdev.nowfake.rest_adapter.RestAdapter;
import com.toanitdev.nowfake.services.CustomerService;

import retrofit2.Retrofit;
import rx.Observable;

public class Signup {

  Retrofit retrofit;

  CustomerService customerService;

  public Signup() {
    retrofit = RestAdapter.create();
    customerService = retrofit.create(CustomerService.class);
  }

  public Observable<ResultResponse> excute(String user , String password, String name, String phone, String email, String dob){

    return customerService.signup(user,password,name,phone,email,dob);
  }
}
