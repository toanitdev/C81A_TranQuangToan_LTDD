package com.toanitdev.nowfake.interactor;

import com.toanitdev.nowfake.models.Response.ResultResponse;
import com.toanitdev.nowfake.rest_adapter.RestAdapter;
import com.toanitdev.nowfake.services.CartService;
import com.toanitdev.nowfake.services.OrderService;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import rx.Observable;

public class AddOrder {

  Retrofit retrofit;
  OrderService orderService;

  public AddOrder() {
    retrofit = RestAdapter.create();
    orderService = retrofit.create(OrderService.class);
  }

  public Observable<ResultResponse> excute(String idCustomer,String numberPhone,String shippingAddress,double total){

    return orderService.putOrder(idCustomer,numberPhone,shippingAddress,total);
  }
}
