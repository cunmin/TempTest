package com.littleyellow.jcentertest;

/**
 * Created by 小黄 on 2017/12/6.
 */

public class Address implements Cloneable{

    String street = "sssss";

    @Override
    protected Address clone(){
        try {
            Address address = (Address) super.clone();
            return address;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
