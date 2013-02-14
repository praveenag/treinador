package com.treinador.activities;

import android.view.View;
import android.widget.TextView;
import com.treinador.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Conjugation extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_conjugation);
        String result = getIntent().getStringExtra("RESULT");
        TextView view = (TextView)findViewById(R.id.conjugated_result);
        view.setText(result);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_conjugation, menu);
		return true;
	}

}
