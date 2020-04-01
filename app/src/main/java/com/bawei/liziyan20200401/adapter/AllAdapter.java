package com.bawei.liziyan20200401.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.liziyan20200401.CreateActivity;
import com.bawei.liziyan20200401.R;
import com.bawei.liziyan20200401.ShowActivity;
import com.bawei.liziyan20200401.bean.ResultBean;
import com.bawei.liziyan20200401.bean.ShoppingCartList;

import java.util.ArrayList;

public class AllAdapter extends RecyclerView.Adapter<AllAdapter.MyViewHolder> {
    public Context context;
    public ArrayList<ResultBean> result;

    public ArrayList<ResultBean> getResult() {
        return result;
    }

    public AllAdapter(Context context, ArrayList<ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View inflate = LayoutInflater.from(context).inflate(R.layout.show_adapter, parent, false);
        return new MyViewHolder(inflate);
    }

    public void ischecked(boolean checked){
        for (int i = 0; i < result.size(); i++){
            result.get(i).ischecked = checked;
            final ArrayList<ShoppingCartList> shoppingCartList = result.get(i).shoppingCartList;
            for (int j = 0; j < shoppingCartList.size(); j++){
                shoppingCartList.get(j).ischecked = checked;
            }
        }
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final TextView textName = holder.textName;
        final RecyclerView recycler = holder.recycler;
        final CheckBox showCheck = holder.showCheck;
        final CheckBox cbQx = holder.cbQx;
        final Button btnPingjia = holder.btnPingjia;
        final TextView tvMoney = holder.tvMoney;
        final TextView tvNumber = holder.tvNumber;
        final boolean ischecked = result.get(position).ischecked;
        cbQx.setChecked(ischecked);
        cbQx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final boolean checked1 = cbQx.isChecked();
                ischecked(checked1);
            }
        });
        btnPingjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(context, ShowActivity.class);
                context.startActivity(intent);
            }
        });
        final ResultBean resultBean = result.get(position);
        final String categoryName = resultBean.categoryName;
        textName.setText(categoryName);
        final ArrayList<ShoppingCartList> shoppingCartList = resultBean.shoppingCartList;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recycler.setLayoutManager(linearLayoutManager);
        final NeiAdapter neiAdapter = new NeiAdapter(context, shoppingCartList);
        recycler.setAdapter(neiAdapter);
    }

    @Override
    public int getItemCount() {
        return result.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        private CheckBox showCheck;
        private TextView textName;
        private RecyclerView recycler;
        private CheckBox cbQx;
        private TextView tvNumber;
        private TextView tvMoney;
        private Button btnPingjia;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            showCheck = (CheckBox) itemView.findViewById(R.id.show_check);
            textName = (TextView) itemView.findViewById(R.id.text_name);
            recycler = (RecyclerView) itemView.findViewById(R.id.recycler);
            cbQx = (CheckBox) itemView.findViewById(R.id.cb_qx);
            tvNumber = (TextView) itemView.findViewById(R.id.tv_number);
            tvMoney = (TextView) itemView.findViewById(R.id.tv_money);
            btnPingjia = (Button) itemView.findViewById(R.id.btn_pingjia);
        }
    }
}
