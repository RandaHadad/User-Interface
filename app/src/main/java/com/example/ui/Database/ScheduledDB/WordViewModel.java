package com.example.ui.Database.ScheduledDB;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.ui.Database.ScheduledDB.WordRepositly;
import com.example.ui.models.Scheduled_list;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepositly repositly;
    private LiveData<List<Scheduled_list>> mAllWords;



    public WordViewModel(@NonNull Application application) {
        super(application);
        repositly=new WordRepositly(application);
        mAllWords=repositly.getAllWords();
    }

    public void insert(Scheduled_list scheduledlist){
        repositly.insert(scheduledlist);
    }
    public void delete(Scheduled_list word){
        repositly.delete(word);
    }
    public void update(Scheduled_list scheduledlist){
        repositly.update(scheduledlist);
    }
    public void deletAllWords(){
        repositly.deletAllWord();
    }
    public LiveData<List<Scheduled_list>> getAllWord(){
        return   mAllWords;
    }
}
