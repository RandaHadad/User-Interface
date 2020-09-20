package com.example.ui.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ui.R;
import com.example.ui.adaptors.RecyleviewAdaptor;
import com.example.ui.models.Logs_list;

import java.util.List;

public class logs extends Fragment {

    RecyclerView myrecycleview;
    List<Logs_list> logsLists;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //make a new list of logs here
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_logs, container, false);
        myrecycleview = v.findViewById(R.id.logs_recyclerlist);
        RecyleviewAdaptor adaptor = new RecyleviewAdaptor(getContext(),logsLists);
        //donot know this code have to search for it
        myrecycleview .setLayoutManager(new LinearLayoutManager(getActivity()));
        myrecycleview.setAdapter(adaptor);

        return v ;
    }
}