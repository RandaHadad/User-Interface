package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Contactlist extends AppCompatActivity {

    Cursor phones;
    ListView lv;
    List<String> cont =new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactlist);

        lv=(ListView)findViewById(R.id.LV);

        Uri uri= ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        phones = getContentResolver().query(uri,null,null,null,null);

        ArrayAdapter<String> data=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cont);
        lv.setAdapter(data);

        getContacts();


    }
    protected void getContacts(){

        while (phones.moveToNext()){
            int phoneIndex=phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
            int nameIndex=phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
            String strPhone=phones.getString(phoneIndex);
            String strName=phones.getString(nameIndex);
            cont.add(strName + ": " + strPhone);
        }

    }
}