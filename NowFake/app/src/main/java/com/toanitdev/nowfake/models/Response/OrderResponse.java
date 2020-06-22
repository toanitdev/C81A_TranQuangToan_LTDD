package com.toanitdev.nowfake.models.Response;

import com.google.gson.annotations.SerializedName;

public class OrderResponse {

  @SerializedName("id_order")
  public String idOrder;
  @SerializedName("total")
  public String total;
  @SerializedName("shipping_address")
  public String shippingAddress;
  @SerializedName("number_phone")
  public String numberPhone;
  @SerializedName("order_time")
  public String orderTime;
  @SerializedName("id_customer")
  public String idCustomer;

  public String getIdOrder() {
    return idOrder;
  }

  public void setIdOrder(String idOrder) {
    this.idOrder = idOrder;
  }

  public String getTotal() {
    return total;
  }

  public void setTotal(String total) {
    this.total = total;
  }

  public String getShippingAddress() {
    return shippingAddress;
  }

  public void setShippingAddress(String shippingAddress) {
    this.shippingAddress = shippingAddress;
  }

  public String getNumberPhone() {
    return numberPhone;
  }

  public void setNumberPhone(String numberPhone) {
    this.numberPhone = numberPhone;
  }

  public String getOrderTime() {
    return orderTime;
  }

  public void setOrderTime(String orderTime) {
    this.orderTime = orderTime;
  }

  public String getIdCustomer() {
    return idCustomer;
  }

  public void setIdCustomer(String idCustomer) {
    this.idCustomer = idCustomer;
  }
}
