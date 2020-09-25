package com.example.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.ui.Database.models.AddNewViewmodel;
import com.example.ui.models.Scheduled_list;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MessageEntry extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{
    TextView date;
    TextView newmsg;
    TextView contactname;

    private int mID;
    private AddNewViewmodel addNewViewmodel;
    private boolean editMode;

    public static final String EXTRA_ID="com.example.myapp.extraid";
    public static final String EXTRA_TITLE="com.example.myapp.title";
    public static final String EXTRA_MESSAGE="com.example.myapp.message";

    FloatingActionButton calender;

    int day, month, year, hour, minute;
    int myday, myMonth, myYear, myHour, myMinute;
    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_entry);

        calender = findViewById(R.id.calender);
        date = findViewById(R.id.date);
        newmsg= findViewById(R.id.massege);
        contactname = findViewById(R.id.contact_msgentry);


        addNewViewmodel= ViewModelProviders.of(this).get( AddNewViewmodel.class );
        setTitle("Add New Data");


        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MessageEntry.this, MessageEntry.this,year, month,day);
                datePickerDialog.show();
            }
        });

        // update && insert
        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_ID)){
            //update
            setTitle("Edit Word");
            editMode=true;
            mID=intent.getIntExtra(EXTRA_ID,-1);

            contactname.setText(intent.getStringExtra(EXTRA_TITLE));
            newmsg.setText(intent.getStringExtra(EXTRA_MESSAGE));

        }else {
            //insert
            setTitle("Add new word");
            editMode=false;

        }


    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        myYear = year;
        myday = day;
        myMonth = month;
        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(MessageEntry.this, MessageEntry.this, hour, minute, DateFormat.is24HourFormat(this));
        timePickerDialog.show();
    }
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        myHour = hourOfDay;
        myMinute = minute;
        date.setText( myYear + "/" + myMonth + "/" + myday + " " + myHour + ":" + myMinute);
    }
    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        this.item = item;
        switch (item.getItemId()){
            case R.id.itemsave:
                //savedate
                saveWord();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void saveWord() {
        String w=contactname.getText().toString().trim();
        String w1=newmsg.getText().toString().trim();
        String w2=date.getText().toString().trim();

        Scheduled_list inf=new Scheduled_list(w,w2,w1);
        if (w.isEmpty() || w1.isEmpty() || w2.isEmpty() ){
            Toast.makeText(this, "Enter data", Toast.LENGTH_SHORT).show();
            return;
        }
        if (editMode){
            inf.setId(mID);
            addNewViewmodel.update(inf);
        }else {
            addNewViewmodel.insert(inf);

        }
        finish();
    }

}

