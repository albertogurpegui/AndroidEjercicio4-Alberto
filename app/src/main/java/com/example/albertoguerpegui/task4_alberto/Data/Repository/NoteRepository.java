package com.example.albertoguerpegui.task4_alberto.Data.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.albertoguerpegui.task4_alberto.Data.BBDD.UTADBBDD;
import com.example.albertoguerpegui.task4_alberto.Data.DAO.NoteDAO;
import com.example.albertoguerpegui.task4_alberto.Notes.NoteObject;

import java.util.List;

public class NoteRepository {
    private NoteDAO noteDAO;
    public LiveData<List<NoteObject>> mAllNote;

    public NoteRepository(Application application) {
        UTADBBDD db = UTADBBDD.getDatabase(application);
        noteDAO = db.notedao();
        mAllNote = noteDAO.getAllNote();
    }
    LiveData<List<NoteObject>> getAllNote() {
        return mAllNote;
    }
}

