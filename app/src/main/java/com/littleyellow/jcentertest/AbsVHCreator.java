package com.littleyellow.jcentertest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 小黄 on 2017/12/12.
 */

public abstract class AbsVHCreator {

    protected abstract int getLayoutId();

    protected int getLayoutType(){
        return 0;
    }

    protected abstract <T extends RecyclerView.ViewHolder> T getViewHolder(View view);

    public <T extends RecyclerView.ViewHolder> T getViewHolder(ViewGroup viewGroup){
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(getLayoutId(), viewGroup, false);
        return getViewHolder(view);
    }
}
