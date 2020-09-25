package com.example.ui.models;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Messagetable")
public class Scheduled_list {
    @PrimaryKey(autoGenerate = true)
    private int id;
    String contactname;
    public String msg;
    public String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Scheduled_list(String contactname, String msg, String time) {
        this.time = time;
        this.contactname = contactname;
        this.msg = msg;
    }

    public String gettime() {
        return time;
    }

    public String getContactname() {
        return contactname;
    }

    public String getmsg() {
        return msg;
    }


}