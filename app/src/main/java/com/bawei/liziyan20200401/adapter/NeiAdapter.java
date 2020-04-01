package com.bawei.liziyan20200401.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.liziyan20200401.R;
import com.bawei.liziyan20200401.bean.ShoppingCartList;
import com.bawei.liziyan20200401.util.ImageUtil;

import java.util.ArrayList;

public class NeiAdapter extends RecyclerView.Adapter<NeiAdapter.MyViewHolder> {
    public Context context;
    public ArrayList<ShoppingCartList> shoppingCartList;

    public ArrayList<ShoppingCartList> getShoppingCartList() {
        return shoppingCartList;
    }

    public NeiAdapter(Context context, ArrayList<ShoppingCartList> shoppingCartList) {
        this.context = context;
        this.shoppingCartList = shoppingCartList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View inflate = LayoutInflater.from(context).inflate(R.layout.nei_adapter, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final CheckBox showCheck = holder.showCheck;
        final ImageView showImage = holder.showImage;
        final TextView textName = holder.textName;
        final TextView textPrice = holder.textPrice;
        final ShoppingCartList shoppingCartList = this.shoppingCartList.get(position);
        final String commodityName = shoppingCartList.commodityName;
        final String pic = shoppingCartList.pic;
        final double price = shoppingCartList.price;
        textName.setText(commodityName);
        textPrice.setText("￥"+price);
        final ImageUtil instance = ImageUtil.getInstance();
        instance.getPictore(pic,showImage);
        final boolean ischecked = shoppingCartList.ischecked;
        showCheck.setChecked(ischecked);
    }

    @Override
    public int getItemCount() {
        return shoppingCartList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private CheckBox showCheck;
        private ImageView showImage;
        private TextView textName;
        private TextView textPrice;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            showCheck = (CheckBox) itemView.findViewById(R.id.show_check);
            showImage = (ImageView) itemView.findViewById(R.id.show_image);
            textName = (TextView) itemView.findViewById(R.id.text_name);
            textPrice = (TextView) itemView.findViewById(R.id.text_price);
        }
    }
}
