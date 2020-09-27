package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;


import com.example.ui.Fragments.Scheduled;
import com.example.ui.Fragments.logs;
import com.example.ui.adaptors.ViewpageAdaptor;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton newmsg ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newmsg = findViewById(R.id.msg);

        ViewpageAdaptor viewpageAdaptor = new ViewpageAdaptor( getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabs = findViewById(R.id.tabs);
        
        
        if (checkPermission(Manifest.permission.SEND_SMS)){}
        else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.SEND_SMS},2);
        }

        //add fragment
        viewpageAdaptor.addfragment(new logs(),"Sent");
        viewpageAdaptor.addfragment(new Scheduled(),"Scheduled");

        viewPager.setAdapter(viewpageAdaptor);
        tabs.setupWithViewPager(viewPager);

        newmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this, MessageEntry.class);
                startActivityForResult(myIntent,1);
            }
        });
    }

    private boolean checkPermission(String sendSms) {
        int check = ContextCompat.checkSelfPermission(this, sendSms);
        return (check== PackageManager.PERMISSION_GRANTED);
    }

}