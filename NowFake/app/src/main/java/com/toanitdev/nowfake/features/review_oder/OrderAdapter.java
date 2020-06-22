package com.toanitdev.nowfake.features.review_oder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.toanitdev.nowfake.R;
import com.toanitdev.nowfake.models.Response.OrderResponse;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter<OrderViewHolder> {

  List<OrderResponse> data;
  Context context;

  public OrderAdapter(Context context , List<OrderResponse> data) {
    this.data =  data;
    this.context =context;
  }
  public  OrderAdapter (Context context){
    this.context = context;
  }

  @NonNull
  @Override
  public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(context);
    View view = layoutInflater.inflate(R.layout.item_order,parent,false);
    OrderViewHolder viewHolder = new OrderViewHolder(view);
    return viewHolder;
  }

  @Override
  public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
    holder.bind(data.get(position));
  }

  @Override
  public int getItemCount() {
    if(data!=null){
      return data.size();
    }
    return 0;
  }

  public void setData(List<OrderResponse> data) {
    this.data = data;
    notifyDataSetChanged();
  }
}
