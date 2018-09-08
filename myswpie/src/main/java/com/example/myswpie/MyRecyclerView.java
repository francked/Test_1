package com.example.myswpie;

import android.content.Context;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

/**
 * Created by ryan on 18-9-4.
 */

public class MyRecyclerView extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private Context context;
    private List<String> list;
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_FOOTER = 1;

    //上拉加载更多
    public static final int PULLUP_LOAD_MORE = 0;
    //正在加载中
    public static final int LOADING_MORE     = 1;
    //没有加载更多 隐藏
    public static final int NO_LOAD_MORE     = 2;

    //上拉加载更多状态-默认为0
    private int mLoadMoreStatus = 0;

    OnItemClickLinstener listener;

    public MyRecyclerView(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_FOOTER){
            View view = LayoutInflater.from(context).inflate(R.layout.item_foot,parent,false);
            FootHolder holder = new FootHolder(view);
            view.setOnClickListener(this);

            return holder;
        }else if(viewType == TYPE_ITEM){
            View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
            ItemHolder holder = new ItemHolder(view);
            view.setOnClickListener(this);

            return holder;
        }

        return null;



    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemHolder) {
            ItemHolder itemHolder = (ItemHolder) holder;
            itemHolder.itemView.setTag(position);

            itemHolder.text.setText("我住在 " + list.get(position) + "楼。");
        }else if (holder instanceof FootHolder){
            FootHolder footHolder = (FootHolder) holder;
            footHolder.itemView.setTag(position);
            switch (mLoadMoreStatus){
                case PULLUP_LOAD_MORE:
                    footHolder.text.setText("上拉加载更多....");
                    break;
                case LOADING_MORE:
                    footHolder.text.setText("正在加载更多....");
                    break;
                case NO_LOAD_MORE:
                    footHolder.linearLayout.setVisibility(View.GONE);
                    break;
            }
        }

    }


    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()){
            //最后一个item设置为footerView
            return TYPE_FOOTER;
        }else {
            return TYPE_ITEM;
        }
    }



    @Override
    public int getItemCount() {
        return list.size() == 0 ? 0 : list.size() +1;
    }

    @Override
    public void onClick(View v) {
        if (listener != null){
            listener.onClick(v, (Integer) v.getTag());

        }
    }

    class ItemHolder extends RecyclerView.ViewHolder  {

        TextView text;

        public ItemHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
        }


    }

    class FootHolder extends RecyclerView.ViewHolder  {


        TextView text;
        LinearLayout linearLayout;
        public FootHolder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.line1);
            text = itemView.findViewById(R.id.tv_footView);
        }


    }

    public void AddHeaderItem(List<String> items) {
        list.addAll(0, items);
        notifyDataSetChanged();
    }

    public void AddFooterItem(List<String> items) {
        list.addAll(items);
        notifyDataSetChanged();
    }


    /**
     * 更新加载更多状态
     * @param status
     */
    public void changeMoreStatus(int status){
        mLoadMoreStatus=status;
        notifyDataSetChanged();
    }

    public void setOnItemClickListener(OnItemClickLinstener listener){
        this.listener = listener;
    }

    //点击接口
    public interface OnItemClickLinstener{
        void onClick(View view,int position);
    }



}
