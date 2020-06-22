package com.toanitdev.nowfake.utils;

import java.text.DecimalFormat;

public class DecimalUtil {
  static DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
  public static String format(String stringPrice){
    return decimalFormat.format(stringPrice);
  }
  public static String format(double stringPrice){
    return decimalFormat.format(stringPrice);
  }
  public static String format(float stringPrice){
    return decimalFormat.format(stringPrice);
  }
  public static String format(int stringPrice){
    return decimalFormat.format(stringPrice);
  }
}
