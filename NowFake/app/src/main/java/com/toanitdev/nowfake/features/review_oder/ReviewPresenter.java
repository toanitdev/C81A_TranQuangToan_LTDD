package com.toanitdev.nowfake.features.review_oder;

import androidx.appcompat.app.AppCompatActivity;

import com.toanitdev.nowfake.interactor.AddOrder;
import com.toanitdev.nowfake.interactor.GetCustomer;
import com.toanitdev.nowfake.interactor.GetItemCartByCustomer;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ReviewPresenter<T extends AppCompatActivity> {

  ReviewActivity activity;
  GetItemCartByCustomer getItemCartByCustomer;
  GetCustomer getCustomer;
  AddOrder addOrder;
  public ReviewPresenter(ReviewActivity activity) {
    this.activity = activity;
    this.getItemCartByCustomer = new GetItemCartByCustomer();
    this.getCustomer = new GetCustomer();
    this.addOrder = new AddOrder();
  }

  public void getCartItem(String idCustomer){
    getItemCartByCustomer.excute(idCustomer).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(responses -> {
      activity.renderCartItemList(responses);
    });
  }

  public void getCustomer(String idCustomer){
    getCustomer.excute(idCustomer).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(customerResponse -> {
      activity.renderCustomer(customerResponse);
    });
  }

  public  void  putOrder(String idCustomer,String numberPhone,String shippingAddress,double total){
    addOrder.excute(idCustomer,numberPhone,shippingAddress,total).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(resultResponse -> {

      if(resultResponse.isState())
        activity.renderConfirmSuccess(resultResponse);
      else
        activity.renderConfirmFailed(resultResponse);

    },throwable -> {
      activity.renderConfirmError(throwable);
    });
  }
}
