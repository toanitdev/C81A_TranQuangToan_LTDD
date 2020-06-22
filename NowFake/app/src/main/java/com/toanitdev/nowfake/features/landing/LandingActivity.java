package com.toanitdev.nowfake.features.landing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.toanitdev.nowfake.R;
import com.toanitdev.nowfake.features.cart.CartActivity;
import com.toanitdev.nowfake.features.login.LoginActivity;
import com.toanitdev.nowfake.features.my_profile.MyProfileActivity;
import com.toanitdev.nowfake.features.order_list.MyOrderActivity;
import com.toanitdev.nowfake.features.review_oder.ReviewActivity;
import com.toanitdev.nowfake.features.search_page.SearchActivity;
import com.toanitdev.nowfake.features.splash.SplashActivity;
import com.toanitdev.nowfake.interactor.Login;
import com.toanitdev.nowfake.models.Response.DishResponse;
import com.toanitdev.nowfake.utils.CheckUtils;
import com.toanitdev.nowfake.utils.PreferenceUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LandingActivity extends AppCompatActivity implements LandingView {


    @BindView(R.id.nav_bottom)
    AHBottomNavigation ahBottomNavigation;

    @BindView(R.id.rvDish)
    RecyclerView rvDish;
    @BindView(R.id.rvHotDeal)
    RecyclerView rvHotDeal;

    @BindView(R.id.tvSearchBar)
    TextView tvSearchBar;

    @BindView(R.id.pcbHotDeal)
    ProgressBar pcbHotDeal;

    @BindView(R.id.pcbLishDish)
    ProgressBar pcbLishDish;

    DishAdapter adapter;
    HotDealAdapter adapterHotDeal;
    LandingPresenter presenter;

    public static void startMe(Context context) {
        Intent intent = new Intent(context,LandingActivity.class);
        context.startActivity(intent);
    }

  public static void startMeTop(Context context) {
    Intent intent = new Intent(context,LandingActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    context.startActivity(intent);
  }
  public static void startMeTop(Context context,String content) {
    Intent intent = new Intent(context,LandingActivity.class);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    if(context instanceof  ReviewActivity){
      Bundle bundle =  new Bundle();
      bundle.putString("ACT","REVIEW");
      bundle.putString("CONTENT",content);
      intent.getBundleExtra("NAV");
    }
    context.startActivity(intent);
  }

  @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        ButterKnife.bind(this);
       // controllNavigation(getIntent().getBundleExtra("NAV"));
        initPresenter();
        setBottomNavigation();
        setRecyclerViewListDish();
        setRecyclerViewHotDeal();
        //Data
        setDataListFood();
        setDataHotDeal();

        //setClick
        clickSearchBar();

    }

  private void controllNavigation(Bundle bundle) {
      if (bundle!=null){
        String action = bundle.getString("ACT");
        String content = bundle.getString("CONTENT");
        if(action!=null && content!=null){
          if(action.equalsIgnoreCase("REVIEW")){
            Toast.makeText(this,""+content,Toast.LENGTH_SHORT).show();
          }
        }
      }
  }


  private void clickSearchBar() {
        tvSearchBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchActivity.startMe(LandingActivity.this);
            }
        });
    }

    private void initPresenter() {
        presenter = new LandingPresenter(this);
    }

    private void setDataListFood() {
        presenter.getListFoodAll();
    }
    private void setDataHotDeal() {
        presenter.getListHotDeal();
    }

    void setRecyclerViewListDish(){
        adapter = new DishAdapter(LandingActivity.this);
        rvDish.setLayoutManager(new LinearLayoutManager(this));
        rvDish.setAdapter(adapter);

    }

    void setRecyclerViewHotDeal(){
        adapterHotDeal = new HotDealAdapter(LandingActivity.this);
        rvHotDeal.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false));
        rvHotDeal.setAdapter(adapterHotDeal);
    }

    void setBottomNavigation(){
        ahBottomNavigation.setTitleTextSizeInSp(9, 9);
        ahBottomNavigation.setAccentColor(ContextCompat.getColor(this, R.color.colorAccent));
        ahBottomNavigation.setDefaultBackgroundColor(Color.parseColor("#FFFFFF"));
        ahBottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        ahBottomNavigation.setInactiveColor(Color.parseColor("#C0B8B6"));


        AHBottomNavigationItem item1 =
                new AHBottomNavigationItem("HOME", R.drawable.ic_home,
                        R.color.colorAccent);
        AHBottomNavigationItem item2 =
                new AHBottomNavigationItem("Đơn Hàng", R.drawable.ic_order,
                        R.color.colorAccent);
        AHBottomNavigationItem item3 =
                new AHBottomNavigationItem("Giỏ Hàng", R.drawable.ic_shopping_cart_red_no_a,
                        R.color.colorAccent);
        AHBottomNavigationItem item4 =
                new AHBottomNavigationItem("Tài Khoản", R.drawable.ic_customer,
                        R.color.colorAccent);


        ahBottomNavigation.addItem(item1);
        ahBottomNavigation.addItem(item2);
        ahBottomNavigation.addItem(item3);
        ahBottomNavigation.addItem(item4);

        ahBottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                if(position == 2){
                    CartActivity.startMe(LandingActivity.this);
                }else if(position == 1){
                  if(CheckUtils.isLogin(LandingActivity.this)){
                    MyOrderActivity.startMe(LandingActivity.this);
                  }else {
                    LoginActivity.startMe(LandingActivity.this);
                  }
                }else if(position ==3){
                  MyProfileActivity.startMe(LandingActivity.this);
                }
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        ahBottomNavigation.setCurrentItem(0);
    }

    @Override
    public void renderUI() {

    }

    @Override
    public void renderHotDeal(List<DishResponse> responses) {
        adapterHotDeal.setData(responses);
        pcbHotDeal.setEnabled(false);
        pcbHotDeal.setVisibility(View.GONE);
    }

    @Override
    public void renderCategories() {

    }

    @Override
    public void renderListFood(List<DishResponse> responses) {
        adapter.setData(responses);

        pcbLishDish.setEnabled(false);
        pcbLishDish.setVisibility(View.GONE);
        adapter.notifyDataSetChanged();
    }
}
