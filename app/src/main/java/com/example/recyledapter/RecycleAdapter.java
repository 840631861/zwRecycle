package com.example.recyledapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.recycle.MyRecyclerView;
import com.example.administrator.recycle.R;
import com.example.administrator.recycle.v_channel;
import com.example.com.example.Listener.OnItemOnclikListener;
import com.example.com.example.callback.ItemDragHelperCallback;

import java.util.ArrayList;
import java.util.Collections;


public class RecycleAdapter extends RecyclerView.Adapter<MyViewHolder> implements ItemDragHelperCallback.ItemTouchHelperAdapter {

    LayoutInflater mInflater;
    Context context;
    ArrayList<v_channel> mData;
    //flag是true的话 就会出现XX
    Boolean flag;
    int type;

    //以下2个方法是重写ItemTouchHelperAdapter
    // notifyItemRemoved()和 notifyItemMoved()的调用非常重要，
    // 有了它们Adapter才能知道发生了改变。同时还需要
    // 注意的是每当一个view切换到了一个新的索引时，我们都需要改变item的位置，而不是在拖动事件结束的时候。
    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        //Collections.swap(mData, fromPosition, toPosition);
        //notifyItemMoved(fromPosition, toPosition);

        if (toPosition == mData.size() - 1 || mData.size() - 1 == fromPosition) {
            return;
        }
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mData, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mData, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
        mOnClikListener.OnItemChangeOver();
    }
    @Override
    public void onItemDismiss(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
    }

    public  void setmData( ArrayList<v_channel> mData){
        this.mData=mData;
    }

    public  void  addsmData(v_channel obj){
        mData.add(obj);
    }
    public  void  deletesmData(int  pos){
        mData.remove(pos);
    }

    //点击事件监听的声明和设置
    public OnItemOnclikListener mOnClikListener;
    public void SetOnClikListener(OnItemOnclikListener mOnClikListener) {
        this.mOnClikListener = mOnClikListener;
    }


    public RecycleAdapter(ArrayList<v_channel> mData, Context context,int typpe) {
        this.mData = mData;
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.type = typpe;

        flag =false;

    }



    //创建viewholder
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        if( type == 1 ) view = mInflater.inflate(R.layout.item_recycler1, parent, false);
        else if( type == 2 ) view = mInflater.inflate(R.layout.item_recycler2, parent, false);
        else if( type == 3 ) view = mInflater.inflate(R.layout.item_recycler3, parent, false);
        else view = mInflater.inflate(R.layout.item_recycler4, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
    }

    //绑定viewholder
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tv_item.setText(mData.get(position).getName());
        holder.img.setImageDrawable(context.getResources().getDrawable(mData.get(position).getImgId()));
        if (mOnClikListener != null) {
            holder.item.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {
                    mOnClikListener.OnItemClik(view, position);
                }

            });
            holder.item.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mOnClikListener.OnItemLongClik(holder,view, position);
                    return true;
                }
            });
            holder.img_delete_item.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnClikListener.OnItemClik(view, position);
                }
            });
        }
        if (flag==false){
            holder.img_delete_item.setVisibility(View.GONE);
        }else {
            //显示删除按钮，除了最后一个
            if( position < mData.size()-1 )
                holder.img_delete_item.setVisibility(View.VISIBLE);
            else
                holder.img_delete_item.setVisibility(View.GONE);
        }
    }
    @Override
    public int getItemCount() {
        return mData.size();
    }

    public  void changeAllImg(Boolean flag){
        this.flag =flag;

    }
}

class MyViewHolder extends MyRecyclerView.ViewHolder {

    RelativeLayout item;
    TextView tv_item;
    ImageView img_delete_item;
    ImageView img;

    public MyViewHolder(View itemView) {
        super(itemView);
        item = (RelativeLayout) itemView.findViewById(R.id.item);
        tv_item = (TextView) itemView.findViewById(R.id.txt);
        img_delete_item = (ImageView) itemView.findViewById(R.id.img_delete);
        img = (ImageView) itemView.findViewById(R.id.img);
    }
}
