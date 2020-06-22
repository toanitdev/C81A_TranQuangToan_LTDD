package com.toanitdev.nowfake.features.dish_detail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.toanitdev.nowfake.R;
import com.toanitdev.nowfake.base.BaseActivity;
import com.toanitdev.nowfake.base.BasePresenter;
import com.toanitdev.nowfake.features.cart.CartActivity;
import com.toanitdev.nowfake.features.landing.LandingPresenter;
import com.toanitdev.nowfake.features.login.LoginActivity;
import com.toanitdev.nowfake.models.Response.DishResponse;
import com.toanitdev.nowfake.utils.CheckUtils;
import com.toanitdev.nowfake.utils.PreferenceUtils;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;

import static com.toanitdev.nowfake.utils.DecimalUtil.format;

public class DishDetailActivity extends BaseActivity implements DishDetailView {

  @BindView(R.id.imageDetail)
  ImageView imageDetail;
  @BindView(R.id.tvDishName)
  TextView tvDishName;
  @BindView(R.id.tvOriginPrice)
  TextView tvOriginalPrice;
  @BindView(R.id.tvDiscountPrice)
  TextView tvDiscountPrice;
  @BindView(R.id.imgBack)
  ImageView imgBack;
  @BindView(R.id.imgCart)
  ImageView imgCart;
  @BindView(R.id.tvBooking)
  TextView tvBooking;
  @BindView(R.id.tvCountCart)
  TextView tvCountCart;



  final static String ID_DISH ="id_dish";
  String idDish;


  public static void startMe(Context context,String idDish){
    Intent intent = new Intent(context,DishDetailActivity.class);
    intent.putExtra(ID_DISH,idDish);
    context.startActivity(intent);
  }

  DishDetailPresenter presenter;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dish_detail);

    //API 28 dont need it
    /*if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
      Window w = getWindow();
      w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }*/
    ButterKnife.bind(this);
    //init Presenter
    initPresenter();
    //initParam
    initParam();

    //get data
    presenter.getDetailDish(idDish );

    tvCountCart.setText(PreferenceUtils.loadCountCart(this));
    //set onClick
    setOnClick();
  }

  @Override
  public void renderCountCart(ResponseBody responseBody) {
    super.renderCountCart(responseBody);
      tvCountCart.setText(PreferenceUtils.loadCountCart(this));
  }

  private void setOnClick() {
    //click to back
    imgBack.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        finish();
      }
    });
    tvBooking.setOnClickListener((v)->{
      if(PreferenceUtils.loadLoginState(this)
          && CheckUtils.isValid(PreferenceUtils.loadCustomerDetail(this))){
        presenter.addItemCart(idDish,PreferenceUtils.loadCustomerID(this));
      }else
        LoginActivity.startMe(this);
    });
    imgCart.setOnClickListener((v -> {
      CartActivity.startMe(this);
    }));

  }


  private void initPresenter() {
    presenter = new DishDetailPresenter(this);
  }

  void initParam(){
    idDish =  getIntent().getStringExtra(ID_DISH);
  }



  @Override
  public void renderDishDetail(DishResponse dishResponse) {
    Picasso.get()
        .load(dishResponse.getLinkImage())
        .placeholder(R.color.white)
        .error(R.drawable.bg_placeholder)
        .into(imageDetail);
    tvDishName.setText(dishResponse.getNameDish());
    tvDishName.setVisibility(View.VISIBLE);
    //price logic
    if(dishResponse.getPriceDish()>dishResponse.getDiscounPrice()){
      tvOriginalPrice.setVisibility(View.VISIBLE);
      tvDiscountPrice.setVisibility(View.VISIBLE);
      tvOriginalPrice.setText(format(dishResponse.getPriceDish())+ " VND");
      tvOriginalPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
      tvDiscountPrice.setText(format(dishResponse.getDiscounPrice()) + " VND");
    }else {
      tvOriginalPrice.setVisibility(View.GONE);
      tvDiscountPrice.setVisibility(View.VISIBLE);
      tvDiscountPrice.setText(format(dishResponse.getPriceDish())+" VND");
    }
  }

  @Override
  public void renderActionAddToCart(ResponseBody responseBody) {
    presenter.getCountCart(PreferenceUtils.loadCustomerID(this));
    try {
      if(responseBody.string().equalsIgnoreCase("true")){
        Toast.makeText(this,"Đã thêm vào giỏ hàng",Toast.LENGTH_SHORT).show();
      }else {
        Toast.makeText(this,"Thất bại",Toast.LENGTH_SHORT).show();
      }
    } catch (IOException e) {
      e.printStackTrace();
      Toast.makeText(this,"ERROR: "+getLocalClassName()+" - "+e.getMessage(),Toast.LENGTH_SHORT).show();
    }
  }
}
