package com.toanitdev.nowfake.interactor;

import com.toanitdev.nowfake.models.Response.DishResponse;
import com.toanitdev.nowfake.rest_adapter.RestAdapter;
import com.toanitdev.nowfake.services.DishService;

import retrofit2.Retrofit;
import rx.Observable;

public class GetDishDetail {


    Retrofit retrofit;

    DishService dishService;

    public GetDishDetail() {
      retrofit = RestAdapter.create();
      dishService = retrofit.create(DishService.class);
    }

    public Observable<DishResponse> excute(String id){

      return dishService.getDishDetail(id);
    }

}
