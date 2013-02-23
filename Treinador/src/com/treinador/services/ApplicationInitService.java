package com.treinador.services;

import android.app.Application;
import android.util.Log;
import com.treinador.db.DatabaseHelper;

public class ApplicationInitService extends Application{

    private static DatabaseHelper databaseHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        databaseHelper = DatabaseHelper.getInstance(getApplicationContext());
    }

    public static DatabaseHelper getDatabaseHelper() {
        return databaseHelper;
    }
}
