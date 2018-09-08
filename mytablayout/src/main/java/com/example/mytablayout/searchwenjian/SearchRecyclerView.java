package com.example.mytablayout.searchwenjian;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mytablayout.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryan on 18-8-17.
 */

public class SearchRecyclerView extends RecyclerView.Adapter<SearchRecyclerView.Holder> implements View.OnClickListener {

    List<FileBean> list = new ArrayList<>();
    private Context context;

    private OnFileClickListener onFileClickListener;

    private static final String TAG = "SearchRecyclerView";

    public SearchRecyclerView(List<FileBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public SearchRecyclerView.Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.file_item,parent,false);
        view.setOnClickListener(this);
        Holder holder = new Holder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(SearchRecyclerView.Holder holder, int position) {

        Log.d(TAG, "name: " + list.get(position).getName() + " path: " + list.get(position).getPath());
        holder.name.setText(list.get(position).getName());
        holder.path.setText(list.get(position).getPath());
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onClick(View v) {
        if (onFileClickListener != null){
            onFileClickListener.onFileClick(v, (int) v.getTag());
        }
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView name;
        TextView path;
        public Holder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            path = itemView.findViewById(R.id.path);
        }
    }

    public void setOnItemClickListener(OnFileClickListener onFileClickListener){
        this.onFileClickListener = onFileClickListener;
    }

    interface OnFileClickListener{
        void onFileClick(View view, int position );

    }
}
