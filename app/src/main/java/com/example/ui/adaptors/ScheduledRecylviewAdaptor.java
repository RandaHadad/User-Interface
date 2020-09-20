package com.example.ui.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ui.R;
import com.example.ui.models.Scheduled_list;

import java.util.List;

public class ScheduledRecylviewAdaptor extends RecyclerView.Adapter<ScheduledRecylviewAdaptor.MyViewHolder> {

    Context mcontext;
    List<Scheduled_list> mData;

    public ScheduledRecylviewAdaptor(Context mcontext, List<Scheduled_list> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }

    public ScheduledRecylviewAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.scheduled_item, parent, false);
        ScheduledRecylviewAdaptor.MyViewHolder myholder = new ScheduledRecylviewAdaptor.MyViewHolder(v);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ScheduledRecylviewAdaptor.MyViewHolder holder, int position) {
        holder.vh_name.setText(mData.get(position).getContactname());
        holder.vh_msg.setText(mData.get(position).getmsg());
        holder.vh_date.setText(mData.get(position).gettime());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static  class  MyViewHolder extends RecyclerView.ViewHolder{
        private TextView vh_name;
        private TextView vh_msg;
        private TextView vh_date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            vh_name= itemView.findViewById(R.id.Contact_name);
            vh_msg = itemView.findViewById(R.id.Logs_lastmsg);
            vh_date = itemView.findViewById(R.id.time);
        }
    }
}