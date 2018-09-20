package com.carobar.somnology.core.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.carobar.somnology.core.entities.UserEntity;

import java.util.List;

/**
 * Created by pradeep on 30/11/17.
 */

@Dao
public interface UserDao {
    @Query("SELECT * FROM userEntity")
    List<UserEntity> getAll();

    @Query("SELECT * FROM userEntity WHERE userID IN (:userIDS)")
    List<UserEntity> getAllByIds(int[] userIDS);

    @Query("Select * FROM userEntity WHERE mailID = :mailID")
    UserEntity findByEmail(String mailID);

    @Query("Select * FROM userEntity WHERE mailID=:mailID and password=:password")
    UserEntity findByEmailNPassword(String mailID, String password);

    @Insert
    void insertAll(UserEntity users);

    @Update
    void updateUser(UserEntity user);
}
