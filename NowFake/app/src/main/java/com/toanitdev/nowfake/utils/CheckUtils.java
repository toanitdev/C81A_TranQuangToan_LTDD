package com.toanitdev.nowfake.utils;

import android.content.Context;

public class CheckUtils {

  public static boolean isValid(String string){
    if(string!=null && !string.equalsIgnoreCase(""))
      return true;
    return false;
  }
  public static boolean isLogin(Context context){
    if(PreferenceUtils.loadLoginState(context)
        && CheckUtils.isValid(PreferenceUtils.loadCustomerDetail(context))){
      return true;
    }
    else
      return false;
  }
}
