package com.toanitdev.nowfake.features.my_profile;

import androidx.appcompat.app.AppCompatActivity;

import com.toanitdev.nowfake.base.BaseActivity;
import com.toanitdev.nowfake.base.BasePresenter;
import com.toanitdev.nowfake.interactor.GetCustomer;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MyProfilePresenter<T extends BaseActivity> extends BasePresenter{

  GetCustomer getCustomer;
  MyProfileActivity activity;
  public MyProfilePresenter(T activity) {
    super(activity);
    this.activity = (MyProfileActivity) activity;
    this.getCustomer = new GetCustomer();
  }


  public void getCustomer(String idCustomer){
    getCustomer.excute(idCustomer).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(customerResponse -> {

      activity.renderProfileSuccess(customerResponse);
    },throwable -> {
      activity.renderProfileError(throwable);
    });
  }
}
