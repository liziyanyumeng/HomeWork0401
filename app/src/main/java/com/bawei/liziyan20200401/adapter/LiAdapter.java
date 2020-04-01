package com.bawei.liziyan20200401.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.liziyan20200401.R;
import com.bawei.liziyan20200401.bean.DetailList;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class LiAdapter extends RecyclerView.Adapter<LiAdapter.ViewHolder> {
    public Context context;
    public ArrayList<DetailList> detailList;

    public LiAdapter(Context context, ArrayList<DetailList> detailList) {
        this.context = context;
        this.detailList = detailList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View inflate = LayoutInflater.from(context).inflate(R.layout.lli_adapter, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ImageView imageNei = holder.imageNei;
        final TextView tvName = holder.tvName;
        final TextView tvPrice = holder.tvPrice;
        final DetailList detailList = this.detailList.get(position);
        final String commodityName = detailList.commodityName;
        final String commodityPic = detailList.commodityPic;
        final double commodityPrice = detailList.commodityPrice;
        tvName.setText(commodityName);
        tvPrice.setText("￥"+commodityPrice);
        final String[] split = commodityPic.split(",");
        Glide.with(context).load(split[0]).into(imageNei);
    }

    @Override
    public int getItemCount() {
        return detailList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageNei;
        private TextView tvName;
        private TextView tvPrice;
        private TextView tvCount;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageNei = (ImageView) itemView.findViewById(R.id.image_nei);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_price);
            tvCount = (TextView) itemView.findViewById(R.id.tv_count);
        }
    }
}
