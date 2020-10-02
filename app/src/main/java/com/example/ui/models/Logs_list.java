package com.example.ui.models;

import androidx.room.Entity;
import androidx.room.PrimaryKey;




@Entity(tableName = "logtable")
public class Logs_list {
    @PrimaryKey(autoGenerate = true)
    private int id;
    String contactname;
    String sentmsg;
    public String time;


    public Logs_list(String contactname, String sentmsg) {
        this.contactname = contactname;
        this.sentmsg = sentmsg;
    }

    public String getContactname() {
        return contactname;
    }

    public String getSentmsg() {
        return sentmsg;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public void setSentmsg(String sentmsg) {
        this.sentmsg = sentmsg;
    }
}
