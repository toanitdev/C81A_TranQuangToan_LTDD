package com.toanitdev.nowfake.features.cart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.toanitdev.nowfake.R;
import com.toanitdev.nowfake.features.shipping_page.ShippingActivity;
import com.toanitdev.nowfake.models.Response.DishResponse;
import com.toanitdev.nowfake.utils.DecimalUtil;
import com.toanitdev.nowfake.utils.PreferenceUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartActivity extends AppCompatActivity implements CartView {


  @BindView(R.id.rvCartItems)
  RecyclerView rvCartItems;
  @BindView(R.id.tvTotals)
  TextView tvTotals;
  @BindView(R.id.imgBack)
  ImageView imgBack;
  @BindView(R.id.tvOrder)
  TextView tvOrder;
  @BindView(R.id.tvEmptyCart)
  TextView tvEmptyCart;

  CartAdapter cartApdapter;
  CartPresenter presenter;


  public  static  void startMe(Context context){
    Intent intent = new Intent(context,CartActivity.class);
    context.startActivity(intent);
  }
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cart);
    ButterKnife.bind(this);
    //intit
    cartApdapter = new CartAdapter(this);
    rvCartItems.setAdapter(cartApdapter);
    rvCartItems.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    //=== set Onclick
    imgBack.setOnClickListener(v -> {
      finish();
    });
    tvOrder.setOnClickListener(v -> {
      ShippingActivity.startMe(this);
    });

    //===
    presenter = new CartPresenter(this);
    presenter.getCart(PreferenceUtils.loadCustomerID(this));

  }

  @Override
  public void renderListCartItems(List<DishResponse> responses) {

    tvEmptyCart.setVisibility(View.GONE);
    tvOrder.setEnabled(true);
    cartApdapter.setData(responses);
    double sum=0;
    for(DishResponse item : responses){
      sum+= item.getDiscounPrice()*item.getStock();
    }
    tvTotals.setText(DecimalUtil.format(sum)+" VND");
  }

  @Override
  public void renderListCartItemsFailed() {
    tvTotals.setText("0 VND");
    tvEmptyCart.setVisibility(View.VISIBLE);
    tvOrder.setEnabled(false);
  }

}
