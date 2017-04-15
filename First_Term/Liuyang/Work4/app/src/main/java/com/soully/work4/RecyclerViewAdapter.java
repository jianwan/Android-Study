package com.soully.work4;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Soully on 2017/1/19.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    List<RecyclerData> mDataList;
    View oneView;
    /*
  将数据源传进来
   */
    public RecyclerViewAdapter(List<RecyclerData> dataOneList){
        this.mDataList = dataOneList;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView max;
        TextView min;
        TextView date;
        TextView txt_d;
        public ViewHolder(View itemView) {
            /*
            itemView子项的最外层布局
             */
            super(itemView);
            oneView = itemView;
            max = (TextView) itemView.findViewById(R.id.max);
            min = (TextView) itemView.findViewById(R.id.min);
            date = (TextView) itemView.findViewById(R.id.date);
            txt_d = (TextView) itemView.findViewById(R.id.txt_d);
        }
    }
    /**
     创建了一个ViewHolder实例将布局加进去，返回ViewHolder实例
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclercontent,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        return holder;
    }
    /**
     对Item赋值： 通过当前的position的值，确定哪些item在屏幕内，进行赋值
     */
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final RecyclerData data = mDataList.get(position);
        holder.txt_d.setText(data.getTxt_d());
        holder.min.setText(data.getMin());
        holder.max.setText(data.getMax());
        holder.date.setText(data.getDate());
    }

    /**
     *一共有多少子项
     */
    @Override
    public int getItemCount() {
        return mDataList.size();
    }

}
