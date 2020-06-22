package com.toanitdev.nowfake.services;

import com.toanitdev.nowfake.Constant;
import com.toanitdev.nowfake.models.Response.OrderResponse;
import com.toanitdev.nowfake.models.Response.ResultResponse;

import java.util.List;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface OrderService {


  @FormUrlEncoded
  @POST(Constant.PUT_ORDER)
  Observable<ResultResponse> putOrder(@Field("idCustomer") String idCustomer
      ,@Field("numberPhone") String numberPhone
      ,@Field("shippingAddress") String shippingAddress
      ,@Field("total") double total);

  @GET(Constant.GET_LIST_ORDER)
  Observable<List<OrderResponse>> getOrder(@Query("idOrder") String idOrder);
}
