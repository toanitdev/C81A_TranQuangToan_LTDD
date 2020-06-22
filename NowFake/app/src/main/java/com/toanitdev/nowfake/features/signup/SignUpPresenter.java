package com.toanitdev.nowfake.features.signup;

import androidx.appcompat.app.AppCompatActivity;

import com.toanitdev.nowfake.base.BaseActivity;
import com.toanitdev.nowfake.interactor.Signup;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SignUpPresenter<T extends AppCompatActivity> {



  SignUpActivity activity;
  Signup signup;
  public SignUpPresenter(T activity) {
  this.activity = (SignUpActivity) activity;
  this.signup = new Signup();
  }


  public void signup(String user , String password, String name, String phone, String email, String dob){
    signup.excute(user, password, name, phone, email, dob).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(resultResponse -> {
      if(resultResponse.isState())
        activity.renderResultSuccess(resultResponse);
      else
        activity.renderResultFailed(resultResponse);
    },throwable -> {
      activity.renderResultError(throwable);
    });
  }


}
