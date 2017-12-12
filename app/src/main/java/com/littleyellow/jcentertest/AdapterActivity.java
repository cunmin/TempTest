package com.littleyellow.jcentertest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 小黄 on 2017/12/12.
 */

public class AdapterActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    List<Object> data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        data = new ArrayList<>();
        data.add("1");
        data.add("2");
        data.add("3");
        data.add("4");
        data.add("5");
        data.add("6");
        data.add("7");
        data.add("8");
        data.add("9");
        data.add("10");
        data.add("11");
        data.add("12");
        data.add("13");
        data.add("14");
        data.add("15");
        data.add("16");
        data.add("17");
        data.add("18");
        data.add("19");
        data.add("20");

        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);
        data.add(5);
        data.add(6);
        data.add(7);
        data.add(8);
        data.add(9);
        data.add(10);
        data.add(11);
        data.add(12);
        data.add(13);
        data.add(14);
        data.add(15);
        data.add(16);
        data.add(17);
        data.add(18);
        data.add(19);
        data.add(20);
        RAdapter adapter = RAdapter.newBuilder()
                .register(new ViewInjector<String,VHCreator.ViewHolder>() {
                    @Override
                    public void onInject(VHCreator.ViewHolder viewholder, String data, int position) {
                        if (position % 2 == 0) {
                            viewholder.name.setBackgroundColor(Color.parseColor("#eeeeee"));
                        } else {
                            viewholder.name.setBackgroundColor(Color.parseColor("#ffffff"));
                        }
                        viewholder.name.setText(data);
                    }

                    @Override
                    public AbsVHCreator getVHCreator() {
                        return new VHCreator();
                    }
                })
                .register(new ViewInjector<Integer, VH2Creator.ViewHolder>() {
                    @Override
                    public void onInject(VH2Creator.ViewHolder viewholder, Integer data, int position) {
                        viewholder.imageView.setImageResource(R.mipmap.ic_launcher);
                        viewholder.name.setText(data+"---");
                    }

                    @Override
                    public AbsVHCreator getVHCreator() {
                        return new VH2Creator();
                    }
                })
                .itemType(new ItemType() {
                    @Override
                    public int getType(int position) {
                        if(data.get(position) instanceof String) {
                            return 1;
                        }else{
                            return 2;
                        }
                    }
                })
                .build();
        adapter.setData(data);
        recyclerView.setAdapter(adapter);
    }

}
