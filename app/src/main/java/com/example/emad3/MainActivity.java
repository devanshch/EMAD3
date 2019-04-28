package com.example.emad3;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.app.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.example.app.MESSAGE1";

    //DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void validate(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String n1 = editText.getText().toString();
        EditText n2 = (EditText) findViewById(R.id.pass);

        //databaseReference = FirebaseDatabase.getInstance().getReference("events");//create this main table
        String n3 = n2.getText().toString();
        if (n1.equals("kartik")) {
            if (n3.equals("helloworld")) {
                Intent intent = new Intent(this, DisplayMessageActivity.class);
                intent.putExtra(EXTRA_MESSAGE, n1);
                intent.putExtra(EXTRA_MESSAGE2, n3);
                startActivity(intent);

            } else {
                Toast.makeText(this, "login unsuccessful, check id pass",
                        Toast.LENGTH_LONG).show();
            }
        }
        else{
                Toast.makeText(this, "login unsuccessful, check id, pass",
                        Toast.LENGTH_LONG).show();
            }

    }

    public void soon(View view){
        Intent i2= new Intent(this, soonfunctionality.class);
        startActivity(i2);
    }



}
