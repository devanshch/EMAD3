package com.example.emad3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Allthelements extends AppCompatActivity {

    Button devansh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allthelements);

        devansh = (Button)findViewById(R.id.button2);

        devansh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity(new Intent(Allthelements.this,Cocurricular.class));
            }
        });

    }

    public void course(View view)
    {
        Intent i1= new Intent(this, Course.class);
        startActivity(i1);
    }
    public void soon(View view){
        Intent i2= new Intent(this, soonfunctionality.class);
                startActivity(i2);
    }

}