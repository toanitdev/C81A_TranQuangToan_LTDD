package com.toanitdev.nowfake.interactor;

import com.toanitdev.nowfake.models.Response.OrderResponse;
import com.toanitdev.nowfake.rest_adapter.RestAdapter;
import com.toanitdev.nowfake.services.OrderService;

import java.util.List;

import retrofit2.Retrofit;
import rx.Observable;

public class GetOrder {
  Retrofit retrofit;

  OrderService orderService;

  public GetOrder() {
    retrofit = RestAdapter.create();
    orderService = retrofit.create(OrderService.class);
  }

  public Observable<List<OrderResponse>> excute(String idOrder){

    return orderService.getOrder(idOrder);
  }
}
