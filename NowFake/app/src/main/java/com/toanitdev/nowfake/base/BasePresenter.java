package com.toanitdev.nowfake.base;

import androidx.appcompat.app.AppCompatActivity;

import com.toanitdev.nowfake.features.cart.CartActivity;
import com.toanitdev.nowfake.interactor.CountCartByIdCustomer;
import com.toanitdev.nowfake.interactor.GetItemCartByCustomer;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class BasePresenter<T extends AppCompatActivity> {


  BaseActivity activity;
  CountCartByIdCustomer countCartByIdCustomer;
  public BasePresenter(T activity){
    this.activity = (BaseActivity) activity;
    this.countCartByIdCustomer = new CountCartByIdCustomer();
  }

  public  void getCountCart(String idCustomer){
    countCartByIdCustomer.excute(idCustomer).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((responses -> {
      activity.renderCountCart(responses);
    }),throwable -> {
      activity.renderCountCartFailed("0");
    });

  }
}
