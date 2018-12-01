package com.example.albertoguerpegui.task4_alberto.Data.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.albertoguerpegui.task4_alberto.Lessons.FragmentLessons.ClassObject;

import java.util.List;

@Dao
public interface LessonDAO {
    @Insert
    void insertAll(List<ClassObject> classList);

    @Query("DELETE FROM Note")
    void deleteAll();

    @Query("SELECT * from Lesson ORDER BY id ASC")
    LiveData<List<ClassObject>> getAllClass();
}
