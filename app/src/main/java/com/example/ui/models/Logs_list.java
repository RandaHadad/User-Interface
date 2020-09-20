package com.example.ui.models;

public class Logs_list {
    String contactname;
    String sentmsg;

    public Logs_list(){}
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

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public void setSentmsg(String sentmsg) {
        this.sentmsg = sentmsg;
    }
}
