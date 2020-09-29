package com.example.ui.Fragments;

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

import com.example.ui.Database.LogDB.LogViewModel;
import com.example.ui.Database.ScheduledDB.WordViewModel;
import com.example.ui.R;
import com.example.ui.adaptors.RecyleviewAdaptor;
import com.example.ui.models.Logs_list;

import java.util.ArrayList;
import java.util.List;

public class logs extends Fragment {
    private LogViewModel logViewModel;
    RecyclerView myrecycleview;
    RecyleviewAdaptor adaptor;
    List<Logs_list> logsLists;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //make a new list of logs here

        //Start of tests
        logsLists= new ArrayList<>();
        logsLists.add(new Logs_list("randa","hi there"));
        logsLists.add(new Logs_list("randa","hi there"));
        logsLists.add(new Logs_list("randa","hi there"));
        //end of tests
        logViewModel= ViewModelProviders.of(this).get(LogViewModel.class);
        logViewModel.getAllWord().observe(this, new Observer<List<Logs_list>>() {
            @Override
            public void onChanged(List<Logs_list> lists) {
                //update ui
                adaptor.setLog(lists);
                //-+Toast.makeText(MainActivity.this, "saved", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_logs, container, false);

        myrecycleview = v.findViewById(R.id.logs_recyclerlist);
        adaptor = new RecyleviewAdaptor(getContext(),logsLists);
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
                //delete item
                int adapterPosition = viewHolder.getAdapterPosition();
                logViewModel.delete(adaptor.getInfoIndex(adapterPosition));
            }
        }).attachToRecyclerView(myrecycleview);

        return v ;
    }
}