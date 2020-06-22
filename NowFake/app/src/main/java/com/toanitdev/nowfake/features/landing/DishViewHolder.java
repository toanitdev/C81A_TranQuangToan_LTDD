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
import butterknife.BindView;
import butterknife.ButterKnife;
import static com.toanitdev.nowfake.utils.DecimalUtil.format;
public class DishViewHolder extends RecyclerView.ViewHolder {

  @BindView(R.id.tvDishName)
  TextView tvDishName;
  @BindView(R.id.imgDish)
  ImageView imgDish;
  @BindView(R.id.tvOriginalPrice)
  TextView tvOriginPrice;
  @BindView(R.id.tvDicountPrice)
  TextView tvDiscountPrice;
  @BindView(R.id.tvLabelSale)
  TextView tvLabelSale;
  @BindView(R.id.cardItem)
  CardView cardView;


  public void bind(final DishResponse response){
    tvDishName.setText(response.getNameDish());
    if(!response.getLinkImage().isEmpty())
    Picasso.get()
            .load(response.getLinkImage())
            .placeholder(R.drawable.bg_placeholder)
            .error(R.drawable.bg_placeholder)
            .into(imgDish);


    if(response.getDiscounPrice()<response.getPriceDish()){
      tvOriginPrice.setVisibility(View.VISIBLE);
      tvDiscountPrice.setVisibility(View.VISIBLE);
      tvLabelSale.setVisibility(View.VISIBLE);

      tvDiscountPrice.setText(format(response.getDiscounPrice())+" VND");
      tvOriginPrice.setText(format(response.getPriceDish())+" VND");
      tvOriginPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }else {
      tvOriginPrice.setVisibility(View.GONE);
      tvLabelSale.setVisibility(View.GONE);
      tvDiscountPrice.setText(format(response.getPriceDish())+" VND");
    }
    //set OnClick
    cardView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        DishDetailActivity.startMe(v.getContext(),response.getIdDish());
      }
    });

  }

  public DishViewHolder(@NonNull View itemView) {
    super(itemView);
    ButterKnife.bind(this,itemView);
  }
}
