package com.example.mytablayout.retrofit;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.mytablayout.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ryan on 18-8-22.
 */

public class DouBanAdapter extends RecyclerView.Adapter<DouBanAdapter.ViewHolder> {
    private static final String TAG = "DouBanAdapter";
    private Context context;
    private List<Integer> list;

    public DouBanAdapter(Context context, List<Integer> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public DouBanAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.douban_item,parent,false);
        ViewHolder viewHolder  = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final DouBanAdapter.ViewHolder holder, int position) {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.douban.com/").addConverterFactory(GsonConverterFactory.create()).build();

        IService iService = retrofit.create(IService.class);

        Call<DouBan> call = iService.getDuoBan(String.valueOf(ID.id + list.get(position)));

        Log.d(TAG, "id: " +String.valueOf(ID.id + list.get(position)));

        call.enqueue(new Callback<DouBan>() {
            @Override
            public void onResponse(Call<DouBan> call, Response<DouBan> response) {

                DouBan douBan = response.body();

                String url = douBan.getImages().getMedium();
                Log.d(TAG, "url: " + douBan.getId());
                Glide.with(context).load(url).placeholder(R.drawable.mao).into(holder.imageView);

            }

            @Override
            public void onFailure(Call<DouBan> call, Throwable t) {

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
