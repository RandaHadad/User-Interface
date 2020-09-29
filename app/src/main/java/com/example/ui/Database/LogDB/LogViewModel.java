package com.example.ui.Database.LogDB;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.ui.models.Logs_list;

import java.util.List;

public class LogViewModel extends AndroidViewModel {
    private LogRepositly logRepositly;
    private LiveData<List<Logs_list>> mAllLogs;



    public LogViewModel(@NonNull Application application) {
        super(application);
        logRepositly=new LogRepositly(application);
        mAllLogs=logRepositly.GetAllLogss();
    }

    public void insert(Logs_list logs_lists){
        logRepositly.insert(logs_lists);
    }
    public void delete(Logs_list logs_lists){
        logRepositly.delete(logs_lists);
    }
    public void update(Logs_list logs_lists){
        logRepositly.update(logs_lists);
    }
    public void deletAllWords(){
        logRepositly.deletAllWord();
    }
    public LiveData<List<Logs_list>> getAllWord(){
        return   mAllLogs;
    }
}
