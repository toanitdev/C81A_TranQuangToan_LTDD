package com.toanitdev.nowfake.features.order_list;

import com.toanitdev.nowfake.base.BaseActivity;
import com.toanitdev.nowfake.base.BasePresenter;
import com.toanitdev.nowfake.interactor.GetOrder;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MyOrderPresenter<T extends BaseActivity> extends BasePresenter {

  MyOrderActivity activity;
  GetOrder getOrder;

  public MyOrderPresenter(T activity){
    super(activity);
    this.activity = (MyOrderActivity) activity;
    this.getOrder = new GetOrder();
  }

  @Override
  public void getCountCart(String idCustomer) {
    super.getCountCart(idCustomer);
  }

  public  void getOrder(String idCustomer){
    getOrder.excute(idCustomer).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(orderResponses -> {
        activity.renderListOrder(orderResponses);
    },throwable -> {

    });
  }
}
