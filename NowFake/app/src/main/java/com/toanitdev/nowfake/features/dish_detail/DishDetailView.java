package com.toanitdev.nowfake.features.dish_detail;

import com.toanitdev.nowfake.base.BaseView;
import com.toanitdev.nowfake.models.Response.DishResponse;

import okhttp3.ResponseBody;

public interface DishDetailView extends BaseView {

  void renderDishDetail(DishResponse dishResponse);

  void renderActionAddToCart(ResponseBody responseBody);
}
