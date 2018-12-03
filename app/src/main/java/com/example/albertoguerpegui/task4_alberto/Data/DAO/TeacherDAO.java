package com.example.albertoguerpegui.task4_alberto.Data.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.albertoguerpegui.task4_alberto.Teachers.FragmentTeacher.TeacherObject;

import java.util.List;
@Dao
public interface TeacherDAO {
    @Insert
    void insertAll(List<TeacherObject> teacherList);

    @Query("DELETE FROM Teacher")
    void deleteAll();

    @Query("SELECT * from Teacher ORDER BY id ASC")
    LiveData<List<TeacherObject>> getAllTeacher();
}
