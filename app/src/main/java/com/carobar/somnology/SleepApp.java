package com.carobar.somnology;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.SharedPreferences;
import android.content.res.Configuration;

import com.carobar.somnology.core.database.AppDatabase;

/**
 * Created by pradeep on 1/12/17.
 */

public class SleepApp extends Application {
    public static SleepApp INSTANCE;
    public static String loginUser;
    public static final String PREFS_LOGIN_SLEEPAPP = "SleepAppPrefFile";
    // Called when the application is starting, before any other application objects have been created.
    // Overriding this method is totally optional!

    private AppDatabase database;

    public static SleepApp get() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // Required initialization logic here!
        database = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,"MobileSleep.db").allowMainThreadQueries().addMigrations(AppDatabase.MIGRATION_1_2).build();

        INSTANCE = this;
    }
    public AppDatabase getDB() {
        return database;
    }

    public String getLoginUser() { return loginUser;}

    public void setLoginUser(String user){
        loginUser = user;
    }


    public Boolean checkSharedPref(){
        SharedPreferences settings = getSharedPreferences(PREFS_LOGIN_SLEEPAPP, 0);
        String loginUser = settings.getString("loginUser", "firstTime");

        if(loginUser != null && !loginUser.equalsIgnoreCase("firstTime")){
            setLoginUser(loginUser);
            return true;
        }
        return false;
    }
    public Boolean profileCheckSharedPref(){
        SharedPreferences settings = getSharedPreferences(PREFS_LOGIN_SLEEPAPP, 0);
        String popUpShown = settings.getString("popup", "firstTime");

        if(popUpShown != null && popUpShown.equalsIgnoreCase("firstTime")){
            return true;
        }
        return false;
    }

//    public static void setProfileFirstTime(String firstTime){profileFirstTime=firstTime;}
//
//    public static String getProfileFirstTime() {
//        return profileFirstTime;
//    }
//
//    public Boolean checkProfileFirstTime(){
//        SharedPreferences settings = getSharedPreferences(PREFS_LOGIN_SLEEPAPP, 0);
//        String profileFirstTime = settings.getString("profileFirstTime", "firstTime");
//
//        if(profileFirstTime != null && !profileFirstTime.equalsIgnoreCase("firstTime")){
//            setProfileFirstTime(profileFirstTime);
//            return true;
//        }
//        return false;
//    }

    // Called by the system when the device configuration changes while your component is running.
    // Overriding this method is totally optional!
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    // This is called when the overall system is running low on memory,
    // and would like actively running processes to tighten their belts.
    // Overriding this method is totally optional!
    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
