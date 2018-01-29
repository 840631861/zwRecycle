package com.example.com.example.Listener;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2016/7/19 0019.
 */

    //点击事件的监听的接口
    public interface OnItemOnclikListener {
        public void OnItemLongClik(RecyclerView.ViewHolder holder, View view, int postion);
        public void OnItemClik(View view, int postion);
        void OnItemChangeOver();

}

