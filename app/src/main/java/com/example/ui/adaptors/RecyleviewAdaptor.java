package com.example.ui.adaptors;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ui.R;
import com.example.ui.models.Logs_list;
import com.example.ui.models.Scheduled_list;

import java.util.List;

public class RecyleviewAdaptor extends RecyclerView.Adapter<RecyleviewAdaptor.MyViewHolder> {

    Context mcontext;
    List<Logs_list> mData;
    Dialog clickmsgdialog;

    public RecyleviewAdaptor(Context mcontext, List<Logs_list> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.logs_item, parent, false);
        final MyViewHolder myholder = new MyViewHolder(v);


        // make dialog to show the massege
        clickmsgdialog = new Dialog(mcontext);
        clickmsgdialog.setContentView(R.layout.onclick_list);




        myholder.singlemsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView dialog_contactname = clickmsgdialog.findViewById(R.id.dialog_contactname);
                TextView dialog_msg = clickmsgdialog.findViewById(R.id.dialog_sentmsg);
                dialog_contactname.setText(mData.get(myholder.getAdapterPosition()).getContactname());
                dialog_msg.setText(mData.get(myholder.getAdapterPosition()).getSentmsg());

                clickmsgdialog.show();
            }
        });


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

    public void setLog(List<Logs_list> words) {
        this.mData=words;
        notifyDataSetChanged();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout singlemsg;
        private TextView vh_name;
        private TextView vh_sentmsg;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            vh_name = itemView.findViewById(R.id.Contact_name);
            vh_sentmsg = itemView.findViewById(R.id.Logs_lastmsg);
            singlemsg = itemView.findViewById(R.id.logitem_layout);
        }
    }

    public Logs_list getInfoIndex(int pos){
        return mData.get(pos);
    }
}
