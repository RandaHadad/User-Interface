package com.example.ui.Database.Groupdb;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.ui.models.Groups_List;

public class AddNewViewGroup extends AndroidViewModel {

    private GroupRepositly groupRepositly;

    public AddNewViewGroup(@NonNull Application application) {
        super(application);
        groupRepositly = new GroupRepositly(application);
    }

    public void insert(Groups_List groups_list){
        groupRepositly.insert(groups_list);
    }

    public void update(Groups_List groups_list){
        groupRepositly.update(groups_list);
    }

}
