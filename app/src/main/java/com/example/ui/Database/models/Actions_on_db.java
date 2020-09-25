package com.example.ui.Database.models;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ui.models.Scheduled_list;

import java.util.List;

@androidx.room.Dao
public interface Actions_on_db {

        @Insert
        void insert(Scheduled_list word);

        @Update
        void  update(Scheduled_list word);
        @Delete
        void  delete(Scheduled_list word);

        @Query("DELETE FROM Messagetable")
        void  deleteAllWord();

        @Query("SELECT * FROM Messagetable")
        LiveData<List<Scheduled_list>> getWord();

    }

