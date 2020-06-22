package com.toanitdev.nowfake.models.Response;

import com.google.gson.annotations.SerializedName;

public class DishResponse {

  @SerializedName("id_dish")
  public String idDish;
  @SerializedName("name_dish")
  public String nameDish;
  @SerializedName("price_dish")
  public Double priceDish;
  @SerializedName("discount_price")
  public Double discounPrice;
  @SerializedName("desciption_dish")
  public String desciptionDish;
  @SerializedName("short_desciption")
  public String shortDescription;
  @SerializedName("hot_deal")
  public int hotDeal;
  @SerializedName("link_image")
  public String linkImage;
  @SerializedName("id_store")
  public int idStore;
  @SerializedName("id_type")
  public int idType;

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

  @SerializedName("stock")
  public int stock;


  public String getIdDish() {
    return idDish;
  }

  public void setIdDish(String idDish) {
    this.idDish = idDish;
  }

  public String getNameDish() {
    return nameDish;
  }

  public void setNameDish(String nameDish) {
    this.nameDish = nameDish;
  }

  public Double getPriceDish() {
    return priceDish;
  }

  public void setPriceDish(Double priceDish) {
    this.priceDish = priceDish;
  }

  public Double getDiscounPrice() {
    return discounPrice;
  }

  public void setDiscounPrice(Double discounPrice) {
    this.discounPrice = discounPrice;
  }

  public String getDesciptionDish() {
    return desciptionDish;
  }

  public void setDesciptionDish(String desciptionDish) {
    this.desciptionDish = desciptionDish;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public int getHotDeal() {
    return hotDeal;
  }

  public void setHotDeal(int hotDeal) {
    this.hotDeal = hotDeal;
  }

  public String getLinkImage() {
    return linkImage;
  }

  public void setLinkImage(String linkImage) {
    this.linkImage = linkImage;
  }

  public int getIdStore() {
    return idStore;
  }

  public void setIdStore(int idStore) {
    this.idStore = idStore;
  }

  public int getIdType() {
    return idType;
  }

  public void setIdType(int idType) {
    this.idType = idType;
  }
}
