package com.toanitdev.nowfake.models.Response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("tinhTrang")
    @Expose
    boolean tinhTrang;
    @SerializedName("loiNhan")
    @Expose
    String loiNhan;
    @SerializedName("idCustomer")
    @Expose
    String idCustomer;

    public boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getLoiNhan() {
        return loiNhan;
    }

    public void setLoiNhan(String loiNhan) {
        this.loiNhan = loiNhan;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @SerializedName("userName")
    @Expose
    String userName;


}
