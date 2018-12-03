package com.example.albertoguerpegui.task4_alberto.Data.BBDD;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.albertoguerpegui.task4_alberto.Comunities.FragmentComunity.ComunityObject;
import com.example.albertoguerpegui.task4_alberto.Data.DAO.ComunityDAO;
import com.example.albertoguerpegui.task4_alberto.Data.DAO.LessonDAO;
import com.example.albertoguerpegui.task4_alberto.Data.DAO.NoteDAO;
import com.example.albertoguerpegui.task4_alberto.Data.DAO.NotificationDAO;
import com.example.albertoguerpegui.task4_alberto.Data.DAO.TeacherDAO;
import com.example.albertoguerpegui.task4_alberto.Data.DAO.UserDAO;
import com.example.albertoguerpegui.task4_alberto.Lessons.FragmentLessons.ClassObject;
import com.example.albertoguerpegui.task4_alberto.Notes.NoteObject;
import com.example.albertoguerpegui.task4_alberto.Notifications.NotificationObject;
import com.example.albertoguerpegui.task4_alberto.R;
import com.example.albertoguerpegui.task4_alberto.Teachers.FragmentTeacher.TeacherObject;
import com.example.albertoguerpegui.task4_alberto.User;

import java.util.ArrayList;
import java.util.List;

@Database(entities = {NotificationObject.class, NoteObject.class, ClassObject.class, TeacherObject.class, ComunityObject.class, User.class}, version = 7)
public abstract class UTADBBDD extends RoomDatabase {

