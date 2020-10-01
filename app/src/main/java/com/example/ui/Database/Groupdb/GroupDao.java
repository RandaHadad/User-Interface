//package com.example.ui.Database.Groupdb;
//
//import androidx.lifecycle.LiveData;
//import androidx.room.Delete;
//import androidx.room.Insert;
//import androidx.room.Query;
//import androidx.room.Update;
//
//import com.example.ui.models.Groups_List;
//
//import java.util.List;
//@androidx.room.Dao
//
//public interface GroupDao {
//    @Insert
//    void insert(Groups_List groups_list);
//
//    @Update
//    void  update(Groups_List groups_list);
//
//    @Delete
//    void  delete(Groups_List groups_list);
//
//    @Query("DELETE FROM grouptable")
//    void  deleteAllGroup();
//
//    @Query("SELECT * FROM grouptable")
//    LiveData<List<Groups_List>> getAllGroup();
//}
