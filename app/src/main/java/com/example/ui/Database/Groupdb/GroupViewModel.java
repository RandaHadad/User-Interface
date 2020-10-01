package com.example.ui.Database.Groupdb;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.ui.models.Groups_List;

import java.util.List;

public class GroupViewModel extends AndroidViewModel {
    private GroupRepositly groupRepositly;
    private LiveData<List<Groups_List>> mAllGroups;


    public GroupViewModel(@NonNull Application application) {
        super(application);
        groupRepositly = new GroupRepositly(application);
        mAllGroups = groupRepositly.GetAllGroups();
    }


    public void insert(Groups_List groups_list) {
        groupRepositly.insert(groups_list);
    }

    public void delete(Groups_List groups_list) {
        groupRepositly.delete(groups_list);
    }

    public void update(Groups_List groups_list) {
        groupRepositly.update(groups_list);
    }

    public void deletAllWords() {
        groupRepositly.deletAllGroup();
    }

    public LiveData<List<Groups_List>> getmAllGroups() {
        return mAllGroups;
    }
}
