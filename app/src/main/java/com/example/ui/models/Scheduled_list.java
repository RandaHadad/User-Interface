package com.example.ui.models;

public class Scheduled_list {
    String contactname;
    String msg;
    String time;

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

    public void settime(String time) {
        this.time = time;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public void setmsg(String msg) {
        this.msg = msg;
    }

}