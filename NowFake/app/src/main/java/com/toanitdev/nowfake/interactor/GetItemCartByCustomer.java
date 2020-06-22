package com.toanitdev.nowfake.interactor;

import com.toanitdev.nowfake.models.Response.DishResponse;
import com.toanitdev.nowfake.rest_adapter.RestAdapter;
import com.toanitdev.nowfake.services.CartService;
import com.toanitdev.nowfake.services.DishService;

import java.util.List;

import retrofit2.Retrofit;
import rx.Observable;

public class GetItemCartByCustomer {
  Retrofit retrofit;
  CartService cartService;
  public GetItemCartByCustomer() {
    retrofit = RestAdapter.create();
    cartService = retrofit.create(CartService.class);
  }

  public Observable<List<DishResponse>> excute(String idCustomer){

    return cartService.getItemCartByCustomer(idCustomer);
  }
}
