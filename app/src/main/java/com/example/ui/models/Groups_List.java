package com.example.ui.models;

import androidx.room.PrimaryKey;

import java.util.List;

public class Groups_List {
    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    List<String> numbers;

    public Groups_List(String name, List<String> numbers) {
        this.name = name;
        this.numbers = numbers;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<String> getNumbers() {
        return numbers;
    }
    public String getName() {
        return name;
    }
}
