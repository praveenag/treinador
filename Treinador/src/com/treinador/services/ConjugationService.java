package com.treinador.services;

import android.app.IntentService;
import android.content.Intent;
import com.treinador.activities.Conjugation;
import com.treinador.db.DatabaseHelper;
import com.treinador.domain.VerbTenseRuleMap;

public class ConjugationService extends IntentService {

    private DatabaseHelper databaseHelper;

    public ConjugationService() {
        super("Conjugation Service");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.databaseHelper = ApplicationInitService.getDatabaseHelper();
    }

    private String conjugate(String verbInfinitive, String tense){
        String[] projection = {VerbTenseRuleMap.RULE_ID};
        return databaseHelper.querySql(VerbTenseRuleMap.TABLE_NAME, projection, "verb_id = ? and tense_id = ?", new String[]{"11","2"},null,null,null,null);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String verbInfinitive = intent.getStringExtra("verbInfinitive");
        String tense = intent.getStringExtra("tense");
        String conjugatedVerb = conjugate(verbInfinitive, tense);
        Intent publishResultIntent = new Intent(this, Conjugation.class);
        publishResultIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        publishResultIntent.putExtra("RESULT", conjugatedVerb);
        startActivity(publishResultIntent);
    }
}