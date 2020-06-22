package com.toanitdev.nowfake.features.landing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.toanitdev.nowfake.R;
import com.toanitdev.nowfake.models.Response.DishResponse;

import java.util.ArrayList;
import java.util.List;


public class DishAdapter extends RecyclerView.Adapter<DishViewHolder> {

  Context context;
  List<DishResponse> data = new ArrayList<>();

  public DishAdapter(Context context) {
    this.context =context;
  }

  @NonNull
  @Override
  public DishViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(this.context);
    View view = inflater.inflate(R.layout.item_dish, parent, false);
    DishViewHolder viewHolder = new DishViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull DishViewHolder holder, int position) {
    holder.bind(data.get(position));
  }

  @Override
  public int getItemCount() {
    return data.size();
  }

  public void setData(List<DishResponse> data){
    this.data = data;
    notifyDataSetChanged();
  }
}
