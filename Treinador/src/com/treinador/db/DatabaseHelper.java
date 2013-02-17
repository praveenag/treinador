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

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(databaseUtil.createTableSql(Tense.TABLE_NAME, Tense.initializeColumns()));
        db.execSQL(databaseUtil.createTableSql(Verb.TABLE_NAME, Verb.initializeColumns()));
        db.execSQL(databaseUtil.createTableSql(Rule.TABLE_NAME, Rule.initializeColumns()));
        db.execSQL(databaseUtil.createTableSql(VerbTenseRuleMap.TABLE_NAME, VerbTenseRuleMap.initializeColumns()));
        setupTenseAndRules(db);
    }

    private void setupTenseAndRules(SQLiteDatabase db) {
        insertTense(db);
        insertVerb(db);
        insertRules(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(databaseUtil.deleteTableSql(VerbTenseRuleMap.TABLE_NAME));
        onCreate(db);
    }

    public String querySql(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy, String limit){
        SQLiteDatabase db = getReadableDatabase();
//        Cursor cursor = db.rawQuery("select rule_id from verb_tense_rule_mapping where tense_id = 2 and verb_id = 11", new String[]{},null);
        Cursor cursor = db.rawQuery("select * from verb_tense_rule_mapping", new String[]{},null);
        cursor.moveToFirst();
        long itemId = cursor.getLong(
                cursor.getColumnIndexOrThrow(VerbTenseRuleMap._ID)
        );
        String value = "Result is " + itemId;
//        while (cursor.moveToNext()) {
//            value = value.concat(cursor.getString(0)).concat(cursor.getString(1)).concat(cursor.getString(2));
//            value = value.concat(cursor.getString(0));
//        }
        return value;
    }

    private void x(){
        String[] projection = {VerbTenseRuleMap.RULE_ID};
        String s = querySql(VerbTenseRuleMap.TABLE_NAME, projection, "verb_id = ? and tense_id = ?", new String[]{"11", "2"}, null, null, null, null);
        System.out.println("***************" +s);
        Log.i("***************",s);
    }
    private long insertVerb(SQLiteDatabase db) {
        ContentValues valuesForVerb = new ContentValues();
        valuesForVerb.put(Verb.VERB, "ER");
        valuesForVerb.put(Verb._ID, "11");
        long verbId = db.insert(Verb.TABLE_NAME, null, valuesForVerb);
        return verbId;
    }

    private long insertTense(SQLiteDatabase db) {
        ContentValues valuesForTense = new ContentValues();
        valuesForTense.put(Tense._ID, String.valueOf(Tense.PRESENT.getId()));
        valuesForTense.put(Tense.TENSE, Tense.PRESENT.name());
        long tenseId = db.insert(VerbTenseRuleMap.TABLE_NAME, null, valuesForTense);
        return tenseId;
    }

    private long insertRules(SQLiteDatabase db) {
        ContentValues valuesForVerbs = new ContentValues();
        valuesForVerbs.put(Verb.VERB, "ER");
        long verbId = db.insert(VerbTenseRuleMap.TABLE_NAME, null, valuesForVerbs);

        ContentValues valuesForRules = new ContentValues();
        valuesForRules.put(Rule.RULE, ERPresentTenseRule.class.getName());
        long ruleId = db.insert(Rule.TABLE_NAME, null, valuesForRules);

        ContentValues valuesForMapping = new ContentValues();
        valuesForMapping.put(VerbTenseRuleMap.RULE_ID, String.valueOf(ruleId));
        valuesForMapping.put(VerbTenseRuleMap.VERB_ID, String.valueOf(verbId));
        valuesForMapping.put(VerbTenseRuleMap.TENSE_ID, String.valueOf(Tense.PRESENT.getId()));
        long mappingId = db.insert(VerbTenseRuleMap.TABLE_NAME, null, valuesForMapping);

        return mappingId;
    }
}
