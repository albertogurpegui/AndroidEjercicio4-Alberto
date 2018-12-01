package com.example.albertoguerpegui.task4_alberto.Data.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.albertoguerpegui.task4_alberto.Notes.NoteObject;

import java.util.List;

@Dao
public interface NoteDAO {

    @Insert
    void insertAll(List<NoteObject> noteList);

    @Query("DELETE FROM Note")
    void deleteAll();

    @Query("SELECT * from Note ORDER BY id ASC")
    LiveData<List<NoteObject>> getAllNote();
}

