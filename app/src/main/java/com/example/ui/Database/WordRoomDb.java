package com.example.ui.Database;

import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.example.ui.Database.LogDB.DaoLog;
import com.example.ui.Database.ScheduledDB.DaoScheduled;
import com.example.ui.models.Logs_list;
import com.example.ui.models.Scheduled_list;

@Database(entities = {Scheduled_list.class, Logs_list.class}, version = 4)
public abstract class WordRoomDb extends RoomDatabase {
    private static WordRoomDb instance;

    public abstract DaoScheduled dao();
    public abstract DaoLog daoLog();

    public static synchronized WordRoomDb getInstance(Context context){
        if (instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),WordRoomDb.class,"word-database").fallbackToDestructiveMigration()
                    .addCallback(roomCallBack).build();

        }
        return instance;
    }
    private static RoomDatabase.Callback roomCallBack=new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDataAsyntask(instance).execute( );

        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };
    private static class PopulateDataAsyntask extends AsyncTask<Void ,Void,Void>{
        private DaoScheduled mWordActionsondb;
        private DaoLog mLogActiondb;
        PopulateDataAsyntask(WordRoomDb db){
            mWordActionsondb =db.dao();
            mLogActiondb=db.daoLog();
        }
        @Override
        protected Void doInBackground(Void... voids) {

            return null;
        }

     /*   private String getData() {
            Date date=new Date();
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/mm/yyyy hh:mm:ss a");
            return simpleDateFormat.format(date);
        }*/
    }

}
