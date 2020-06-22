package com.toanitdev.nowfake.interactor;

import com.toanitdev.nowfake.models.Response.CustomerResponse;
import com.toanitdev.nowfake.rest_adapter.RestAdapter;
import com.toanitdev.nowfake.services.CartService;
import com.toanitdev.nowfake.services.CustomerService;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import rx.Observable;

public class CountCartByIdCustomer  {

  Retrofit retrofit;

  CartService cartService;

  public CountCartByIdCustomer() {
    retrofit = RestAdapter.create();
    cartService = retrofit.create(CartService.class);
  }

  public Observable<ResponseBody> excute(String id){

    return cartService.countCart(id);
  }
}
