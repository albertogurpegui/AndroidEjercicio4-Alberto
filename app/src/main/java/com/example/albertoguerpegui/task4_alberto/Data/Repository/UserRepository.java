package com.example.albertoguerpegui.task4_alberto.Data.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.albertoguerpegui.task4_alberto.Data.BBDD.UTADBBDD;
import com.example.albertoguerpegui.task4_alberto.Data.DAO.UserDAO;
import com.example.albertoguerpegui.task4_alberto.User;

public class UserRepository {
    private UserDAO userDAO;
    public LiveData<User> mUser;

    public UserRepository(Application application) {
        UTADBBDD db = UTADBBDD.getDatabase(application);
        userDAO = db.userdao();
        mUser = userDAO.getUser();
    }
    LiveData<User> getUser() {
        return mUser;
    }
}
