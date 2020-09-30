package com.example.ui.models;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Messagetable")
public class Scheduled_list {
    @PrimaryKey(autoGenerate = true)
    private int id;
    String contactname;
     String msg;
     String time;
     long milli;

    public Scheduled_list(String contactname, String msg, String time , long milli) {
        this.contactname = contactname;
        this.msg = msg;
        this.time = time;

        this.milli = milli;
    }


    public void setId(int id) {
        this.id = id;
    }
    public void setMilli(long milli) {
        this.milli = milli;
    }
    public void setContactname(String contactname) {
        this.contactname = contactname;
    }



    public void setMsg(String msg) {
        this.msg = msg;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public long getMilli() {
        return milli;
    }
    public int getId() {
        return id;
    }
    public String getTime() {
        return time;
    }
    public String getMsg() {
        return msg;
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

    @Override
    public String toString() {
        return getContactname() + " " + getmsg()  + " " + getTime();
    }


}