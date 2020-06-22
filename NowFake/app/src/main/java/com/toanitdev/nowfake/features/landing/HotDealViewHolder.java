package com.toanitdev.nowfake.features.landing;

import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.toanitdev.nowfake.R;
import com.toanitdev.nowfake.features.dish_detail.DishDetailActivity;
import com.toanitdev.nowfake.models.Response.DishResponse;
import static com.toanitdev.nowfake.utils.DecimalUtil.format;
import java.text.DecimalFormat;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HotDealViewHolder extends RecyclerView.ViewHolder {

  @BindView(R.id.tvDishName)
  TextView tvDishName;
  @BindView(R.id.imgDishHotDeal)
  ImageView imgDishHotDeal;
  @BindView(R.id.tvOriginPrice)
  TextView tvOriginPrice;
  @BindView(R.id.tvDiscountPrice)
  TextView tvDiscountPrice;
  @BindView(R.id.cardItem)
  CardView cardItem;




  public void bind(final DishResponse response){
    tvDishName.setText(response.getNameDish());
    if(!response.getLinkImage().isEmpty())
      Picasso.get()
              .load(response.getLinkImage())
              .placeholder(R.drawable.bg_placeholder)
              .error(R.drawable.bg_placeholder)
              .into(imgDishHotDeal);

    if(response.getDiscounPrice()<response.getPriceDish()){
      tvDiscountPrice.setText(format(response.getDiscounPrice())+" VND");
      tvOriginPrice.setText(format(response.getPriceDish())+" VND");
      tvOriginPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }

    //set On Click
    cardItem.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        DishDetailActivity.startMe(v.getContext(),response.getIdDish());
      }
    });
  }

  public HotDealViewHolder(@NonNull View itemView) {
    super(itemView);
    ButterKnife.bind(this,itemView);
  }
}
