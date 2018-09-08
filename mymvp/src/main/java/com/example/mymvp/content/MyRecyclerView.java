package com.example.mymvp.content;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mymvp.R;
import com.example.mymvp.content.util.GanHuoEntity;

import java.util.List;

/**
 * Created by ryan on 18-8-30.
 */

public class MyRecyclerView extends RecyclerView.Adapter<MyRecyclerView.ViewHolder> {
    private List<GanHuoEntity> mDataList;

    private Context mContext;
    public MyRecyclerView(List<GanHuoEntity> data) {
        mDataList = data;
    }

    @Override
    public MyRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyRecyclerView.ViewHolder holder, int position) {
        holder.tv.setText(mDataList.get(0).getDesc());
    }

    @Override
    public int getItemCount() {
        return mDataList != null ? mDataList.size() : 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv;

        public ViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }
}
