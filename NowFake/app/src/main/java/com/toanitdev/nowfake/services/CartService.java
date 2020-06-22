package com.toanitdev.nowfake.services;

import com.toanitdev.nowfake.Constant;
import com.toanitdev.nowfake.models.Response.DishResponse;
import com.toanitdev.nowfake.models.Response.LoginResponse;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface CartService {


  @FormUrlEncoded
  @POST(Constant.PUT_ITEM_CART)
  Observable<ResponseBody> putItemCart(@Field("idDish") String idDish,
                                       @Field("idCustomer") String idCustomer);
  @FormUrlEncoded
  @POST(Constant.GET_ITEM_CART_BY_CUS)
  Observable<List<DishResponse>> getItemCartByCustomer(@Field("idCustomer") String idCustomer);


  @GET(Constant.COUNT_CART_BY_ID_CUS)
  Observable<ResponseBody> countCart(@Query("idCustomer") String idCustomer);
}
