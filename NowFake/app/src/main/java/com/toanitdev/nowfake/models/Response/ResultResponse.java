package com.toanitdev.nowfake.models.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultResponse {
  @SerializedName("state")
  @Expose
  boolean state;
  @SerializedName("messenge")
  @Expose
  String messenge;
  @SerializedName("id_order")
  @Expose
  String idOrder;

  public boolean isState() {
    return state;
  }

  public void setState(boolean state) {
    this.state = state;
  }

  public String getMessage() {
    return messenge;
  }

  public void setMessage(String messenge) {
    this.messenge = messenge;
  }

  public String getIdOrder() {
    return idOrder;
  }

  public void setIdOrder(String idOrder) {
    this.idOrder = idOrder;
  }
}
