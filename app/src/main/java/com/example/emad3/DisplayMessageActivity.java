package com.example.emad3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class DisplayMessageActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String pass = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
    }


    void sendtonextactivity(View view)
    {   Spinner spin= findViewById(R.id.spinner1);
        Spinner spin2=findViewById(R.id.spinner2);
        String text = spin.getSelectedItem().toString();
        String text2=spin2.getSelectedItem().toString();
        Intent i1= new Intent(this, Allthelements.class);
        i1.putExtra("Semester",text );
        i1.putExtra("View", text2);
        startActivity(i1);
    }

}
