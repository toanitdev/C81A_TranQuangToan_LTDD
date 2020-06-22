package com.toanitdev.nowfake;

public class Constant {


  public static final String BASE_URL = "https://nowfakepage.000webhostapp.com/";
  public static final String API = "api/";


  // CUSTOMER
  public static final String LOGIN = BASE_URL + API + "Customer/login.php";
  public static final String SIGNUP = BASE_URL + API + "Customer/signup.php";
  public static final String GET_CUSTOMER = BASE_URL + API + "Customer/get-customer/";
  //DISH
  public static final String GET_DISH_ALL = BASE_URL + API + "Dish/list-dish-all/";
  public static final String GET_DISH_HOT_DEAL = BASE_URL + API + "Dish/dish-hot-deal/";
  public static final String GET_DISH_SEARCH = BASE_URL + API + "Dish/dish-by-name/";
  public static final String GET_DIST_DETAIL = BASE_URL + API + "Dish/dish-by-id/";
  //CART
  public static final String PUT_ITEM_CART = BASE_URL + API + "Cart/put-to-cart/";
  public static final String GET_ITEM_CART_BY_CUS = BASE_URL + API + "Cart/get-cart-by-customer/";
  public static final String COUNT_CART_BY_ID_CUS = BASE_URL + API + "/Cart/count-item-by-cus/";
  //ORDER
  public static final String PUT_ORDER = BASE_URL + API + "Order/put-order/";
  public static final String GET_LIST_ORDER = BASE_URL + API + "Order/get-order-list/";


  //KEY
  public static final String LOGIN_STATE_KEY = "LOGIN_NOW_FAKE";
}
