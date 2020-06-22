package com.toanitdev.nowfake.features.signup;

import com.toanitdev.nowfake.models.Response.ResultResponse;

public interface SignUpView {

  void renderResultSuccess(ResultResponse resultResponse);
  void renderResultFailed(ResultResponse resultResponse);
  void renderResultError(Throwable throwable);
}
