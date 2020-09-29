package com.example.ui.Database.LogDB;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.ui.Database.WordRoomDb;
import com.example.ui.models.Logs_list;

import java.util.List;


public class LogRepositly {
    private DaoLog mWordDaoLog;
    private LiveData<List<Logs_list>> getAllLogs;
    public LogRepositly(Application app){
        WordRoomDb db= WordRoomDb.getInstance(app);
        mWordDaoLog =db.daoLog();
        getAllLogs = mWordDaoLog.getAllLogs();


    }
    public void insert (Logs_list logs_lists){
        new InsertAsynTask(mWordDaoLog).execute(logs_lists);

    } public void delete (Logs_list logs_lists){
        new DeleteAsynTask(mWordDaoLog).execute(logs_lists);


    } public void update (Logs_list logs_lists){
        new UpdateAsynTask(mWordDaoLog).execute(logs_lists);


    } public LiveData<List<Logs_list>> GetAllLogss(){
        return getAllLogs;

    }
    public void deletAllWord () {
        new DeletAllWordAsynTask(mWordDaoLog).execute();
    }
    private static class InsertAsynTask extends AsyncTask<Logs_list, Void, Void> {
        public DaoLog mWordDeo;
        public  InsertAsynTask (DaoLog wordDeo){
            mWordDeo=wordDeo;
        }
        @Override
        protected Void doInBackground(Logs_list... words) {
            mWordDeo.insert(words[0]);
            return null;
        }
    }
    private static class DeleteAsynTask extends AsyncTask<Logs_list, Void, Void> {
        public DaoLog mWordDeo;
        public  DeleteAsynTask (DaoLog wordDeo){
            mWordDeo=wordDeo;
        }
        @Override
        protected Void doInBackground(Logs_list... words) {
            mWordDeo.delete(words[0]);
            return null;
        }
    }
    private static class UpdateAsynTask extends AsyncTask<Logs_list, Void, Void> {
        public DaoLog mWordDeo;
        public  UpdateAsynTask (DaoLog wordDeo){
            mWordDeo=wordDeo;
        }
        @Override
        protected Void doInBackground(Logs_list... words) {
            mWordDeo.update(words[0]);
            return null;
        }
    }
    private static class DeletAllWordAsynTask extends AsyncTask<Void, Void, Void> {
        public DaoLog mWordDeo;
        public  DeletAllWordAsynTask (DaoLog wordDeo){
            mWordDeo=wordDeo;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mWordDeo.deleteAllWord();
            return null;
        }
    }


}
