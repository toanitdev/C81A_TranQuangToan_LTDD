package com.toanitdev.nowfake.features.shipping_page;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

public class ShippingPresenter<T extends AppCompatActivity> {



  ShippingActivity activity;
  public ShippingPresenter(T activity) {
    this.activity = (ShippingActivity) activity;
  }
}
