package com.example.albertoguerpegui.task4_alberto.Data.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;


import com.example.albertoguerpegui.task4_alberto.User;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert
    void insertUser(User user);

    @Query("DELETE FROM User")
    void deleteAll();

    @Query("SELECT * from User ORDER BY id ASC")
    LiveData<User> getUser();
}
