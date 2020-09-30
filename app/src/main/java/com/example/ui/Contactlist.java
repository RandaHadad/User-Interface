package com.example.ui;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
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

        lv = findViewById(R.id.LV);
        Uri uri= ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        phones = getContentResolver().query(uri,null,null,null,null);

        final ArrayAdapter<String> data=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,cont);
        final Intent iCont =new Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
        lv.setAdapter(data);

        getContacts();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivityForResult(iCont,1);
            }
        });


    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Uri uri= data.getData();
        Cursor cursor = getContentResolver().query(uri,null ,null,null,null);
        cursor.moveToFirst();

        int phoneindex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
        String strNumber= cursor.getString(phoneindex);
        data.putExtra("phonenumber",strNumber);
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