package com.example.mytablayout.searchwenjian;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mytablayout.R;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ryan on 18-8-18.
 */

public class MyAdapter extends BaseAdapter {

    Context context;
    List<File> list;

    public MyAdapter(Context context, List<File> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            //布局实例化
            convertView = View.inflate(context, R.layout.file_item_1, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // 设置数据
        File file = (File) getItem(position);
        if (file.isDirectory()) {
            viewHolder.img.setImageResource(R.drawable.file);
        } else {
            if (file.getName().endsWith(".jpg")
                    || file.getName().endsWith(".png")
                    || file.getName().endsWith(".gif")) {
                viewHolder.img.setImageResource(R.drawable.pic);
            } else if (file.getName().endsWith(".txt") || file.getName().endsWith(".log")) {
                viewHolder.img.setImageResource(R.drawable.text);
            } else {
                viewHolder.img.setImageResource(R.drawable.ic_event);
            }
        }
        viewHolder.name.setText(file.getName());
        viewHolder.time.setText(new SimpleDateFormat("yy-M-d HH:mm:ss")
                .format(new Date(file.lastModified())));

        return convertView;
    }

    class ViewHolder {
        ImageView img;
        TextView name;
        TextView time;

        public ViewHolder(View convertView) {
            img = (ImageView) convertView.findViewById(R.id.img);
            name = (TextView) convertView.findViewById(R.id.name);
            time = (TextView) convertView.findViewById(R.id.time);
        }

    }

}
