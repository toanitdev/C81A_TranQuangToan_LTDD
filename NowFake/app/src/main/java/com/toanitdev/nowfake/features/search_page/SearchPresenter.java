package com.toanitdev.nowfake.features.search_page;

import androidx.appcompat.app.AppCompatActivity;

import com.toanitdev.nowfake.interactor.GetDishSearch;
import com.toanitdev.nowfake.models.Response.DishResponse;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class SearchPresenter<T extends AppCompatActivity> {

  SearchActivity activity;
  GetDishSearch getDishSearch;

  public SearchPresenter(T activity) {
    this.activity = (SearchActivity) activity;
    getDishSearch = new GetDishSearch();
  }

  public void searchDish(String keyword){
    getDishSearch.excute(keyword).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<List<DishResponse>>() {
              @Override
              public void call(List<DishResponse> dishResponse) {
                activity.renderSearch(dishResponse);
              }
            }, new Action1<Throwable>() {
              @Override
              public void call(Throwable throwable) {

              }
            });
  }
}
