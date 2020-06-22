package com.toanitdev.nowfake.features.landing;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.toanitdev.nowfake.interactor.GetDishFoodAll;
import com.toanitdev.nowfake.interactor.GetDishHotDeal;
import com.toanitdev.nowfake.models.Response.DishResponse;
import com.toanitdev.nowfake.models.Response.LoginResponse;

import java.util.List;

import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class LandingPresenter<T extends AppCompatActivity>
{

    GetDishFoodAll getDishFoodAll;
    GetDishHotDeal getDishHotDeal;
    LandingActivity activity;

    public LandingPresenter(T activity) {
        this.activity = (LandingActivity) activity;
        getDishFoodAll = new GetDishFoodAll();
        getDishHotDeal = new GetDishHotDeal();
    }


    public void getListFoodAll(){
        getDishFoodAll.excute().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<DishResponse>>() {
                    @Override
                    public void call(List<DishResponse> dishResponse) {
                        activity.renderListFood(dishResponse);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {

                    }
                });
    }

  public void getListHotDeal(){
    getDishHotDeal.excute().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<List<DishResponse>>() {
              @Override
              public void call(List<DishResponse> dishResponse) {
                activity.renderHotDeal(dishResponse);
              }
            }, new Action1<Throwable>() {
              @Override
              public void call(Throwable throwable) {

              }
            });
  }



}
