package com.toanitdev.nowfake.services;

import com.toanitdev.nowfake.Constant;
import com.toanitdev.nowfake.models.Response.DishResponse;
import com.toanitdev.nowfake.models.Response.LoginResponse;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;
import rx.Observable;

public interface DishService {
  @Headers("Content-Type: application/json")
  @GET(Constant.GET_DISH_ALL)
  Observable<List<DishResponse>> getListDishALl();

  @Headers("Content-Type: application/json")
  @GET(Constant.GET_DISH_HOT_DEAL)
  Observable<List<DishResponse>> getListDishHotDeal();

  @Headers("Content-Type: application/json")
  @GET(Constant.GET_DISH_SEARCH)
  Observable<List<DishResponse>> getDishSearch(@Query("name") String keywordName);

  @Headers("Content-Type: application/json")
  @GET(Constant.GET_DIST_DETAIL)
  Observable<DishResponse> getDishDetail(@Query("id") String id);
}
