package com.toanitdev.nowfake.features.search_page;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.toanitdev.nowfake.R;
import com.toanitdev.nowfake.features.landing.DishAdapter;
import com.toanitdev.nowfake.features.landing.LandingActivity;
import com.toanitdev.nowfake.models.Response.DishResponse;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchActivity  extends AppCompatActivity implements SearchPageView {


  @BindView(R.id.tvBackspace)
  TextView tvBackspace;
  @BindView(R.id.edtSearchBar)
  EditText edtSearchBar;
  @BindView(R.id.rvListSearch)
  RecyclerView rvListSearch;
  @BindView(R.id.pcbSearch)
  ProgressBar pcbSearch;


  DishAdapter adapter;

  public static void startMe(Context context){
    Intent intent = new Intent(context,SearchActivity.class);
    context.startActivity(intent);
  };


  SearchPresenter presenter;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search);
    ButterKnife.bind(this);
    initPresenter();
    initFirstTime();
    //set click event
    setClickEvent();
  }

  private void initFirstTime() {
    edtSearchBar.requestFocus();
    getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

//    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//    imm.showSoftInput(edtSearchBar, InputMethodManager.SHOW_IMPLICIT);
  }

  private void setClickEvent() {
    tvBackspace.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        onBackPressed();
      }
    });
    edtSearchBar.setOnEditorActionListener(new TextView.OnEditorActionListener() {
      @Override
      public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (actionId == EditorInfo.IME_ACTION_SEARCH) {
          pcbSearch.setVisibility(View.VISIBLE);
          presenter.searchDish(edtSearchBar.getText().toString());
          return true;
        }
        return false;



      }
    });

  }

  private void initPresenter() {
    presenter = new SearchPresenter(this);
  }

  @Override
  public void renderSearch(List<DishResponse> responses) {
    adapter = new DishAdapter(SearchActivity.this);
    rvListSearch.setLayoutManager(new LinearLayoutManager(this));
    rvListSearch.setAdapter(adapter);
    pcbSearch.setEnabled(false);
    pcbSearch.setVisibility(View.GONE);
    adapter.setData(responses);
    adapter.notifyDataSetChanged();
  }
}
