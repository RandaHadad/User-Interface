package com.example.ui.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ui.R;
import com.example.ui.adaptors.ScheduledRecylviewAdaptor;
import com.example.ui.models.Scheduled_list;

import java.util.ArrayList;
import java.util.List;

public class Scheduled extends Fragment {

    RecyclerView myrecycleview;
    List<Scheduled_list> ScheduledLists;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Start of tests
            ScheduledLists= new ArrayList<>();
            ScheduledLists.add(new Scheduled_list("randa","bbrtegkk","889"));
            ScheduledLists.add(new Scheduled_list("randa","bbgkrtek","889"));
        //end of tests

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_scheduled, container, false);
        myrecycleview = v.findViewById(R.id.scheduled_recyclerlist);
        ScheduledRecylviewAdaptor adaptor = new ScheduledRecylviewAdaptor(getContext(),ScheduledLists);
        //donot know this code have to search for it
        myrecycleview .setLayoutManager(new LinearLayoutManager(getActivity()));

        myrecycleview.setAdapter(adaptor);
        return v ;
    }
}