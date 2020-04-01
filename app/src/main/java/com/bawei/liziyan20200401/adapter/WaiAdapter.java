package com.bawei.liziyan20200401.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.liziyan20200401.R;
import com.bawei.liziyan20200401.bean.DetailList;
import com.bawei.liziyan20200401.bean.OrderList;

import java.util.ArrayList;

public class WaiAdapter extends RecyclerView.Adapter<WaiAdapter.MyViewHolder> {
    public Context context;
    public ArrayList<OrderList> orderList;


    public WaiAdapter(Context context, ArrayList<OrderList> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View inflate = LayoutInflater.from(context).inflate(R.layout.wai_adapter, parent, false);
        return new MyViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final TextView waiExpressCompName = holder.waiExpressCompName;
        final TextView waiOrderId = holder.waiOrderId;
        final RecyclerView neiRecycler = holder.neiRecycler;
        final OrderList orderList = this.orderList.get(position);
        final String orderId = orderList.orderId;
        final Button btnCancel = holder.btnCancel;
        final Button btnQuerren = holder.btnQuerren;
        final String expressCompName = orderList.expressCompName;
        waiExpressCompName.setText("快递:" + expressCompName);
        waiOrderId.setText("订单号:" + orderId);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        neiRecycler.setLayoutManager(linearLayoutManager);
        final ArrayList<DetailList> detailList = orderList.detailList;
        final LiAdapter liAdapter = new LiAdapter(context, detailList);
        neiRecycler.setAdapter(liAdapter);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "取消订单", Toast.LENGTH_SHORT).show();
                return;
            }
        });
        btnQuerren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView waiOrderId;
        private TextView waiExpressCompName;
        private RecyclerView neiRecycler;
        private Button btnCancel;
        private Button btnQuerren;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            waiOrderId = (TextView) itemView.findViewById(R.id.wai_orderId);
            waiExpressCompName = (TextView) itemView.findViewById(R.id.wai_expressCompName);
            neiRecycler = (RecyclerView) itemView.findViewById(R.id.nei_recycler);
            btnCancel = (Button) itemView.findViewById(R.id.btn_cancel);
            btnQuerren = (Button) itemView.findViewById(R.id.btn_querren);
        }
    }
}
