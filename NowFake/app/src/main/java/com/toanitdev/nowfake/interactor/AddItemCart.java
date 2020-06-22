package com.toanitdev.nowfake.interactor;

import com.toanitdev.nowfake.rest_adapter.RestAdapter;
import com.toanitdev.nowfake.services.CartService;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import rx.Observable;

public class AddItemCart {

    Retrofit retrofit;
    CartService cartService;

    public AddItemCart() {
      retrofit = RestAdapter.create();
      cartService = retrofit.create(CartService.class);
    }

    public Observable<ResponseBody> excute(String idDish, String idCustomer){

      return cartService.putItemCart(idDish,idCustomer);
    }
}
