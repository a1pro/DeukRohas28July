package com.deukrohas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.deukrohas.R;
import com.deukrohas.interfaces.ItemHistoryClickListener;
import com.deukrohas.retrofitclasses.models.GetAllTaskModel;


import java.util.List;

public class ItemHistoryAdapter extends RecyclerView.Adapter<ItemHistoryAdapter.ViewHolder> {
    private List<GetAllTaskModel.Datum> list;
    private Context context;
    private ItemHistoryClickListener itemHistoryClickListener;
    public ItemHistoryAdapter(List<GetAllTaskModel.Datum> list, Context context,ItemHistoryClickListener itemHistoryClickListener) {
        this.list = list;
        this.itemHistoryClickListener=itemHistoryClickListener;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_history_recycler_layout, null, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        rootView.setLayoutParams(lp);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final GetAllTaskModel.Datum data=list.get(position);
        holder.oderid.setText(data.getOrderId());
        int i=data.getJobStatus();
        if (i==0){
            holder.statusnew.setText("Assigned");
        }else if (i==1){
            holder.statusnew.setText("Ongoing");
        }else if (i==2){
            holder.statusnew.setText("Completed");
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemHistoryClickListener.onClick(data.getJobId());
            }
        });
    }

    @Override
    public int getItemCount() {
        if (list!=null) {
            if (list.size() != 0) {
                return list.size();
            } else {
                return 0;
            }
        }
        else {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView oderid,statusnew;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            oderid=itemView.findViewById(R.id.oderid);
            statusnew=itemView.findViewById(R.id.statusnew);
        }
    }
}
