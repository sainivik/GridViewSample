package com.sainivik.gridviewsample;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sainivik.gridviewsample.adapters.MyAdapter;
import com.sainivik.gridviewsample.adapters.RecyclerViewClickListener;
import com.sainivik.gridviewsample.databinding.ActivityMainBinding;
import com.sainivik.gridviewsample.model.MyModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MyAdapter adapter;
    private ArrayList<MyModel> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setListData();
        setAdapter();
    }


    private void setListData() {
        dataList.add(new MyModel(1, "Abcd"));
        dataList.add(new MyModel(2, ""));
        dataList.add(new MyModel(2, ""));
        dataList.add(new MyModel(2, ""));

        dataList.add(new MyModel(1, "1234"));
        dataList.add(new MyModel(2, ""));
        dataList.add(new MyModel(2, ""));
        dataList.add(new MyModel(2, ""));
        dataList.add(new MyModel(2, ""));
        dataList.add(new MyModel(2, ""));
        dataList.add(new MyModel(1, "hello"));
        dataList.add(new MyModel(2, ""));
        dataList.add(new MyModel(2, ""));


    }


    private void setAdapter() {


        RecyclerViewClickListener myListener = new RecyclerViewClickListener() {
            @Override
            public void onclick(View view, int pos) {
                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();

            }
        };


        adapter = new MyAdapter(dataList, this, myListener);

        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);

        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                switch (adapter.getItemViewType(position)) {
                    case 1:
                        return 2;
                    default:
                        return 1;

                }
            }
        });
        binding.rvData.setLayoutManager(mLayoutManager);
        binding.rvData.setAdapter(adapter);

    }
}