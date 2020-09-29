package com.example.ui.Database.LogDB;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.ui.models.Logs_list;

import java.util.List;

@androidx.room.Dao
public interface DaoLog {
    @Insert
    void insert(Logs_list word);

    @Update
    void  update(Logs_list word);
    @Delete
    void  delete(Logs_list word);

    @Query("DELETE FROM logtable")
    void  deleteAllWord();

    @Query("SELECT * FROM logtable")
    LiveData<List<Logs_list>> getAllLogs();

}
