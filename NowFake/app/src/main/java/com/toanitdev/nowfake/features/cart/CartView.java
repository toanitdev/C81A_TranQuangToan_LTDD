package com.toanitdev.nowfake.features.cart;

import com.toanitdev.nowfake.models.Response.DishResponse;

import java.util.List;

public interface CartView {

  void renderListCartItems(List<DishResponse> responses);
  void renderListCartItemsFailed();
}
