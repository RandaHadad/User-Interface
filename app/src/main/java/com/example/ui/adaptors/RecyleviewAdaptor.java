package com.example.ui.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ui.R;
import com.example.ui.models.Logs_list;

import java.util.List;

public class RecyleviewAdaptor extends RecyclerView.Adapter<RecyleviewAdaptor.MyViewHolder> {

    Context mcontext;
    List<Logs_list> mData;

    public RecyleviewAdaptor(Context mcontext, List<Logs_list> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.logs_item, parent, false);
        MyViewHolder myholder = new MyViewHolder(v);
        return myholder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.vh_name.setText(mData.get(position).getContactname());
        holder.vh_sentmsg.setText(mData.get(position).getSentmsg());

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static  class  MyViewHolder extends RecyclerView.ViewHolder{
      private   TextView vh_name;
      private TextView vh_sentmsg;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            vh_name= itemView.findViewById(R.id.Contact_name);
            vh_sentmsg = itemView.findViewById(R.id.Logs_lastmsg);
        }
    }
}
