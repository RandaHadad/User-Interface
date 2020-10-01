package com.example.ui.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.ui.R;

import java.util.ArrayList;
import java.util.List;

public class Contactlist extends AppCompatActivity {

    Cursor phones;
    ListView lv;
    final int PICK_CONTACT = 1;
    List<String> cont =new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactlist);

        lv = findViewById(R.id.LV);
        Uri uri= ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        phones = getContentResolver().query(uri,null,null,null,null);
        final Intent phonenumber = new Intent(this, MessageEntry.class);

        final ArrayAdapter<String> data=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cont);

        lv.setAdapter(data);

        getContacts();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                 phones.moveToPosition(position);
                 String number = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                 phonenumber.putExtra("phonenum",number);
                 finish();
                 startActivity(phonenumber);
            }
        });

    }

    protected void getContacts(){
        while (phones.moveToNext()){
            int phoneIndex=phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            int nameIndex=phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            String strPhone=phones.getString(phoneIndex);
            String strName=phones.getString(nameIndex);
            cont.add(strName + ":  " + strPhone);
        }
    }



}