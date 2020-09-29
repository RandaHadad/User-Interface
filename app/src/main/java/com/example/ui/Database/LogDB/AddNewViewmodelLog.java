package com.example.ui.Database.LogDB;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.ui.models.Logs_list;


public class AddNewViewmodelLog extends AndroidViewModel {
    private LogRepositly repositly;



    public AddNewViewmodelLog(@NonNull Application application) {
        super(application);
        repositly=new LogRepositly(application);
    }

    public void insert(Logs_list logs_list){
        repositly.insert(logs_list);
    }

    public void update(Logs_list logs_list){
        repositly.update(logs_list);
    }


}
