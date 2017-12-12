package com.littleyellow.jcentertest;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 小黄 on 2017/12/12.
 */

public class VH2Creator extends AbsVHCreator {


    @Override
    protected int getLayoutId() {
        return R.layout.recyclerview_item2;
    }

    @Override
    protected int getLayoutType() {
        return 2;
    }

    @Override
    protected ViewHolder getViewHolder(View view) {
        ViewHolder viewHolder = new ViewHolder(view, this);
        return viewHolder;
    }


    public static class ViewHolder extends BaseViewHolder{
        @BindView(R.id.image_view)
        ImageView imageView;
        @BindView(R.id.name)
        TextView name;

        ViewHolder(View view,AbsVHCreator creator) {
            super(view,creator);
            ButterKnife.bind(this, view);
        }
    }
}
