package com.toanitdev.nowfake.models.Response;

import com.google.gson.annotations.SerializedName;

public class CustomerResponse {

  @SerializedName("id_customer")
  public String idCustomer;
  @SerializedName("name_customer")
  public String nameCustomer;
  @SerializedName("email")
  public String email;
  @SerializedName("phone_customer")
  public String phoneCustomer;
  @SerializedName("date_of_birth")
  public String dateOfBirth;

  public String getIdCustomer() {
    return idCustomer;
  }

  public void setIdCustomer(String idCustomer) {
    this.idCustomer = idCustomer;
  }

  public String getNameCustomer() {
    return nameCustomer;
  }

  public void setNameCustomer(String nameCustomer) {
    this.nameCustomer = nameCustomer;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneCustomer() {
    return phoneCustomer;
  }

  public void setPhoneCustomer(String phoneCustomer) {
    this.phoneCustomer = phoneCustomer;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
}
