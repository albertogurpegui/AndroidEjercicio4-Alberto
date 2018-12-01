package com.example.albertoguerpegui.task4_alberto.Data.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.albertoguerpegui.task4_alberto.Data.BBDD.UTADBBDD;
import com.example.albertoguerpegui.task4_alberto.Data.DAO.LessonDAO;
import com.example.albertoguerpegui.task4_alberto.Lessons.FragmentLessons.ClassObject;

import java.util.List;

public class LessonRepository {
    private LessonDAO lessonDAO;
    public LiveData<List<ClassObject>> mAllClass;

    public LessonRepository(Application application) {
        UTADBBDD db = UTADBBDD.getDatabase(application);
        lessonDAO = db.lessondao();
        mAllClass = lessonDAO.getAllClass();
    }
    LiveData<List<ClassObject>> getAllLesson() {
        return mAllClass;
    }
}
