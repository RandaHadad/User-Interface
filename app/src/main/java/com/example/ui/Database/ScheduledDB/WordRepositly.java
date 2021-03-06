package com.example.ui.Database.ScheduledDB;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.ui.Database.WordRoomDb;
import com.example.ui.models.Scheduled_list;

import java.util.List;

public class WordRepositly {
    private DaoScheduled mWordActionsondb;
    private LiveData<List<Scheduled_list>> getAllWords;
    public WordRepositly (Application app){
        WordRoomDb db= WordRoomDb.getInstance(app);
        mWordActionsondb =db.dao();
        getAllWords = mWordActionsondb.getWord();


    }
    public void insert (Scheduled_list word){
        new InsertAsynTask(mWordActionsondb).execute(word);

    } public void delete (Scheduled_list word){
        new DeleteAsynTask(mWordActionsondb).execute(word);


    } public void update (Scheduled_list word){
        new UpdateAsynTask(mWordActionsondb).execute(word);


    } public LiveData<List<Scheduled_list>> getAllWords(){
        return getAllWords;

    }
    public void deletAllWord () {
        new DeletAllWordAsynTask(mWordActionsondb).execute();
    }
    private static class InsertAsynTask extends AsyncTask<Scheduled_list,Void,Void>{
        public DaoScheduled mWordDeo;
        public  InsertAsynTask (DaoScheduled wordDeo){
            mWordDeo=wordDeo;
        }
        @Override
        protected Void doInBackground(Scheduled_list... words) {
            mWordDeo.insert(words[0]);
            return null;
        }
    }
    private static class DeleteAsynTask extends AsyncTask<Scheduled_list,Void,Void>{
        public DaoScheduled mWordDeo;
        public  DeleteAsynTask (DaoScheduled wordDeo){
            mWordDeo=wordDeo;
        }
        @Override
        protected Void doInBackground(Scheduled_list... words) {
            mWordDeo.delete(words[0]);
            return null;
        }
    }
    private static class UpdateAsynTask extends AsyncTask<Scheduled_list,Void,Void>{
        public DaoScheduled mWordDeo;
        public  UpdateAsynTask (DaoScheduled wordDeo){
            mWordDeo=wordDeo;
        }
        @Override
        protected Void doInBackground(Scheduled_list... words) {
            mWordDeo.update(words[0]);
            return null;
        }
    }
    private static class DeletAllWordAsynTask extends AsyncTask<Void,Void,Void>{
        public DaoScheduled mWordDeo;
        public  DeletAllWordAsynTask (DaoScheduled wordDeo){
            mWordDeo=wordDeo;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mWordDeo.deleteAllWord();
            return null;
        }
    }


}
