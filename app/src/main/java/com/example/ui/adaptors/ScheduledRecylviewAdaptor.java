package com.example.ui.adaptors;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ui.R;
import com.example.ui.models.Scheduled_list;
import java.util.List;

public class ScheduledRecylviewAdaptor extends RecyclerView.Adapter<ScheduledRecylviewAdaptor.MyViewHolder> {

    Context mcontext;
    List<Scheduled_list> mData;
    Dialog clickmsgdialog;

    public ScheduledRecylviewAdaptor(Context mcontext, List<Scheduled_list> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }

    public ScheduledRecylviewAdaptor.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mcontext).inflate(R.layout.scheduled_item, parent, false);
        ScheduledRecylviewAdaptor.MyViewHolder myholder = new ScheduledRecylviewAdaptor.MyViewHolder(v);

        clickmsgdialog = new Dialog(mcontext);
        clickmsgdialog.setContentView(R.layout.activity_message_entry);

        myholder.vh_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TextView dialog_contactname = clickmsgdialog.findViewById(R.id.dialog_contactname);
               // TextView dialog_msg = clickmsgdialog.findViewById(R.id.dialog_sentmsg);
                clickmsgdialog.getWindow().setLayout(900 ,1500);
                clickmsgdialog.show();
            }
        });

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
        private ImageButton vh_edit;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            vh_name= itemView.findViewById(R.id.Contact_name);
            vh_msg = itemView.findViewById(R.id.Logs_lastmsg);
            vh_date = itemView.findViewById(R.id.time);
           vh_edit= itemView.findViewById(R.id.edit_msg);
        }
    }
}