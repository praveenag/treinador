package com.treinador.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import com.treinador.domain.Rule;
import com.treinador.domain.Tense;
import com.treinador.domain.Verb;
import com.treinador.domain.VerbTenseRuleMap;
import com.treinador.rules.ERPresentTenseRule;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Treinador.db";
    private DatabaseUtil databaseUtil = new DatabaseUtil();
    private static DatabaseHelper singletonInstance;


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
        createTables(db);
    }

    private void createTables(SQLiteDatabase db) {
        db.execSQL(databaseUtil.createTableSql(Tense.TABLE_NAME, Tense.initializeColumns()));
        db.execSQL(databaseUtil.createTableSql(Verb.TABLE_NAME, Verb.initializeColumns()));
        db.execSQL(databaseUtil.createTableSql(Rule.TABLE_NAME, Rule.initializeColumns()));
        db.execSQL(databaseUtil.createTableSql(VerbTenseRuleMap.TABLE_NAME, VerbTenseRuleMap.initializeColumns()));
        setupTenseAndRules(db);
    }

    private void setupTenseAndRules(SQLiteDatabase db) {
        long tenseId = insertTense(db);
        long verbId = insertVerb(db);
        long ruleId = insertRules(db);
        insertMapping(db, verbId, ruleId, tenseId);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(databaseUtil.deleteTableSql(VerbTenseRuleMap.TABLE_NAME));
        onCreate(db);
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

    private long insertVerb(SQLiteDatabase db) {
        ContentValues valuesForVerb = new ContentValues();
        valuesForVerb.put(Verb.VERB, "ER");
        valuesForVerb.put(Verb._ID, "11");
        return db.insert(VerbTenseRuleMap.TABLE_NAME, null, valuesForVerb);
    }

    private long insertTense(SQLiteDatabase db) {
        ContentValues valuesForTense = new ContentValues();
        valuesForTense.put(Tense._ID, String.valueOf(Tense.PRESENT.getId()));
        valuesForTense.put(Tense.TENSE, Tense.PRESENT.name());
        return db.insert(Tense.TABLE_NAME, null, valuesForTense);
    }

    private long insertRules(SQLiteDatabase db) {
        ContentValues valuesForRules = new ContentValues();
        valuesForRules.put(Rule.RULE, ERPresentTenseRule.class.getName());
        return db.insert(Rule.TABLE_NAME, null, valuesForRules);
    }

    private long insertMapping(SQLiteDatabase db, long verbId, long ruleId, long tenseId) {
        ContentValues valuesForMapping = new ContentValues();
        valuesForMapping.put(VerbTenseRuleMap.RULE_ID, String.valueOf(ruleId));
        valuesForMapping.put(VerbTenseRuleMap.VERB_ID, String.valueOf(verbId));
        valuesForMapping.put(VerbTenseRuleMap.TENSE_ID, String.valueOf(tenseId));
        return db.insert(VerbTenseRuleMap.TABLE_NAME, null, valuesForMapping);
    }
}
