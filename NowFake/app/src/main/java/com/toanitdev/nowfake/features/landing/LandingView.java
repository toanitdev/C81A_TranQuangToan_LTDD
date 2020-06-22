package com.toanitdev.nowfake.features.landing;

import com.toanitdev.nowfake.models.Response.DishResponse;

import java.util.List;

public interface LandingView {
    void renderUI();

    void renderHotDeal(List<DishResponse> responses);

    void renderCategories();

    void renderListFood(List<DishResponse> responses);
}
