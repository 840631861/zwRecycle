package com.example.administrator.recycle;

/**
 * Created by Administrator on 2018\1\25 0025.
 */

public class v_channel
{
    String name;
    int imgId;
    int sort;

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public v_channel(String name, int imgId, int sort) {
        this.name = name;
        this.imgId = imgId;
        this.sort = sort;
    }
}
