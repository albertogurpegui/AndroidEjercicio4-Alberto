package com.example.albertoguerpegui.task4_alberto.Data.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.albertoguerpegui.task4_alberto.Data.BBDD.UTADBBDD;
import com.example.albertoguerpegui.task4_alberto.Data.DAO.TeacherDAO;
import com.example.albertoguerpegui.task4_alberto.Teachers.FragmentTeacher.TeacherObject;

import java.util.List;

public class TeacherRepository {
    private TeacherDAO teacherDAO;
    public LiveData<List<TeacherObject>> mAllTeacher;

    public TeacherRepository(Application application) {
        UTADBBDD db = UTADBBDD.getDatabase(application);
        teacherDAO = db.teacherdao();
        mAllTeacher = teacherDAO.getAllTeacher();
    }
    LiveData<List<TeacherObject>> getmAllTeacher() {
        return mAllTeacher;
    }
}
