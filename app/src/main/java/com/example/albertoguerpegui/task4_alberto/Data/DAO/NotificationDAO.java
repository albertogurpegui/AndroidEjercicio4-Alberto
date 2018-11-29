package com.example.albertoguerpegui.task4_alberto.Data.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.albertoguerpegui.task4_alberto.Notifications.NotificationObject;

import java.util.List;

@Dao
public interface NotificationDAO {

    @Insert
    void insertAll(List<NotificationObject> notificationList);

    @Query("DELETE FROM Notification")
    void deleteAll();

    @Query("SELECT * from Notification ORDER BY id ASC")
    LiveData<List<NotificationObject>> getAllNotification();
}

