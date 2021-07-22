package com.sainivik.gridviewsample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.sainivik.gridviewsample.R;
import com.sainivik.gridviewsample.databinding.DataItemBinding;
import com.sainivik.gridviewsample.databinding.DataItemHeaderBinding;
import com.sainivik.gridviewsample.model.MyModel;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context ct;
    RecyclerViewClickListener listener;
    ArrayList<MyModel> dataList;
    public int viewType = 0;

    public MyAdapter(ArrayList<MyModel> dataList, Context ct, RecyclerViewClickListener listener) {
        this.ct = ct;
        this.dataList = dataList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == 1) {
            DataItemHeaderBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.data_item_header, parent, false);
            return new MyHeaderViewHolder(binding);
        } else {
            DataItemBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.data_item, parent, false);
            return new MyViewHolder(binding);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        if (holder instanceof MyHeaderViewHolder) {
            MyHeaderViewHolder myHeaderViewHolder = (MyHeaderViewHolder) holder;
            myHeaderViewHolder.binding.tvHeader.setText(dataList.get(position).getHeaderName());

        } else {
            MyViewHolder myViewHolder = (MyViewHolder) holder;
            myViewHolder.binding.ivImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onclick(myViewHolder.binding.ivImage, position);
                }
            });

        }

    }


    @Override
    public int getItemViewType(int position) {
        if (dataList.get(position).getType() == 1) {
            viewType = 1;
        } else {
            viewType = 2;
        }
        return viewType;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        DataItemBinding binding;

        MyViewHolder(DataItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


    }

    public class MyHeaderViewHolder extends RecyclerView.ViewHolder {
        DataItemHeaderBinding binding;

        MyHeaderViewHolder(DataItemHeaderBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }


    }
}
