package com.example.ui.Fragments;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.ui.AlarmReciever;
import com.example.ui.Database.ScheduledDB.WordViewModel;
import com.example.ui.R;
import com.example.ui.adaptors.ScheduledRecylviewAdaptor;
import com.example.ui.models.Scheduled_list;
import java.util.List;

public class Scheduled extends Fragment {
    private WordViewModel wordViewModel;
    RecyclerView myrecycleview;
    List<Scheduled_list> ScheduledLists;
    ScheduledRecylviewAdaptor adaptor;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //viewmodel
        wordViewModel= ViewModelProviders.of(this).get(WordViewModel.class);
        wordViewModel.getAllWord().observe(this, new Observer<List<Scheduled_list>>() {
            @Override
            public void onChanged(List<Scheduled_list> words) {
                //update ui
                adaptor.setWord(words);
                //-+Toast.makeText(MainActivity.this, "saved", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_scheduled, container, false);

        //recyclerview
        myrecycleview = v.findViewById(R.id.scheduled_recyclerlist);
        myrecycleview.setHasFixedSize(true);
        adaptor = new ScheduledRecylviewAdaptor(getContext(),ScheduledLists);
        myrecycleview .setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecycleview.setAdapter(adaptor);




        //deleted
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                //delete item from db
                int adapterPosition = viewHolder.getAdapterPosition();
                wordViewModel.delete(adaptor.getInfoIndex(adapterPosition));

                //delete alarm to send msg
                Intent intent = new Intent(getActivity(), AlarmReciever.class);
                final PendingIntent pendingIntent = PendingIntent.getBroadcast(getActivity(),0,intent,PendingIntent.FLAG_CANCEL_CURRENT);
                final AlarmManager alarmManager = (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
                alarmManager.cancel(pendingIntent);
                pendingIntent.cancel();
                Toast.makeText(getContext() ,"canceled",Toast.LENGTH_SHORT).show();

            }
        }).attachToRecyclerView(myrecycleview);


        return v ;
    }
}