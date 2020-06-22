package com.toanitdev.nowfake.features.review_oder;

import com.toanitdev.nowfake.models.Response.CustomerResponse;
import com.toanitdev.nowfake.models.Response.DishResponse;
import com.toanitdev.nowfake.models.Response.ResultResponse;

import java.util.List;

public interface ReviewView {
  void renderCartItemList(List<DishResponse> responses);
  void renderCustomer(CustomerResponse customerResponse);
  void renderConfirmSuccess(ResultResponse resultResponse);
  void renderConfirmFailed(ResultResponse resultResponse);
  void renderConfirmError(Throwable throwable);
}
