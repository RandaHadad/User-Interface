package com.example.ui.adaptors;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ui.R;
import com.example.ui.models.Groups_List;

import java.util.List;


public class GroupAdaptor extends RecyclerView.Adapter<GroupAdaptor.MyViewHolder> {
    Context mcontext;
    List<Groups_List> mData;

    public GroupAdaptor(Context mcontext, List<Groups_List> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }

    public GroupAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.logs_item, parent, false);
        final GroupAdaptor.MyViewHolder myholder = new GroupAdaptor.MyViewHolder(v);



        return myholder;

    }

    @Override
    public void onBindViewHolder(@NonNull GroupAdaptor.MyViewHolder holder, int position) {



    }

    @Override
    public int getItemCount() {
        return mData!=null?mData.size():0;
    }

    public void setLog(List<Groups_List> words) {
        this.mData=words;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

        }
    }

    public Groups_List getInfoIndex(int pos){
        return mData.get(pos);
    }
}
