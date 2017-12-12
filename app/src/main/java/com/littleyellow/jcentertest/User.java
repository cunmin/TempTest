package com.littleyellow.jcentertest;

/**
 * Created by 小黄 on 2017/12/6.
 */

public class User implements Cloneable{

    String name;
    Address address = new Address();

    @Override
    protected User clone(){
        try {
            User user = (User) super.clone();
            user.address = address.clone();
            return user;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
