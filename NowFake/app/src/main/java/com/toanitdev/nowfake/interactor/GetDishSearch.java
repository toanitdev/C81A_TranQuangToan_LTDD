package com.toanitdev.nowfake.interactor;

import com.toanitdev.nowfake.features.login.LoginView;
import com.toanitdev.nowfake.models.Response.DishResponse;
import com.toanitdev.nowfake.rest_adapter.RestAdapter;
import com.toanitdev.nowfake.services.DishService;

import java.util.List;

import retrofit2.Retrofit;
import rx.Observable;

public class GetDishSearch {

  Retrofit retrofit;

  DishService dishService;

  public GetDishSearch() {
    retrofit = RestAdapter.create();
    dishService = retrofit.create(DishService.class);
  }

  public Observable<List<DishResponse>> excute(String name){

    return dishService.getDishSearch(name);
  }
}
