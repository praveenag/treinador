package com.treinador.db.seed;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.treinador.db.DatabaseUtil;
import com.treinador.domain.Rule;
import com.treinador.domain.Tense;
import com.treinador.domain.Verb;
import com.treinador.domain.VerbTenseRuleMap;
import com.treinador.rules.ERPresentTenseRule;

public class Seed {
    private DatabaseUtil databaseUtil = new DatabaseUtil();

    public void seed(SQLiteDatabase db) {
        db.execSQL(databaseUtil.createTableSql(Tense.TABLE_NAME, Tense.initializeColumns()));
        db.execSQL(databaseUtil.createTableSql(Verb.TABLE_NAME, Verb.initializeColumns()));
        db.execSQL(databaseUtil.createTableSql(Rule.TABLE_NAME, Rule.initializeColumns()));
        db.execSQL(databaseUtil.createTableSql(VerbTenseRuleMap.TABLE_NAME, VerbTenseRuleMap.initializeColumns()));
        setupTenseAndRules(db);
    }

    public void upgrade(SQLiteDatabase db) {
        db.execSQL(databaseUtil.deleteTableSql(VerbTenseRuleMap.TABLE_NAME));
        db.execSQL(databaseUtil.deleteTableSql(Verb.TABLE_NAME));
        db.execSQL(databaseUtil.deleteTableSql(Rule.TABLE_NAME));
        db.execSQL(databaseUtil.deleteTableSql(Tense.TABLE_NAME));
        seed(db);
    }

    private void setupTenseAndRules(SQLiteDatabase db) {
        long tenseId = insertTense(db);
        long verbId = insertVerb(db);
        long ruleId = insertRules(db);
        insertMapping(db, verbId, ruleId, tenseId);
    }

    private long insertVerb(SQLiteDatabase db) {
        ContentValues valuesForVerb = new ContentValues();
        valuesForVerb.put(Verb.VERB, "er");
        return db.insert(Verb.TABLE_NAME, null, valuesForVerb);
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
