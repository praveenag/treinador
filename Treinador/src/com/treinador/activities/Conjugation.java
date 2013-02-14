package com.treinador.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;
import com.treinador.R;

public class Conjugation extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conjugation);
        String result = getIntent().getStringExtra("RESULT");
        TextView view = (TextView) findViewById(R.id.conjugated_result);
        view.setText(result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_conjugation, menu);
        return true;
    }

}
