package com.toanitdev.nowfake.features.order_list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.toanitdev.nowfake.R;
import com.toanitdev.nowfake.base.BaseActivity;
import com.toanitdev.nowfake.features.cart.CartActivity;
import com.toanitdev.nowfake.features.review_oder.OrderAdapter;
import com.toanitdev.nowfake.models.Response.OrderResponse;
import com.toanitdev.nowfake.utils.PreferenceUtils;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;

public class MyOrderActivity extends BaseActivity implements MyOrderView {


  @BindView(R.id.imgBack)
  ImageView imgBack;
  @BindView(R.id.imgCart)
  ImageView imgCart;
  @BindView(R.id.tvCountCart)
  TextView tvCountCart;
  @BindView(R.id.rvOrder)
  RecyclerView rvOrder;

  OrderAdapter orderAdapter ;
  MyOrderPresenter presenter;



  public static void startMe(Context context){
    Intent intent  = new Intent(context,MyOrderActivity.class);
    context.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my_order);
    ButterKnife.bind(this);


    //set onclick
    setOnClick();
    setupRecyclerView();
    presenter = new MyOrderPresenter(this);
    presenter.getCountCart(PreferenceUtils.loadCustomerID(this));
    presenter.getOrder(PreferenceUtils.loadCustomerID(this));
  }

  private void setupRecyclerView() {
    orderAdapter = new OrderAdapter(this);
    rvOrder.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
    rvOrder.setAdapter(orderAdapter);
  }

  private void setOnClick() {
    imgBack.setOnClickListener(v -> finish());
    imgCart.setOnClickListener(v -> CartActivity.startMe(this));
  }

  @Override
  public void renderCountCart(ResponseBody responseBody) {
    super.renderCountCart(responseBody);
    tvCountCart.setText(PreferenceUtils.loadCountCart(this));
  }

  @Override
  public void renderListOrder(List<OrderResponse> response) {
    orderAdapter.setData(response);
  }
}
