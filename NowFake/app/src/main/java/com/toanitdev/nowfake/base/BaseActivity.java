package com.toanitdev.nowfake.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.toanitdev.nowfake.utils.PreferenceUtils;

import java.io.IOException;

import okhttp3.ResponseBody;

public class BaseActivity extends AppCompatActivity implements BaseView {

  public BasePresenter presenter;
  @Override
  protected void onStart() {
    super.onStart();
    presenter =  new BasePresenter(this);
    presenter.getCountCart(PreferenceUtils.loadCustomerID(this));
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  public void renderCountCart(ResponseBody responseBody) {
    try {
      PreferenceUtils.saveCountCart(this,responseBody.string());
    } catch (IOException e) {
      e.printStackTrace();
      PreferenceUtils.saveCountCart(this,"0");
    }
  }

  public void Toast(String mes){
    Toast.makeText(this,""+mes,Toast.LENGTH_SHORT).show();
  }

  @Override
  public void renderCountCartFailed(String str) {
    PreferenceUtils.saveCountCart(this,str);
  }
}
