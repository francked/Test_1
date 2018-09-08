package com.example.ryan.test_1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryan on 18-8-13.
 */

public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.MyHolder> implements View.OnLongClickListener, View.OnClickListener {
    List<String> list = new ArrayList<>();
    Context context;

    OnItemClickListener mOnItemClickListener;


    public MyRecyclerView(List<String> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyRecyclerView.MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_1,parent,false);
        MyHolder holder = new MyHolder(view);
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyRecyclerView.MyHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.text.setText(list.get(position));

    }

    public void removeData(int position){
        list.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public boolean onLongClick(View v) {
        if (mOnItemClickListener != null){
            mOnItemClickListener.onItemLongClick(v,(int)v.getTag());
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null){
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    class MyHolder extends RecyclerView.ViewHolder {
        TextView text;
        public MyHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.text);
        }
    }

    interface OnItemClickListener{
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    public void setOnItemClickLinstener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }
}
