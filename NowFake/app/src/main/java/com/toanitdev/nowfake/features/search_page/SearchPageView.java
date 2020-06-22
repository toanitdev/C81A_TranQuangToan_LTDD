package com.toanitdev.nowfake.features.search_page;

import com.toanitdev.nowfake.models.Response.DishResponse;

import java.util.List;

public interface SearchPageView {
  public void renderSearch(List<DishResponse> responses);
}
