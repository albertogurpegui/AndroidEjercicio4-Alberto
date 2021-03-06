package com.example.albertoguerpegui.task4_alberto.Data.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.albertoguerpegui.task4_alberto.Data.BBDD.UTADBBDD;
import com.example.albertoguerpegui.task4_alberto.Data.DAO.NotificationDAO;
import com.example.albertoguerpegui.task4_alberto.Notifications.NotificationObject;

import java.util.List;

public class NotificationRepository {
    private NotificationDAO notificationDAO;
    public LiveData<List<NotificationObject>> mAllNotification;

    public NotificationRepository(Application application) {
        UTADBBDD db = UTADBBDD.getDatabase(application);
        notificationDAO = db.notificationdao();
        mAllNotification = notificationDAO.getAllNotification();
    }
    LiveData<List<NotificationObject>> getAllNotification() {
        return mAllNotification;
    }
}

