package com.toanitdev.nowfake.features.my_profile;

import com.toanitdev.nowfake.base.BaseView;
import com.toanitdev.nowfake.models.Response.CustomerResponse;

import okhttp3.ResponseBody;

public interface MyProfileView extends BaseView {

  void renderProfileSuccess(CustomerResponse response);
  void renderProfileFailed();
  void renderProfileError(Throwable throwable);
}
