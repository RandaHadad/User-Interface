package com.example.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
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

import com.example.ui.Database.LogDB.AddNewViewmodelLog;
import com.example.ui.Database.ScheduledDB.AddNewViewmodel;
import com.example.ui.models.Scheduled_list;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


import java.util.Calendar;


public class MessageEntry extends AppCompatActivity implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener{
    TextView date;
    TextView newmsg;
    TextView contactname;

    private int mID;
    private AddNewViewmodel addNewViewmodel;
    private AddNewViewmodelLog addNewViewmodelLog;
    private boolean editMode;

    private final int notificationid = 1;
    private final int sendmsgid = 2;


    public static final String EXTRA_ID="com.example.myapp.extraid";
    public static final String EXTRA_TITLE="com.example.myapp.title";
    public static final String EXTRA_MESSAGE="com.example.myapp.message";
    public static final String EXTRA_DATE="com.example.myapp.date";

    FloatingActionButton calender;
    FloatingActionButton groups;
    Calendar c ;

    int day, month, year, hour, minute;
    int myday, myMonth, myYear, myHour, myMinute;
    long alarmstart;
    private MenuItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_entry);

        groups=findViewById(R.id.groups);
        calender = findViewById(R.id.calender);
        date = findViewById(R.id.date);
        newmsg= findViewById(R.id.massege);
        contactname = findViewById(R.id.contact_msgentry);

        // groups button
//        groups.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent myIntent = new Intent(MessageEntry.this, GroupsActivity.class);
//                startActivityForResult(myIntent,1);
//            }
//        });

        addNewViewmodel= ViewModelProviders.of(this).get( AddNewViewmodel.class );
        setTitle("Add New Data");


        // update && insert
        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_ID)){
            //update
            setTitle("Edit massege");
            editMode=true;
            mID=intent.getIntExtra(EXTRA_ID,-1);

            contactname.setText(intent.getStringExtra(EXTRA_TITLE));
            newmsg.setText(intent.getStringExtra(EXTRA_MESSAGE));
            date.setText(intent.getStringExtra(EXTRA_DATE));

        }else {
            //insert
            setTitle("Add new massege");
            editMode=false;

        }


        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(MessageEntry.this, MessageEntry.this,year, month,day);
                datePickerDialog.show();
            }
        });


    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        myYear = year;
        myday = dayOfMonth;
        myMonth = month;
        hour = c.get(Calendar.HOUR);
        minute = c.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(MessageEntry.this,
                MessageEntry.this,
                hour,
                minute,
                DateFormat.is24HourFormat(this));
        timePickerDialog.show();
    }
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        myHour = hourOfDay;
        myMinute = minute;
        c.set(myYear,myMonth,myday,myHour,myMinute);
        alarmstart = c.getTimeInMillis();
        date.setText( myday + "/" + myMonth + 1 + "/" + myYear + " " + myHour + ":" + myMinute);
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
                saveMassege();
                setAlarm();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    private void saveMassege() {
        String w=contactname.getText().toString().trim();
        String w1=newmsg.getText().toString().trim();
        String w2=date.getText().toString().trim();

        //save it in to db
        Scheduled_list inf=new Scheduled_list(w,w1,w2);
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

    public void  setAlarm(){
        //make alarm
        Intent intent = new Intent(MessageEntry.this,AlarmReciever.class);
        intent.putExtra("notificationid",notificationid);
        intent.putExtra("massege",newmsg.getText().toString());
        intent.putExtra("phone",contactname.getText().toString());

        final PendingIntent pendingIntent = PendingIntent.getBroadcast(MessageEntry.this,mID,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        final AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,alarmstart,pendingIntent);

    }

}

