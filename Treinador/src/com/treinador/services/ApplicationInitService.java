package com.treinador.services;

import android.app.Application;
import com.treinador.db.DatabaseHelper;

public class ApplicationInitService extends Application{

    private DatabaseHelper databaseHelper;

    @Override
    public void onCreate() {
        super.onCreate();
        databaseHelper = new DatabaseHelper(getApplicationContext());
    }
}
