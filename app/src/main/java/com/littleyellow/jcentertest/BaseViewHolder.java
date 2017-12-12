package com.littleyellow.jcentertest;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by 小黄 on 2017/12/12.
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder{

    AbsVHCreator creator;

    public BaseViewHolder(View itemView ,AbsVHCreator creator) {
        super(itemView);
        this.creator = creator;
    }

    public AbsVHCreator getCreator() {
        return creator;
    }
}
