package com.example.administrator.recycle;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.FastjsonHelper;
import com.example.com.example.Listener.OnItemOnclikListener;
import com.example.com.example.callback.ItemDragHelperCallback;
import com.example.com.example.divider.RecyclerViewDivider;
import com.example.recyledapter.RecycleAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends  AppCompatActivity {

    private Context context;
    MyRecyclerView recyclerView,recyclerView2,recyclerView3,recyclerView4;
    RecycleAdapter topadapter,topadapter2,topadapter3,topadapter4;
    ArrayList<v_channel> topRecleList,topRecleList2,topRecleList3,topRecleList4;
    ItemTouchHelper touchHelper,touchHelper2,touchHelper3,touchHelper4;

    TextView tv_caozuo,tv_caozuo2,tv_caozuo3,tv_caozuo4,tv_cancel,tv_cancel2,tv_cancel3,tv_cancel4;
    Boolean caozuo_flag,caozuo_flag2,caozuo_flag3,caozuo_flag4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;

        initMainDrag();
    }

    //初始化gridview
    private void initMainDrag()
    {
        initGragData();
        initDragView();
        listenDragView(recyclerView,topadapter,topRecleList,touchHelper,1,tv_caozuo,tv_cancel);
        listenDragView(recyclerView2,topadapter2,topRecleList2,touchHelper2,2,tv_caozuo2,tv_cancel2);
        listenDragView(recyclerView3,topadapter3,topRecleList3,touchHelper3,3,tv_caozuo3,tv_cancel3);
        listenDragView(recyclerView4,topadapter4,topRecleList4,touchHelper4,4,tv_caozuo4,tv_cancel4);
    }

    private void initGragData() {

        topRecleList = new ArrayList<v_channel>();
        for (int i = 0; i < 5; i++) {
            topRecleList.add(new v_channel("name"+i,R.mipmap.ic_recycler_item_1,i));
        }
        topRecleList.add(new v_channel("add",R.mipmap.ic_recycler_item_add2,5));

        topRecleList2 = new ArrayList<v_channel>();
        for (char i = 'A'; i <'C'; i++) {
            topRecleList2.add(new v_channel("name"+i,R.mipmap.ic_recycler_item_7,i));
        }
        topRecleList2.add(new v_channel("add",R.mipmap.ic_recycler_item_add2,2));

        topRecleList3 = new ArrayList<v_channel>();
        for (char i = 'A'; i <'B'; i++) {
            topRecleList3.add(new v_channel("name"+i,R.mipmap.ic_recycler_item_9,i));
        }
        topRecleList3.add(new v_channel("add",R.mipmap.ic_recycler_item_add1,1));

        topRecleList4 = new ArrayList<v_channel>();
        for (char i = 'A'; i <'B'; i++) {
            topRecleList4.add(new v_channel("name"+i,R.mipmap.ic_recycler_item_10,i));
        }
        topRecleList4.add(new v_channel("add",R.mipmap.ic_recycler_item_add1,1));
    }

    private void  initDragView() {

        tv_caozuo= (TextView) findViewById(R.id.include_title).findViewById(R.id.tv_caozuo);
        tv_caozuo2= (TextView) findViewById(R.id.include_title2).findViewById(R.id.tv_caozuo);
        tv_caozuo3= (TextView) findViewById(R.id.include_title3).findViewById(R.id.tv_caozuo);
        tv_caozuo4= (TextView) findViewById(R.id.include_title4).findViewById(R.id.tv_caozuo);

        tv_cancel= (TextView) findViewById(R.id.include_title).findViewById(R.id.tv_cancel);
        tv_cancel2= (TextView) findViewById(R.id.include_title2).findViewById(R.id.tv_cancel);
        tv_cancel3= (TextView) findViewById(R.id.include_title3).findViewById(R.id.tv_cancel);
        tv_cancel4= (TextView) findViewById(R.id.include_title4).findViewById(R.id.tv_cancel);
        caozuo_flag =false;
        caozuo_flag2 = false;
        caozuo_flag3 =false;
        caozuo_flag4 =false;

        RecyclerViewDivider dividerV = new RecyclerViewDivider(context, LinearLayoutManager.VERTICAL, 1, ContextCompat.getColor(context, R.color.gap_line));
        RecyclerViewDivider dividerH = new RecyclerViewDivider(context, LinearLayoutManager.HORIZONTAL, 1, ContextCompat.getColor(context, R.color.gap_line));

        //1部分的recycle进行初始化
        recyclerView= (MyRecyclerView) findViewById(R.id.recyle_top);
        topadapter=new RecycleAdapter(topRecleList,getApplication(),1);
        MyRecyclerView.LayoutManager manager = new GridLayoutManager(getApplicationContext(),3);
        recyclerView.setLayoutManager(manager);
        //设置监听
        ItemDragHelperCallback callback = new ItemDragHelperCallback(topadapter);
        touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);
        recyclerView.setAdapter(topadapter);
        recyclerView.addItemDecoration(dividerV);
        recyclerView.addItemDecoration(dividerH);

        //2部分的recycle进行初始化
        recyclerView2= (MyRecyclerView) findViewById(R.id.recyle_top2);
        topadapter2=new RecycleAdapter(topRecleList2,getApplication(),2);
        MyRecyclerView.LayoutManager manager2 = new GridLayoutManager(getApplicationContext(),3);
        recyclerView2.setLayoutManager(manager2);
        //设置监听
        ItemDragHelperCallback callback2 = new ItemDragHelperCallback(topadapter2);
        touchHelper2 = new ItemTouchHelper(callback2);
        touchHelper2.attachToRecyclerView(recyclerView2);
        recyclerView2.setAdapter(topadapter2);
        recyclerView2.addItemDecoration(dividerV);
        recyclerView2.addItemDecoration(dividerH);

        //3部分的recycle进行初始化
        recyclerView3= (MyRecyclerView) findViewById(R.id.recyle_top3);
        topadapter3=new RecycleAdapter(topRecleList3,getApplication(),3);
        MyRecyclerView.LayoutManager manager3 = new GridLayoutManager(getApplicationContext(),3);
        recyclerView3.setLayoutManager(manager3);
        //设置监听
        ItemDragHelperCallback callback3 = new ItemDragHelperCallback(topadapter3);
        touchHelper3 = new ItemTouchHelper(callback3);
        touchHelper3.attachToRecyclerView(recyclerView3);
        recyclerView3.setAdapter(topadapter3);
        recyclerView3.addItemDecoration(dividerV);
        recyclerView3.addItemDecoration(dividerH);

        //4部分的recycle进行初始化
        recyclerView4= (MyRecyclerView) findViewById(R.id.recyle_top4);
        topadapter4=new RecycleAdapter(topRecleList4,getApplication(),4);
        MyRecyclerView.LayoutManager manager4 = new GridLayoutManager(getApplicationContext(),4);
        recyclerView4.setLayoutManager(manager4);
        //设置监听
        ItemDragHelperCallback callback4 = new ItemDragHelperCallback(topadapter4);
        touchHelper4 = new ItemTouchHelper(callback4);
        touchHelper4.attachToRecyclerView(recyclerView4);
        recyclerView4.setAdapter(topadapter4);
        recyclerView4.addItemDecoration(dividerV);
        recyclerView4.addItemDecoration(dividerH);
    }

    private void  listenDragView(final MyRecyclerView recyclerView, final RecycleAdapter topadapter, final ArrayList<v_channel> topRecleList, final ItemTouchHelper touchHelper, int type, final TextView tv_caozuo, final TextView tv_cancel ) {
        final boolean[] flag = {false};
        if( type == 1 ) flag[0] = caozuo_flag;
        if( type == 2 ) flag[0] = caozuo_flag2;
        if( type == 3 ) flag[0] = caozuo_flag3;
        if( type == 4 ) flag[0] = caozuo_flag4;

        topadapter.SetOnClikListener(new OnItemOnclikListener() {

            public void OnItemLongClik(MyRecyclerView.ViewHolder holder,View view, int postion) {
                if (view.getId()==R.id.item){
                    Toast.makeText(getApplication(),"long clike"+postion,Toast.LENGTH_SHORT).show();
                    if (postion != topRecleList.size() - 1)
                    {
                        touchHelper.startDrag(holder);
                        recyclerView.mHandler.postDelayed(recyclerView.mLongClickRunnable,10);
                        flag[0] =true;
                        tv_caozuo.setText("完成");
                        tv_caozuo.setVisibility(View.VISIBLE);
                        tv_cancel.setVisibility(View.VISIBLE);
                    }
                }

            }
            public void OnItemClik(View view, int postion) {
                if (view.getId()==R.id.item){
                    Toast.makeText(getApplication(),"clik"+topRecleList.get(postion).getName(),Toast.LENGTH_SHORT).show();
                }else if (view.getId()==R.id.img_delete){
                    v_channel str = topRecleList.get(postion);
                    topadapter.deletesmData(postion);

                    topadapter.changeAllImg(flag[0]);
                    topadapter.setmData(topRecleList);
                    topadapter.notifyDataSetChanged();
                }

            }

            @Override
            public void OnItemChangeOver() {

            }
        });

        //手指抬起监听，防止拖动完后position没有改变，删除的话会删错
        recyclerView.setOnEventUpLis(new MyRecyclerView.onEventUpLis() {
            @Override
            public void onEventUp() {
                topadapter.changeAllImg(flag[0]);
                topadapter.setmData(topRecleList);
                topadapter.notifyDataSetChanged();
            }
        });

        tv_caozuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag[0] == true){
                    flag[0] =false;
                    tv_caozuo.setText("编辑");
                    tv_caozuo.setVisibility(View.GONE);
                    tv_cancel.setVisibility(View.GONE);

                    updateDragDatas(topRecleList);
                }else{
                    flag[0] =true;
                    tv_caozuo.setText("完成");
                    tv_caozuo.setVisibility(View.VISIBLE);
                    tv_cancel.setVisibility(View.VISIBLE);
                }
                topadapter.changeAllImg(flag[0]);
                topadapter.notifyDataSetChanged();
            }
        });


        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag[0] =false;
                tv_caozuo.setText("编辑");
                tv_caozuo.setVisibility(View.GONE);
                tv_cancel.setVisibility(View.GONE);
                topadapter.changeAllImg(flag[0]);
                topadapter.notifyDataSetChanged();
            }
        });

    }

    /**
     * 上传编辑或删除后的数据
     * @param list
     */
    private void updateDragDatas( List<v_channel> list )
    {
        if( list == null || list.size() == 0 )
            return;
        for( int i=0;i<list.size();i++ )
        {
            list.get(i).setSort(i);
        }
        Toast.makeText(MainActivity.this, FastjsonHelper.serialize(list),Toast.LENGTH_SHORT).show();
    }
}
