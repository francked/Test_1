package com.example.myinterceptor;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.List;

/**
 * Created by ryan on 18-9-1.
 */

public class Meizhi_1Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public enum LoadStatus{
        CLICK_LOAD_MORE, // 上拉加载更多
        LOADING_MORE   // 正在加载更多
    }

    private LoadStatus mLoadStatus = LoadStatus.CLICK_LOAD_MORE; //上拉加载的状态

    private static final int VIEW_TYPE_FOOTER = 0;
    private static final int VIEW_TYPE_ITEM = 1;



    private Context context;

    List<GanHuo> list ;

    public Meizhi_1Adapter(Context context, List<GanHuo> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //当 viewType = 1 时， 布局使用item
        if (viewType == VIEW_TYPE_FOOTER){
            return onCreateFooterViewHolder(parent, viewType);

        //当 viewType = 0 时， 布局使用footer
        }else if (viewType == VIEW_TYPE_ITEM){
            return onCreateItemViewHolder(parent, viewType);
        }

        return null;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case VIEW_TYPE_ITEM:
                onBindItemViewHolder(holder, position);
                break;
            case VIEW_TYPE_FOOTER:
                onBindFooterViewHolder(holder, position, mLoadStatus);
                break;
            default:
                break;
        }
    }

    public RecyclerView.ViewHolder onCreateFooterViewHolder(ViewGroup parent, int viewType){

        View view = LayoutInflater.from(context).inflate(R.layout.footer_layout,parent,false);
        return new FooterViewHolder(view);
    }
    public RecyclerView.ViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType){


        View view = LayoutInflater.from(context).inflate(R.layout.meizhi_item,parent,false);
        return new ItemViewHolder(view);
    }

    public void onBindItemViewHolder(final RecyclerView.ViewHolder holder, int position) {
        final ItemViewHolder viewHolder = (ItemViewHolder) holder;

        Glide.with(context).load(getItem(position))
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(new SimpleTarget<Bitmap>() {

                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        viewHolder.itemView.setVisibility(View.VISIBLE);
                        viewHolder.image.setOriginSize(resource.getWidth(),resource.getHeight());
                        viewHolder.image.setImageBitmap(resource);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return list.size() + 1;
    }
    public  void refresh(){
        notifyDataSetChanged();
    }
    public String getItem(int position) {
        return list.get(position).getUrl();
    }

    public void addAll(List<GanHuo> list) {
        this.list.addAll(list);
        notifyDataSetChanged();
    }



    @Override
    public int getItemViewType(int position) {
        if (position + 1 == getItemCount()) {//最后一条为FooterView
            return VIEW_TYPE_FOOTER;
        }

        return VIEW_TYPE_ITEM;
    }

    public void reSetData(List<GanHuo> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public void setLoadStatus(LoadStatus loadStatus) {
        this.mLoadStatus = loadStatus;
    }


    public void onBindFooterViewHolder(RecyclerView.ViewHolder holder, int position, Meizhi_1Adapter.LoadStatus loadStatus) {
        FooterViewHolder viewHolder = (FooterViewHolder) holder;
        switch (loadStatus) {
            case CLICK_LOAD_MORE:
                viewHolder.mLoadingLayout.setVisibility(View.GONE);
                viewHolder.mClickLoad.setVisibility(View.VISIBLE);
                break;
            case LOADING_MORE:
                viewHolder.mLoadingLayout.setVisibility(View.VISIBLE);
                viewHolder.mClickLoad.setVisibility(View.GONE);
                break;
        }
    }


    class FooterViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout mLoadingLayout;
        public TextView mClickLoad;
        public FooterViewHolder(View view) {
            super(view);
            mLoadingLayout= itemView.findViewById(R.id.loading);
            mClickLoad= itemView.findViewById(R.id.click_load_txt);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        SalceImage image;

        public ItemViewHolder(View view) {
            super(view);
            image = view.findViewById(R.id.meizhi_image);

        }
    }
}
