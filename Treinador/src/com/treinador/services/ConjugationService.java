package com.treinador.services;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.treinador.db.DatabaseHelper;
import com.treinador.db.VerbTenseRuleMap;

public class ConjugationService {
    private static final String NAME = "CONJUGATION_SERVICE";
    private DatabaseHelper databaseHelper;

    public String conjugate(String infinitiveInput, String tenseInput){
        return infinitiveInput + " " + tenseInput;
    }

    public boolean dbConnection(Context context) {
        databaseHelper = new DatabaseHelper(context);
        SQLiteDatabase db = databaseHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(VerbTenseRuleMap.RULE_ID, "11");
        values.put(VerbTenseRuleMap.TENSE_ID, "21");
        values.put(VerbTenseRuleMap.VERB_ID, "31");

        db.insert(VerbTenseRuleMap.TABLE_NAME, null, values);
        Cursor cursor = db.rawQuery("select * from verb_tense_rule_mapping_table", new String[]{}, null);
        boolean b = cursor.moveToFirst();
        return b;

    }
}