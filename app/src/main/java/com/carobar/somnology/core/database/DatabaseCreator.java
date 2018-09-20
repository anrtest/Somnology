//package com.carobar.somnology.core.database;
//
//import android.arch.persistence.db.SupportSQLiteDatabase;
//import android.arch.persistence.room.Room;
//import android.arch.persistence.room.migration.Migration;
//import android.content.Context;
//import android.support.annotation.NonNull;
//
///**
// * Created by pradeep on 1/12/17.
// */
//
//public class DatabaseCreator {
//    private static AppDatabase appDatabase;
//    private static final  Object LOCK = new Object();
//
//    static final Migration MIGRATION_1_2 = new Migration(1,2) {
//        @Override
//        public void migrate(@NonNull SupportSQLiteDatabase database) {
//            //since we did'nt alter table, there's nothing else to do here.
//        }
//    };
////    public synchronized static AppDatabase getAppDatabase(Context context){
////        if(appDatabase == null){
////            synchronized (LOCK) {
////                if(appDatabase == null){
////                    appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class,"MobileSleep.db").allowMainThreadQueries().addMigrations(MIGRATION_1_2).build();
////                }
////            }
////        }
////        return appDatabase;
////    }
//}
