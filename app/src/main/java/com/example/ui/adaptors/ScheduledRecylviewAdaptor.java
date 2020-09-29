package com.example.ui.adaptors;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ui.MessageEntry;
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
        final ScheduledRecylviewAdaptor.MyViewHolder myholder = new ScheduledRecylviewAdaptor.MyViewHolder(v);

        myholder.singlemsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(mcontext,MessageEntry.class);
                intent.putExtra(MessageEntry.EXTRA_ID, mData.get(myholder.getAdapterPosition()).getId());
                intent.putExtra(MessageEntry.EXTRA_TITLE, mData.get(myholder.getAdapterPosition()).getContactname());
                intent.putExtra(MessageEntry.EXTRA_DATE, mData.get(myholder.getAdapterPosition()).gettime());
                intent.putExtra(MessageEntry.EXTRA_MESSAGE,mData.get(myholder.getAdapterPosition()).getmsg());

                mcontext.startActivity(intent);
            }
        } );

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
        return mData!=null?mData.size():0;
    }
    public void setWord(List<Scheduled_list> list) {
        this.mData=list;
        notifyDataSetChanged();
    }

    public class  MyViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout singlemsg;
        private TextView vh_name;
        private TextView vh_msg;
        private TextView vh_date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            vh_name= itemView.findViewById(R.id.Schedule_contactnameid);
            vh_msg = itemView.findViewById(R.id.Schedule_massegeid);
            vh_date = itemView.findViewById(R.id.Schedule_dateid);
            singlemsg= itemView.findViewById(R.id.scheduled_item);

        }
    }

    public Scheduled_list getInfoIndex(int pos){
        return mData.get(pos);
    }
}