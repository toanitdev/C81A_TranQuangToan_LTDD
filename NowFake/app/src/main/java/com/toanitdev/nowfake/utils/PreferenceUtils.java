package com.toanitdev.nowfake.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.toanitdev.nowfake.Constant;

public class PreferenceUtils {

  static SharedPreferences preferences;

  public final static String CUS_KEY = "CUSTOMER_DETAIL";
  public final static String CUS_ID_KEY = "CUSTOMER_ID";
  public final static String LOGIN_KEY = "LOGIN";
  public final static String COUNT_CART = "COUNT_CART";

  // just test function
  public static void saveLoginState(Context context,boolean state){
    preferences = context.getSharedPreferences(Constant.LOGIN_STATE_KEY,Context.MODE_PRIVATE);
    preferences.edit().putBoolean(LOGIN_KEY,state).apply();
    preferences.edit().commit();
  }

  public static void saveCustomerDetail(Context context, String username,String idCustomer) {
    preferences = context.getSharedPreferences(Constant.LOGIN_STATE_KEY,Context.MODE_PRIVATE);
    preferences.edit().putString(CUS_KEY,username).apply();
    preferences.edit().putString(CUS_ID_KEY,idCustomer).apply();
    preferences.edit().commit();
  }
  public static void saveCountCart(Context context,String count){
    preferences = context.getSharedPreferences(Constant.LOGIN_STATE_KEY,Context.MODE_PRIVATE);
    preferences.edit().putString(COUNT_CART,count).apply();
    preferences.edit().commit();
  }

  public static void logout(Context context){
    preferences = context.getSharedPreferences(Constant.LOGIN_STATE_KEY,Context.MODE_PRIVATE);
    preferences.edit().clear().apply();
    preferences.edit().commit();
  }



  //get Preference
  public static boolean loadLoginState(Context context){
    preferences = context.getSharedPreferences(Constant.LOGIN_STATE_KEY,Context.MODE_PRIVATE);
    return preferences.getBoolean(LOGIN_KEY,false);
  }
  public static String loadCustomerDetail(Context context){
    preferences = context.getSharedPreferences(Constant.LOGIN_STATE_KEY,Context.MODE_PRIVATE);
    return preferences.getString(CUS_KEY,"");
  }
  public static String loadCustomerID(Context context){
    preferences = context.getSharedPreferences(Constant.LOGIN_STATE_KEY,Context.MODE_PRIVATE);
    return preferences.getString(CUS_ID_KEY,"");
  }
  public static String loadCountCart(Context context){
    preferences = context.getSharedPreferences(Constant.LOGIN_STATE_KEY,Context.MODE_PRIVATE);
    return preferences.getString(COUNT_CART,"0");
  }


}