    public abstract NotificationDAO notificationdao();
    public abstract NoteDAO notedao();
    public abstract LessonDAO lessondao();
    public abstract TeacherDAO teacherdao();
    public abstract ComunityDAO comunitydao();
    public abstract UserDAO userdao();
    public static UTADBBDD INSTANCE;

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
                            .addCallback(callBackDataLessons)
                            .addCallback(callBackDataNotification)
                            .addCallback(callBackDataNotes)
                            .addCallback(callBackDataTeachers)
                            .addCallback(callBackDataComunities)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    static Callback callBackDataNotification = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            (new NotificationAsyncTask(INSTANCE)).execute();
        }
    };

    static Callback callBackDataNotes = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            (new NoteAsyncTask(INSTANCE)).execute();
        }
    };

    static Callback callBackDataLessons = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            (new LessonAsyncTask(INSTANCE)).execute();
        }
    };

    static Callback callBackDataTeachers = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            (new TeacherAsyncTask(INSTANCE)).execute();
        }
    };

    static Callback callBackDataComunities = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            (new ComunityAsyncTask(INSTANCE)).execute();
        }
    };

    private static class NotificationAsyncTask extends AsyncTask<Void,Void,Void> {
        public NotificationDAO notificationDAO;

        public NotificationAsyncTask(UTADBBDD utadbbdd) {
            notificationDAO = utadbbdd.notificationdao();
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
            List<NotificationObject> dataNotification = new ArrayList<>();
            dataNotification.add(notificaciones1);
            dataNotification.add(notificaciones2);
            dataNotification.add(notificaciones3);
            dataNotification.add(notificaciones4);
            dataNotification.add(notificaciones5);
            dataNotification.add(notificaciones6);
            dataNotification.add(notificaciones7);
            dataNotification.add(notificaciones8);
            dataNotification.add(notificaciones9);
            dataNotification.add(notificaciones10);
            notificationDAO.deleteAll();
            notificationDAO.insertAll(dataNotification);
            return null;
        }
    }

    private static class NoteAsyncTask extends AsyncTask<Void,Void,Void> {
        public NoteDAO noteDAO;

        public NoteAsyncTask(UTADBBDD utadbbdd) {
            noteDAO = utadbbdd.notedao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            NoteObject notes1 = new NoteObject("2018/11/19", "Enpresa", "5.00", "Curriculum");
            NoteObject notes2 = new NoteObject("2018/07/21", "IOS", "10.00","Post");
            NoteObject notes3 = new NoteObject("2018/08/14", "GG Empresarial", "7.00","Tabajo Final");
            NoteObject notes4 = new NoteObject("2018/12/30", "Ingles","8.50","Writing");
            NoteObject notes5 = new NoteObject("2018/09/15", "Acceso a datos","7.00","Hibernate");
            NoteObject notes6 = new NoteObject("2018/10/21", "Android","9.00","Singleton");
            NoteObject notes7 = new NoteObject("2018/09/16", "Procesos","4.90","Hilos");
            List<NoteObject> dataNote = new ArrayList<>();
            dataNote.add(notes1);
            dataNote.add(notes2);
            dataNote.add(notes3);
            dataNote.add(notes4);
            dataNote.add(notes5);
            dataNote.add(notes6);
            dataNote.add(notes7);
            noteDAO.deleteAll();
            noteDAO.insertAll(dataNote);
            return null;
        }
    }

    private static class LessonAsyncTask extends AsyncTask<Void,Void,Void> {
        public LessonDAO lessonDAO;

        public LessonAsyncTask(UTADBBDD utadbbdd) {
            lessonDAO = utadbbdd.lessondao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            ClassObject database = new ClassObject("Database Access",R.drawable.basedatos,"2ª Course", "Database class");
            ClassObject android = new ClassObject("Android", R.drawable.android,"2ª Course", "Android class");
            ClassObject fct = new ClassObject("FCT", R.drawable.fct,"2ª Course", "FCT class");
            ClassObject computing = new ClassObject("Computing", R.drawable.computing,"2ª Course", "Computing class");
            ClassObject english = new ClassObject("English", R.drawable.english,"2ª Course", "English class");
            ClassObject swift = new ClassObject("Swift", R.drawable.swift,"2ª Course", "IOS class");
            ClassObject tfg = new ClassObject("TFG", R.drawable.tfg,"2ª Course", "TFG classs");
            ClassObject odoo = new ClassObject("Management", R.drawable.odoo,"2ª Course", "OpenERP class");
            ClassObject company = new ClassObject("Company", R.drawable.company,"2ª Course", "Business class");
            List<ClassObject> dataLesson = new ArrayList<>();
            dataLesson.add(database);
            dataLesson.add(android);
            dataLesson.add(fct);
            dataLesson.add(computing);
            dataLesson.add(english);
            dataLesson.add(swift);
            dataLesson.add(tfg);
            dataLesson.add(odoo);
            dataLesson.add(company);
            lessonDAO.deleteAll();
            lessonDAO.insertAll(dataLesson);
            return null;
        }
    }

    private static class TeacherAsyncTask extends AsyncTask<Void,Void,Void> {
        public TeacherDAO teacherDAO;

        public TeacherAsyncTask(UTADBBDD utadbbdd) {
            teacherDAO = utadbbdd.teacherdao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            TeacherObject pedro = new TeacherObject("Pedro",R.drawable.pedro, "Camacho", "Computing expert");
            TeacherObject jaime = new TeacherObject("Jaime", R.drawable.jaime, "La Torre","Database expert");
            TeacherObject laura = new TeacherObject("Laura", R.drawable.laura, "Jaen", "OpenERP expert");
            TeacherObject meritxell = new TeacherObject("Meritxell", R.drawable.meritxel,"Bretos", "Company expert");
            TeacherObject david = new TeacherObject("David", R.drawable.david, "Jardon", "Adroid expert");
            TeacherObject cristina = new TeacherObject("Cristina",R.drawable.cristina, "Espinosa", "English expert");
            TeacherObject dani = new TeacherObject("Daniel", R.drawable.daniel_lopez, "Lopez", "TFG expert");
            TeacherObject carlos = new TeacherObject("Carlos", R.drawable.carlos, "Jimenez", "IOS expert");
            List<TeacherObject> dataTeacher = new ArrayList<>();
            dataTeacher.add(pedro);
            dataTeacher.add(jaime);
            dataTeacher.add(meritxell);
            dataTeacher.add(david);
            dataTeacher.add(laura);
            dataTeacher.add(cristina);
            dataTeacher.add(dani);
            dataTeacher.add(carlos);
            teacherDAO.deleteAll();
            teacherDAO.insertAll(dataTeacher);

            return null;
        }
    }

    private static class ComunityAsyncTask extends AsyncTask<Void,Void,Void> {
        public ComunityDAO comunityDAO;

        public ComunityAsyncTask(UTADBBDD utadbbdd) {
            comunityDAO = utadbbdd.comunitydao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            ComunityObject cibersegurity = new ComunityObject("Cibersegurity",R.drawable.basedatos, "CiberSegurity Topic","CiberSegurity Community", "Daniel Lopez");
            ComunityObject development = new ComunityObject("Development", R.drawable.android, "Development Topic", "Development Community", "Jaime La torre");
            ComunityObject big_data = new ComunityObject("Big Data", R.drawable.fct, "Big Data Topic", "Big Data Community", "Pedro Camacho");
            ComunityObject videogames = new ComunityObject("Videogames", R.drawable.computing, "VideoGames Topic", "VideoGames Community", "Jhonny");
            List<ComunityObject> dataComunity = new ArrayList<>();
            dataComunity.add(cibersegurity);
            dataComunity.add(development);
            dataComunity.add(big_data);
            dataComunity.add(videogames);
            comunityDAO.deleteAll();
            comunityDAO.insertAll(dataComunity);
            return null;
        }
    }
}

