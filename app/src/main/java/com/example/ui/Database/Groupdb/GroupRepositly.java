//package com.example.ui.Database.Groupdb;
//
//import android.app.Application;
//import android.os.AsyncTask;
//
//import androidx.lifecycle.LiveData;
//
//import com.example.ui.Database.WordRoomDb;
//import com.example.ui.models.Groups_List;
//
//import java.util.List;
//
//public class GroupRepositly {
//    private GroupDao mGroupDaoLog;
//    private LiveData<List<Groups_List>> getAllGroup;
//    public GroupRepositly(Application app){
//        WordRoomDb db= WordRoomDb.getInstance(app);
//        mGroupDaoLog =db.groupDao();
//        getAllGroup = mGroupDaoLog.getAllGroup();
//    }
//    public void insert (Groups_List groups_list){
//        new GroupRepositly.InsertAsynTask(mGroupDaoLog).execute(groups_list);
//    }
//    public void delete (Groups_List groups_list){
//        new GroupRepositly.DeleteAsynTask(mGroupDaoLog).execute(groups_list);
//    }
//    public void update (Groups_List groups_list){
//        new GroupRepositly.UpdateAsynTask(mGroupDaoLog).execute(groups_list);
//    }
//    public LiveData<List<Groups_List>> GetAllGroups(){
//        return getAllGroup;
//    }
//    public void deletAllGroup () {
//        new GroupRepositly.DeletAllWordAsynTask(mGroupDaoLog).execute();
//    }
//    private static class InsertAsynTask extends AsyncTask<Groups_List, Void, Void> {
//        public GroupDao mGroupDeo;
//        public  InsertAsynTask (GroupDao groupDao){
//            mGroupDeo=groupDao;
//        }
//        @Override
//        protected Void doInBackground(Groups_List... groups_lists) {
//            mGroupDeo.insert(groups_lists[0]);
//            return null;
//        }
//    }
//    private static class DeleteAsynTask extends AsyncTask<Groups_List, Void, Void> {
//        public GroupDao mGroupDao;
//        public  DeleteAsynTask (GroupDao groupDao){
//            mGroupDao=groupDao;
//        }
//        @Override
//        protected Void doInBackground(Groups_List... groups_lists) {
//            mGroupDao.delete(groups_lists[0]);
//            return null;
//        }
//    }
//    private static class UpdateAsynTask extends AsyncTask<Groups_List, Void, Void> {
//        public GroupDao mGroupDao;
//        public  UpdateAsynTask (GroupDao groupDao){
//            mGroupDao=groupDao;
//        }
//        @Override
//        protected Void doInBackground(Groups_List... groups_lists) {
//            mGroupDao.update(groups_lists[0]);
//            return null;
//        }
//    }
//    private static class DeletAllWordAsynTask extends AsyncTask<Void, Void, Void> {
//        public GroupDao mGroupDao;
//        public  DeletAllWordAsynTask (GroupDao groupDao){
//            mGroupDao=groupDao;
//        }
//
//        @Override
//        protected Void doInBackground(Void... voids) {
//            mGroupDao.deleteAllGroup();
//            return null;
//        }
//    }
//}
