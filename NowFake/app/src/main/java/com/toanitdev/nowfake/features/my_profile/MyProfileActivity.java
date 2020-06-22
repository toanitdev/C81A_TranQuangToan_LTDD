package com.toanitdev.nowfake.features.my_profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.toanitdev.nowfake.R;
import com.toanitdev.nowfake.base.BaseActivity;
import com.toanitdev.nowfake.features.landing.LandingActivity;
import com.toanitdev.nowfake.features.order_list.MyOrderView;
import com.toanitdev.nowfake.models.Response.CustomerResponse;
import com.toanitdev.nowfake.models.Response.OrderResponse;
import com.toanitdev.nowfake.utils.PreferenceUtils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;

public class MyProfileActivity extends BaseActivity implements MyProfileView {

  @BindView(R.id.tvCountCart)
  TextView tvCouuntCart;
  @BindView(R.id.tvLogout)
  TextView tvLogout;

  @BindView(R.id.tvName)
  TextView tvName;
  @BindView(R.id.tvPhone)
  TextView tvPhone;
  @BindView(R.id.tvEmail)
  TextView tvEmail;
  @BindView(R.id.tvDob)
  TextView tvDob;


  MyProfilePresenter presenter;



  public static void startMe(Context  context){
    Intent intent = new Intent(context,MyProfileActivity.class);
    context.startActivity(intent);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my_profile);
    ButterKnife.bind(this);

    //setOnClick
    setOnClick();

    presenter = new MyProfilePresenter(this);
    presenter.getCountCart(PreferenceUtils.loadCustomerID(this));
    presenter.getCustomer(PreferenceUtils.loadCustomerID(this));
  }

  private void setOnClick() {
    tvLogout.setOnClickListener(v -> {
      PreferenceUtils.logout(this);
      LandingActivity.startMeTop(this);
    });
  }


  @Override
  public void renderCountCart(ResponseBody responseBody) {
    super.renderCountCart(responseBody);
    tvCouuntCart.setText(PreferenceUtils.loadCountCart(this));
  }


  @Override
  public void renderProfileSuccess(CustomerResponse response) {
    tvName.setText(response.getNameCustomer());
    tvPhone.setText(response.getPhoneCustomer());
    tvEmail.setText(response.getEmail());

    String target = response.getDateOfBirth();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    DateFormat df2 = new SimpleDateFormat("dd-MM-yyyy");
    try {
      Date result =  df.parse(target);
      tvDob.setText(df2.format(result.getTime()));
    } catch (ParseException e) {
      e.printStackTrace();
      tvDob.setText("");
    }
  }

  @Override
  public void renderProfileFailed() {

  }

  @Override
  public void renderProfileError(Throwable throwable) {
    Toast(throwable.getMessage());
  }
}
