package com.example.ui.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ui.Database.Groupdb.GroupViewModel;
import com.example.ui.Database.LogDB.LogViewModel;
import com.example.ui.R;
import com.example.ui.models.Groups_List;
import com.example.ui.models.Logs_list;

import java.util.List;

public class GroupsActivity extends AppCompatActivity {

    private MenuItem item;
    private GroupViewModel groupViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);

        groupViewModel = ViewModelProviders.of(this).get(GroupViewModel.class);
        groupViewModel.getmAllGroups().observe(this, new Observer<List<Groups_List>>() {
            @Override
            public void onChanged(List<Groups_List> lists) {
                //update ui
                //setLog(lists);
                //-+Toast.makeText(MainActivity.this, "saved", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.groups_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        this.item = item;
        switch (item.getItemId()){
            case R.id.newgroup:
                //TODO create new group
                Intent intent = new Intent(GroupsActivity.this,ContactsContract.class);


                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}
