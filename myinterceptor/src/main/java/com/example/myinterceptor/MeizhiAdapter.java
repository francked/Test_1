package com.example.myinterceptor;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.List;

/**
 * Created by ryan on 18-9-1.
 */

public class MeizhiAdapter extends RecyclerView.Adapter<MeizhiAdapter.Holder> {


    private Context context;

    List<GanHuo> list;

    public MeizhiAdapter(Context context, List<GanHuo> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MeizhiAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.meizhi_item,parent,false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MeizhiAdapter.Holder holder, int position) {

        String url = list.get(position).getUrl();
        Glide.with(context).load(url)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(new SimpleTarget<Bitmap>() {

                    @Override
                    public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                        holder.itemView.setVisibility(View.VISIBLE);
                        holder.image.setOriginSize(resource.getWidth(),resource.getHeight());
                        holder.image.setImageBitmap(resource);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        SalceImage image;
        public Holder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.meizhi_image);
        }
    }

    @Override
    public int getItemViewType(int position) {

        return super.getItemViewType(position);
    }




}
