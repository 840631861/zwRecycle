# zwRecycle
拖拽排序，长按显示删除按钮
### 参考项目:RecycleView&ItemTouchHelp，更改：点击编辑按钮删除改为长按显示删除按钮，解决长按拖动删除时position错乱问题。*

参考项目：
[https://github.com/huyue05/ItemTouchHelper-RecycleView](https://github.com/huyue05/ItemTouchHelper-RecycleView)

#### 以下是演示图片
![image](https://github.com/840631861/zwRecycle/blob/master/images/gif5%E6%96%B0%E6%96%87%E4%BB%B6.gif)<br>
最近要做一个可以拖拽排序、可以长按显示删除按钮、还有分组展示item等要求的recycleview或gridview<br>
开始不想重复找轮子，就在网上找了很多，都不能满足公司的要求，最后找了一个又自己改了一些，才满足要求。<br>
解决隐藏问题：长按拖动后，在没有点完成前又点了删除，会删除错误的item<br>
原因是拖动完还没有刷新整个控件的话position不会变化，所以拖动完删除position没变<br>
最后重写了RecycleView，在里面加上了onTouchEvent监听手指松开事件，松开后刷新控件，position就更改过来了<br>
#### 如果有好的解决办法请联系我，谢谢！<br>
#### 博客地址：http://blog.csdn.net/qq_26075861/article/details/79192858<br>
