package com.toanitdev.nowfake.features.cart;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.toanitdev.nowfake.R;
import com.toanitdev.nowfake.models.Response.DishResponse;
import com.toanitdev.nowfake.utils.CheckUtils;
import com.toanitdev.nowfake.utils.DecimalUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartViewHolder extends RecyclerView.ViewHolder {



  @BindView(R.id.imageView)
  ImageView imageView;
  @BindView(R.id.tvName)
  TextView tvName;
  @BindView(R.id.tvPrice)
  TextView tvPrice;
  @BindView(R.id.tvNumber)
  TextView tvNumber;



  public CartViewHolder(@NonNull View itemView) {
    super(itemView);
    ButterKnife.bind(this,itemView);
  }


  public void bind(DishResponse item){
    Picasso.get().load(item.getLinkImage())
        .placeholder(R.drawable.bg_placeholder)
        .error(R.drawable.bg_placeholder)
        .into(imageView);
    tvName.setText(item.getNameDish());
    if(CheckUtils.isValid(item.getDiscounPrice().toString())){
      tvPrice.setText(DecimalUtil.format(item.getDiscounPrice())+" VND");
    }else
      tvPrice.setText(DecimalUtil.format(item.getPriceDish())+" VND");

    tvNumber.setText("x "+item.getStock());
  }
}
