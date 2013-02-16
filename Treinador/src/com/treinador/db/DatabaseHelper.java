package com.treinador.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Treinador.db";
    private DatabaseUtil databaseUtil = new DatabaseUtil();

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createVerbTenseMapSql = databaseUtil.createTableSql(VerbTenseRuleMap.TABLE_NAME, VerbTenseRuleMap.initializeColumns());
        db.execSQL(createVerbTenseMapSql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(databaseUtil.deleteTableSql(VerbTenseRuleMap.TABLE_NAME));
        onCreate(db);
    }

}
