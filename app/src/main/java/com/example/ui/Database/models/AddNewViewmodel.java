package com.example.ui.Database.models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.ui.models.Scheduled_list;

public class AddNewViewmodel extends AndroidViewModel {
    private WordRepositly repositly;



    public AddNewViewmodel(@NonNull Application application) {
        super(application);
        repositly=new WordRepositly(application);
    }

    public void insert(Scheduled_list scheduledlist){
        repositly.insert(scheduledlist);
    }

    public void update(Scheduled_list scheduledlist){
        repositly.update(scheduledlist);
    }


}
