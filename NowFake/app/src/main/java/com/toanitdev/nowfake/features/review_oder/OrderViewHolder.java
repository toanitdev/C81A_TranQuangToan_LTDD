package com.toanitdev.nowfake.features.review_oder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.toanitdev.nowfake.R;
import com.toanitdev.nowfake.models.Response.OrderResponse;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrderViewHolder extends RecyclerView.ViewHolder {

  @BindView(R.id.tvAddress)
  TextView tvAddress;
  @BindView(R.id.tvTotal)
  TextView tvTotal;
  @BindView(R.id.tvDate)
  TextView tvDate;


  public void bind(OrderResponse item){
    tvAddress.setText(item.getShippingAddress());
    tvTotal.setText(item.getTotal());
    tvDate.setText(item.getOrderTime());
  }

  public OrderViewHolder(@NonNull View itemView) {
    super(itemView);
    ButterKnife.bind(this,itemView);
  }
}
