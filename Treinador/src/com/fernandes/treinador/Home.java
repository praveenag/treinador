package com.fernandes.treinador;

import android.os.Bundle;
import android.app.Activity;
//import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//    	Intent intent = getIntent();
//    	String verb = intent.getStringExtra("verb");
//    	TextView textView = new TextView(this);
//        textView.setTextSize(40);
//        textView.setText(verb);
//        setContentView(textView);
    	
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_home, menu);
        return true;
    }
    
    public void conjugate(View view) {
//    	Intent intent = new Intent(this, Home.class);
    	EditText editText = (EditText) findViewById(R.id.verb);
        String verb = editText.getText().toString();
//        intent.putExtra("verb", verb);
//        startActivity(intent);
        TextView textView = (TextView) findViewById(R.id.conjugation);
        textView.setText(verb);
    }
    
}
