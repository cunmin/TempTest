package com.littleyellow.jcentertest;

/**
 * Created by 小黄 on 2017/12/12.
 */

public interface ViewInjector<T,VH> {

    void onInject(VH viewholder,T data, int position);

    AbsVHCreator getVHCreator();
}
