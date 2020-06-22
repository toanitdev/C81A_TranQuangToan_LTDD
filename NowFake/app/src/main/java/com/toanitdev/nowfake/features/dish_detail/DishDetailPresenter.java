package com.toanitdev.nowfake.features.dish_detail;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import com.toanitdev.nowfake.base.BasePresenter;
import com.toanitdev.nowfake.interactor.AddItemCart;
import com.toanitdev.nowfake.interactor.GetDishDetail;
import com.toanitdev.nowfake.models.Response.DishResponse;

import java.util.List;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class DishDetailPresenter<T extends AppCompatActivity> extends BasePresenter {

  DishDetailActivity activity;
  private GetDishDetail getDishDetail;
  private AddItemCart addItemCart;
  public DishDetailPresenter(T activity) {
    super(activity);
    this.activity = (DishDetailActivity) activity;
    this.getDishDetail = new GetDishDetail();
    this.addItemCart = new AddItemCart();
  }

  public void getDetailDish(String idDish){
    getDishDetail.excute(idDish).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
        .subscribe(
        new Action1<DishResponse>() {
          @Override
          public void call(DishResponse dishResponse) {
            activity.renderDishDetail(dishResponse);
          }
        }, new Action1<Throwable>() {
          @Override
          public void call(Throwable throwable) {

          }
        }
    );
  }

  public void addItemCart(String idDish,String idCustomer){
    addItemCart.excute(idDish,idCustomer).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe((responseBody -> {
      activity.renderActionAddToCart(responseBody);
    }));
  }

  @Override
  public void getCountCart(String idCustomer) {
    super.getCountCart(idCustomer);
  }
}
