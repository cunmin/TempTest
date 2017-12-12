package com.littleyellow.jcentertest;

import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 小黄 on 2017/12/12.
 */

public class RAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public List datas = null;

    private SparseArray<AbsVHCreator> creators;
    private SparseArray<ViewInjector> injectors;
    private ItemType itemType;


    private RAdapter(Builder builder) {
        creators = builder.creators;
        injectors = builder.injectors;
        itemType = builder.itemType;
    }

    <T> void setData(List<T> datas){
        this.datas = datas;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    //创建新View，被LayoutManager所调用
    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        AbsVHCreator creator = creators.get(viewType);
        if (null == creator) {
            throw new IllegalArgumentException(String.format("Neither the TYPE: %d not The DEFAULT injector found...", viewType));
        }
        return creator.getViewHolder(viewGroup);
    }

    @Override
    public int getItemViewType(int position) {
        return itemType.getType(position);
    }

    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(BaseViewHolder viewHolder, int position) {
        int type = viewHolder.getCreator().getLayoutType();
        ViewInjector injector = injectors.get(type);
        injector.onInject(viewHolder,datas.get(position),position);
    }

    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }


    public static final class Builder {
        private SparseArray<AbsVHCreator> creators = new SparseArray<>();
        private SparseArray<ViewInjector> injectors = new SparseArray<>();
        private ItemType itemType;

        public Builder() {
        }

        public Builder itemType(ItemType itemType) {
            this.itemType = itemType;
            return this;
        }

        public <T,VH> Builder register(ViewInjector<T,VH> injector){
            AbsVHCreator creator = injector.getVHCreator();
            creators.put(creator.getLayoutType(),creator);
            injectors.put(creator.getLayoutType(),injector);
            return this;
        }

        public RAdapter build() {
            return new RAdapter(this);
        }
    }
}
