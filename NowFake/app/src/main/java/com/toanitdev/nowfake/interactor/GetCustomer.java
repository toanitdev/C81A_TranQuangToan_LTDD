package com.toanitdev.nowfake.interactor;

import com.toanitdev.nowfake.models.Response.CustomerResponse;
import com.toanitdev.nowfake.models.Response.DishResponse;
import com.toanitdev.nowfake.rest_adapter.RestAdapter;
import com.toanitdev.nowfake.services.CustomerService;
import com.toanitdev.nowfake.services.DishService;

import retrofit2.Retrofit;
import rx.Observable;

public class GetCustomer {

  Retrofit retrofit;

  CustomerService customerService;

  public GetCustomer() {
    retrofit = RestAdapter.create();
    customerService = retrofit.create(CustomerService.class);
  }

  public Observable<CustomerResponse> excute(String id){

    return customerService.getCustomer(id);
  }
}
