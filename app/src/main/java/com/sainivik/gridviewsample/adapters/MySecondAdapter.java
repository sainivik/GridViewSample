package com.sainivik.gridviewsample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.sainivik.gridviewsample.R;
import com.sainivik.gridviewsample.databinding.DataItemHorizontalBinding;
import com.sainivik.gridviewsample.model.MyData;

import java.util.ArrayList;

public class MySecondAdapter extends RecyclerView.Adapter<MySecondAdapter.MyViewHolder> {
    Context ct;
    RecyclerViewClickListener listener;
    ArrayList<MyData> dataList;

    public MySecondAdapter(ArrayList<MyData> dataList, Context ct, RecyclerViewClickListener listener) {
        this.ct = ct;
        this.dataList = dataList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MySecondAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        DataItemHorizontalBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.data_item_horizontal, parent, false);
        return new MyViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull MySecondAdapter.MyViewHolder holder, final int position) {
        holder.binding.tvHeader.setText(dataList.get(position).getName());
        if (dataList.get(position).isSelected()) {
            holder.binding.tvHeader.setTextColor(ct.getResources().getColor(R.color.teal_200));

        } else {
            holder.binding.tvHeader.setTextColor(ct.getResources().getColor(R.color.black));
        }
        holder.binding.llMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onclick(holder.binding.llMain, position);
            }
        });

    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        DataItemHorizontalBinding binding;

        MyViewHolder(DataItemHorizontalBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


    }

}
