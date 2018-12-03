package com.example.albertoguerpegui.task4_alberto.Data.DAO;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.albertoguerpegui.task4_alberto.Comunities.FragmentComunity.ComunityObject;

import java.util.List;
@Dao
public interface ComunityDAO {
    @Insert
    void insertAll(List<ComunityObject> comunityList);

    @Query("DELETE FROM Comunity")
    void deleteAll();

    @Query("SELECT * from Comunity ORDER BY id ASC")
    LiveData<List<ComunityObject>> getAllComunity();
}
