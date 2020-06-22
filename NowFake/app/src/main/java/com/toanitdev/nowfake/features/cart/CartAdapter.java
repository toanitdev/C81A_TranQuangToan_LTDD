package com.toanitdev.nowfake.features.cart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.toanitdev.nowfake.R;
import com.toanitdev.nowfake.models.Response.DishResponse;

import java.util.List;
import java.util.zip.Inflater;

public class CartAdapter extends RecyclerView.Adapter<CartViewHolder> {

  Context context;
  List<DishResponse> data;

  public CartAdapter(Context context,List<DishResponse> data) {
    this.data = data;
    this.context = context;
  }

  public CartAdapter(Context context) {
    this.context = context;
  }

  public void setData(List<DishResponse> data){
    this.data = data;
    notifyDataSetChanged();
  }

  @NonNull
  @Override
  public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(context);
    View view = layoutInflater.inflate(R.layout.item_cart,parent,false);
    CartViewHolder cartViewHolder = new CartViewHolder(view);

    return cartViewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
    holder.bind(this.data.get(position));
  }

  @Override
  public int getItemCount() {
    if(data!=null)
    return this.data.size();
    return 0;
  }
}
