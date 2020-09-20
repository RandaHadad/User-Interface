package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.ui.Fragments.Scheduled;
import com.example.ui.Fragments.logs;
import com.example.ui.adaptors.ViewpageAdaptor;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewpageAdaptor viewpageAdaptor = new ViewpageAdaptor( getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        TabLayout tabs = findViewById(R.id.tabs);

        //add fragment
        viewpageAdaptor.addfragment(new logs(),"Sent");
        viewpageAdaptor.addfragment(new Scheduled(),"Scheduled");

        viewPager.setAdapter(viewpageAdaptor);
        tabs.setupWithViewPager(viewPager);
    }

}