package com.treinador.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import com.treinador.R;
import com.treinador.services.ConjugationService;

public class Conjugate extends Activity {

    private final ConjugationService conjugationService = new ConjugationService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conjugate);

        createSpinner();
    }

    private void createSpinner() {
        Spinner spinner = (Spinner) findViewById(R.id.tense_input);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.tenses, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_conjugate, menu);
        return true;
    }

    public void conjugateInfinitive(View view) {
//        boolean b = conjugationService.dbConnection(getApplicationContext());
        String conjugatedVerb = conjugate();
        Intent conjugationIntent = new Intent(this, Conjugation.class);
//        conjugationIntent.putExtra("RESULT", String.valueOf(b));
        conjugationIntent.putExtra("RESULT", conjugatedVerb);
        startActivity(conjugationIntent);
    }

    private String conjugate() {
        String tenseInput = ((Spinner) findViewById(R.id.tense_input)).getSelectedItem().toString();
        String infinitiveInput = ((EditText) findViewById(R.id.infinitive_input)).getText().toString();
        return conjugationService.conjugate(infinitiveInput, tenseInput);
    }

}
