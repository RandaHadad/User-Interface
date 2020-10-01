//package com.example.ui.Activity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.provider.ContactsContract;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.ui.R;
//
//public class GroupsActivity extends AppCompatActivity {
//
//    private MenuItem item;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_groups);
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.groups_menu,menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        this.item = item;
//        switch (item.getItemId()){
//            case R.id.newgroup:
//                //TODO create new group
//                Intent intent = new Intent(GroupsActivity.this,ContactsContract.class);
//
//
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//
//        }
//    }
//
//}
