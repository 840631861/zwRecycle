package com.example.administrator.recycle;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import com.example.recyledapter.RecycleAdapter;


/**
 * Created by Administrator on 2018\1\27 0027.
 */

public class MyRecyclerView extends RecyclerView {
    private ImageView mDeleteButton;
    private RecycleAdapter mDragAdapter;
    private onEventUpLis eventUpLis;

    public MyRecyclerView(Context context) {
        super(context);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        switch (e.getAction())
        {
            case MotionEvent.ACTION_UP:
                eventUpLis.onEventUp();
                break;
        }
        return super.onTouchEvent(e);
    }

    public Handler mHandler = new Handler();
    //用来处理是否为长按的Runnable
    public Runnable mLongClickRunnable = new Runnable() {

        @Override
        public void run() {
            //显示删除按钮，除了最后一个
            for (int i = 0;i < getChildCount()-1;i++) {
                final View mGridItemView = getChildAt(i);
                mDeleteButton = (ImageView) mGridItemView.findViewById(R.id.img_delete);
                mDeleteButton.setVisibility(VISIBLE);
            }
        }
    };

    @Override
    public void setAdapter(Adapter adapter) {
        super.setAdapter(adapter);
        mDragAdapter = (RecycleAdapter) adapter;//回调方法的关键,拿到了该接口被实现后的实例
    }

    public interface onEventUpLis{
        public void onEventUp();
    }

    public void setOnEventUpLis(onEventUpLis eventUpLis)
    {
        this.eventUpLis = eventUpLis;
    }
}
