package com.example.mymvp.content.fragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mymvp.R;
import com.example.mymvp.content.recyclerview.LoadMoreRecycleAdapter;
import com.example.mymvp.content.util.GanHuoEntity;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dasu on 2017/4/20.
 *
 * Fragment中的RecyclerView的适配器，用于显示各干货数据
 */

class CategoryRecycleAdapter extends LoadMoreRecycleAdapter<CategoryRecycleAdapter.ViewHolder> {

    private List<GanHuoEntity> mDataList;
    private Context mContext;
    //private OnItemClickListener<GanHuo.ResultsBean> mClickListener;

    CategoryRecycleAdapter(List<GanHuoEntity> data) {
        mDataList = data;
    }

    @Override
    public int getDataSize() {
        return mDataList != null ? mDataList.size() : 0;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindView(ViewHolder holder, int position) {
        final GanHuoEntity data = mDataList.get(position);
        holder.mTitleTv.setText(data.getDesc());

    }

//    private void setDemoImage(final ScaleImageView imageView, List<String> images) {
//        Glide.with(mContext)
//                .load(images != null ? images.get(0) : "http://www.baidu.com.jpg")
//                .crossFade()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .placeholder(R.drawable.img_loading_image)
//                .error(R.drawable.img_no_image)
//                .into(imageView);
//    }
//
//    private void setDate(Date date, TextView tv) {
//        String time = TimeUtils.howLongAgo(TimeUtils.adjustDate(date));
//        tv.setText(time);
//    }
//
//    public void setOnItemClickListener(OnItemClickListener<GanHuoEntity> listener) {
//        mClickListener = listener;
//    }

    class ViewHolder extends RecyclerView.ViewHolder {

        //        ScaleImageView mDemoIv;
        TextView mTitleTv;
//        TextView mAuthorTv;
//        TextView mSourceTv;
//        TextView mDateTv;
//        ViewGroup mInfoLayout;
//        TextView mImgCountsTv;
//        GanHuoEntity data;

        ViewHolder(View itemView) {
            super(itemView);
            mTitleTv = itemView.findViewById(R.id.tv);
//            mTitleTv = (TextView) itemView.findViewById(R.id.tv_category_title);
//            mSourceTv = (TextView) itemView.findViewById(R.id.tv_category_source);
//            mAuthorTv = (TextView) itemView.findViewById(R.id.tv_category_author);
//            mDateTv = (TextView) itemView.findViewById(R.id.tv_category_date);
//            mInfoLayout = (ViewGroup) itemView.findViewById(R.id.layout_category_info);
//            mImgCountsTv = (TextView) itemView.findViewById(R.id.tv_category_img_count);
//            mDemoIv.setOnClickListener(this);
//            mInfoLayout.setOnClickListener(this);
        }

//        @Override
//        public void onClick(View v) {
//            if (mClickListener != null) {
//                if (v == mDemoIv) {
//                    List<String> imgs = null;
//                    if (data.getImages() != null && data.getImages().size() > 0) {
//                        imgs = data.getImages();
//                    } else {
//                        imgs = new ArrayList<>();
//                        imgs.add("http://upload-images.jianshu.io/upload_images/1924341-8663c74266577e74.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240");
//                    }
//                    mClickListener.onImageClick(imgs);
//                } else {
//                    mClickListener.onItemClick(data);
//                }
//            }
//        }
//    }
    }
}
