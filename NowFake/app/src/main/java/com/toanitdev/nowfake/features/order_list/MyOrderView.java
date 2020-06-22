package com.toanitdev.nowfake.features.order_list;

import com.toanitdev.nowfake.base.BaseView;
import com.toanitdev.nowfake.models.Response.OrderResponse;

import java.util.List;

public interface MyOrderView extends BaseView {


  void renderListOrder(List<OrderResponse> response);
}
