package com.toanitdev.nowfake.features.cart;

import androidx.appcompat.app.AppCompatActivity;

import com.toanitdev.nowfake.interactor.GetItemCartByCustomer;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CartPresenter<T extends AppCompatActivity> {


  CartActivity activity;
  GetItemCartByCustomer getItemCartByCustomer;
  public CartPresenter(T activity){
    this.activity = (CartActivity) activity;
    this.getItemCartByCustomer = new GetItemCartByCustomer();
  }

  public  void getCart(String idCustomer){
    getItemCartByCustomer.excute(idCustomer).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((responses -> {
      activity.renderListCartItems(responses);
    }),throwable -> {
      activity.renderListCartItemsFailed();

    });

  }

}
