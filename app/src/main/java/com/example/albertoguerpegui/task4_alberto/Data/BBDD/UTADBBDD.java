package com.example.albertoguerpegui.task4_alberto.Data.BBDD;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.albertoguerpegui.task4_alberto.Data.DAO.NotificationDAO;
import com.example.albertoguerpegui.task4_alberto.Notifications.NotificationObject;

import java.util.ArrayList;
import java.util.List;

@Database(entities = {NotificationObject.class}, version = 1)
public abstract class UTADBBDD extends RoomDatabase {

    public abstract NotificationDAO classdao();
    private static UTADBBDD INSTANCE;

    public static UTADBBDD getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (UTADBBDD.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            UTADBBDD.class, "database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .addCallback(callBackData)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    static Callback callBackData = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            (new NotificationAsyncTask(INSTANCE)).execute();
        }
    };

    private static class NotificationAsyncTask extends AsyncTask<Void,Void,Void> {
        public NotificationDAO classDao;

        public NotificationAsyncTask(UTADBBDD utadbbdd) {
            classDao = utadbbdd.classdao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            NotificationObject notificaciones1 = new NotificationObject("2018/11/19", "Laura", "Has conseguido un logro");
            NotificationObject notificaciones2 = new NotificationObject("2018/07/21", "Carlos", "Tienes una nota nueva");
            NotificationObject notificaciones3 = new NotificationObject("2018/08/14", "Meritxel", "Has conseguido un logro");
            NotificationObject notificaciones4 = new NotificationObject("2018/12/30", "David","Has mandado una tarea");
            NotificationObject notificaciones5 = new NotificationObject("2018/09/15", "Cristina","Has conseguido un logro");
            NotificationObject notificaciones6 = new NotificationObject("2018/10/21", "Laura","No has enviado la tarea");
            NotificationObject notificaciones7 = new NotificationObject("2018/09/16", "Jaime","No hay clase");
            NotificationObject notificaciones8 = new NotificationObject("2018/10/21", "Pedro","Te has copiado en este ejercicio");
            NotificationObject notificaciones9 = new NotificationObject("2018/09/16", "Yony","No sirves para nada");
            NotificationObject notificaciones10 = new NotificationObject("2018/10/21", "Joaquin","Aprobaste");
            List<NotificationObject> data = new ArrayList<>();
            data.add(notificaciones1);
            data.add(notificaciones2);
            data.add(notificaciones3);
            data.add(notificaciones4);
            data.add(notificaciones5);
            data.add(notificaciones6);
            data.add(notificaciones7);
            data.add(notificaciones8);
            data.add(notificaciones9);
            data.add(notificaciones10);
            classDao.deleteAll();
            classDao.insertAll(data);
            return null;
        }
    }
}

