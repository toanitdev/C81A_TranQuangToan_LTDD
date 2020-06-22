package com.toanitdev.nowfake.base;

import okhttp3.ResponseBody;

public interface BaseView {

  void renderCountCart(ResponseBody responseBody);
  void renderCountCartFailed(String str);
}
