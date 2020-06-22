package com.toanitdev.nowfake.interactor;

import com.toanitdev.nowfake.features.login.LoginView;
import com.toanitdev.nowfake.models.Response.DishResponse;
import com.toanitdev.nowfake.rest_adapter.RestAdapter;
import com.toanitdev.nowfake.services.DishService;

import java.util.List;

import retrofit2.Retrofit;
import rx.Observable;

public class GetDishFoodAll {

  Retrofit retrofit;
  LoginView view;

  DishService dishService;

  public GetDishFoodAll() {
    retrofit = RestAdapter.create();
    dishService = retrofit.create(DishService.class);
  }

  public Observable<List<DishResponse>> excute(){

    return dishService.getListDishALl();
  }
}
