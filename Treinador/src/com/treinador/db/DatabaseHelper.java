package com.treinador.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.treinador.db.seed.Seed;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Treinador.db";
    private static DatabaseHelper singletonInstance;
    private Seed seed = new Seed();


    public static DatabaseHelper getInstance(Context context) {
        if (singletonInstance == null) {
            singletonInstance = new DatabaseHelper(context);
        }
        return singletonInstance;
    }

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        seed.seed(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        seed.upgrade(db);

    }

    public String querySql(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy, limit);
        String value = "Result is ";
        while (cursor.moveToNext()) {
            value = value.concat(cursor.getString(0));
//            value = value.concat(cursor.getString(0)).concat(cursor.getString(1)).concat(cursor.getString(2));
//            value = value.concat(String.valueOf(cursor.getLong(cursor.getColumnIndex(VerbTenseRuleMap.RULE_ID))));
        }
        db.close();
        return value;
    }

}
