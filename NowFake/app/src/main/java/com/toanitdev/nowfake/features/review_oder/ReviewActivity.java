package com.toanitdev.nowfake.features.review_oder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.toanitdev.nowfake.R;
import com.toanitdev.nowfake.features.cart.CartAdapter;
import com.toanitdev.nowfake.features.landing.DishAdapter;
import com.toanitdev.nowfake.features.landing.LandingActivity;
import com.toanitdev.nowfake.features.order_list.MyOrderActivity;
import com.toanitdev.nowfake.models.Response.CustomerResponse;
import com.toanitdev.nowfake.models.Response.DishResponse;
import com.toanitdev.nowfake.models.Response.ResultResponse;
import com.toanitdev.nowfake.utils.DecimalUtil;
import com.toanitdev.nowfake.utils.PreferenceUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReviewActivity extends AppCompatActivity implements ReviewView{

  @BindView(R.id.rvCartItems)
  RecyclerView rvCartItems;
  @BindView(R.id.tvCusName)
  TextView tvCusName;
  @BindView(R.id.tvAddress)
  TextView tvAddress;
  @BindView(R.id.tvPhone)
  TextView tvPhone;
  @BindView(R.id.tvTotals)
  TextView tvTotals;
  @BindView(R.id.tvConfirm)
  TextView tvConfirm;

  CartAdapter adapter;
  ReviewPresenter presenter;
  ProgressDialog progressDialog;

  String address;
  String phone;
  String name;
  double totals;
  public static void startMe(Context context,Bundle bundle){
    Intent intent = new Intent(context, ReviewActivity.class);
    intent.putExtra("SHIPPING",bundle);
    context.startActivity(intent);
  }

  @Override
  protected void onStart() {
    super.onStart();

    progressDialog = new ProgressDialog(this);
    progressDialog.setTitle("Đang xử lý ...");
    progressDialog.setMessage("Vui lòng đợi ...");
    progressDialog.show();
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_review);
    ButterKnife.bind(this);
    adapter = new CartAdapter(this);
    rvCartItems.setAdapter(adapter);
    rvCartItems.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

    Bundle bundle = getIntent().getBundleExtra("SHIPPING");
    address = bundle.getString("address","Lỗi");
    phone = bundle.getString("phone","Lỗi");

    //setup content
    tvAddress.setText(address);
    tvPhone.setText(phone);

    //setup data
    presenter = new ReviewPresenter(this);
    String id =PreferenceUtils.loadCustomerID(this);
    presenter.getCartItem(id);
    presenter.getCustomer(id);

    //setup event
    setOnClick();

  }

  private void setOnClick() {
    tvConfirm.setOnClickListener(v -> {
      progressDialog.setTitle("Đang xử lý ...");
      progressDialog.setMessage("Vui lòng đợi ...");
      progressDialog.show();
      presenter.putOrder(PreferenceUtils.loadCustomerID(ReviewActivity.this),phone,address,totals);
    });
  }

  @Override
  public void renderCartItemList(List<DishResponse> responses) {
    adapter.setData(responses);
    totals=0;
    for(DishResponse item  : responses){
      totals +=item.getDiscounPrice()*item.stock;
    }
    tvTotals.setText(DecimalUtil.format(totals)+" VND");
  }

  @Override
  public void renderCustomer(CustomerResponse customerResponse) {
    progressDialog.dismiss();
    name = customerResponse.getNameCustomer();
    tvCusName.setText(customerResponse.getNameCustomer());
  }

  @Override
  public void renderConfirmSuccess(ResultResponse resultResponse) {
    //go to order list
    progressDialog.dismiss();
    Toast.makeText(this,resultResponse.getMessage(),Toast.LENGTH_SHORT).show();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    LandingActivity.startMeTop(this,resultResponse.getMessage());

  }

  @Override
  public void renderConfirmFailed(ResultResponse resultResponse) {
    progressDialog.dismiss();
    Toast.makeText(this,resultResponse.getMessage(),Toast.LENGTH_SHORT);
  }

  @Override
  public void renderConfirmError(Throwable throwable) {
    progressDialog.dismiss();
    Toast.makeText(this,""+throwable.getMessage(),Toast.LENGTH_SHORT);
  }
}
