package com.toanitdev.nowfake.services;

import com.toanitdev.nowfake.Constant;
import com.toanitdev.nowfake.models.Response.CustomerResponse;
import com.toanitdev.nowfake.models.Response.LoginResponse;
import com.toanitdev.nowfake.models.Response.ResultResponse;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

public interface CustomerService {

    @FormUrlEncoded
    @POST(Constant.LOGIN)
    Observable<LoginResponse> login(@Field("tk") String acount,
                                    @Field("mk") String password);
    @FormUrlEncoded
    @POST(Constant.GET_CUSTOMER)
    Observable<CustomerResponse> getCustomer(@Field("idCustomer") String idCustomer);


    @GET(Constant.SIGNUP)
    Observable<ResultResponse> signup(@Query("tk") String tk,
                                      @Query("mk") String mk,
                                      @Query("name") String name,
                                      @Query("phoneCustomer") String phoneCustomer,
                                      @Query("email") String email,
                                      @Query("dateofbirth") String dateofbirth);

/*
    @FormUrlEncoded
    @POST(Constant.GET_CUSTOMER)
    Observable<CustomerResponse> getCustomer(@Field("idCustomer") String idCustomer);*/

   /* @Headers("Content-Type: application/json")
    @GET(Constant.SEARCH_PRODUCT)
    Observable<SearchProductResponse> searchProduct(@Header("Authorization") String auth,
                                                    @Query("searchCriteria[filterGroups][0][filters][0][value]") String keywordName,
                                                    @Query("searchCriteria[filterGroups][0][filters][1][value]") String keywordDescription,
                                                    @Query("searchCriteria[sortOrders][0][field]") String field,
                                                    @Query("searchCriteria[sortOrders][0][direction]") String direction,
                                                    @Query("searchCriteria[filterGroups][1][filters][0][value]") String category_id);

*/
/*
    @Headers("Content-Type: application/json")
    @POST(URL.SIGN_IN)
    Observable<ResponseBody> signIn(
            @Body SignInRequest signInRequest);*/
}
