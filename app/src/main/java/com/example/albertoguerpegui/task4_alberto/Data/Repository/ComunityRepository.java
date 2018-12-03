package com.example.albertoguerpegui.task4_alberto.Data.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import com.example.albertoguerpegui.task4_alberto.Comunities.FragmentComunity.ComunityObject;
import com.example.albertoguerpegui.task4_alberto.Data.BBDD.UTADBBDD;
import com.example.albertoguerpegui.task4_alberto.Data.DAO.ComunityDAO;

import java.util.List;

public class ComunityRepository {
    private ComunityDAO comunityDAO;
    public LiveData<List<ComunityObject>> mAllComunity;

    public ComunityRepository(Application application) {
        UTADBBDD db = UTADBBDD.getDatabase(application);
        comunityDAO = db.comunitydao();
        mAllComunity = comunityDAO.getAllComunity();
    }
    LiveData<List<ComunityObject>> getmAllComunity() {
        return mAllComunity;
    }
}
