package com.example.emad3;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;

public class Cocurricular extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.emad3.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.example.emad3.MESSAGE1";

    EditText editTextname;
    EditText editTextvenue;
    Button buttonsubmit;
    TextView textViewstart;
    TextView textViewend;
    DatabaseReference databaseReference;

    DatePickerDialog.OnDateSetListener setListener;
    DatePickerDialog.OnDateSetListener setListener1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocurricular);
        editTextname=(EditText)findViewById(R.id.editText3);
        editTextvenue=(EditText)findViewById(R.id.editText8);
        textViewstart = findViewById(R.id.startdate);
        textViewend = findViewById(R.id.enddate);
        buttonsubmit = (Button)findViewById(R.id.button8);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        Calendar calendar1 = Calendar.getInstance();
        final int year1 = calendar1.get(Calendar.YEAR);
        final int month1 = calendar1.get(Calendar.MONTH);
        final int day1 = calendar1.get(Calendar.DAY_OF_MONTH);
        //FirebaseApp.initializeApp(this);
        databaseReference = FirebaseDatabase.getInstance().getReference("events");


        buttonsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addEvent();

            }
        });




        textViewstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Cocurricular.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        setListener, year, month, day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker v, int year, int month, int day) {
                month = month + 1;
                String date = day + "/" + month + "/" + year;
                textViewstart.setText(date);

            }
        };

        textViewend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v1) {
                DatePickerDialog datePickerDialog1 = new DatePickerDialog(
                        Cocurricular.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        setListener1, year1, month1, day1);

                datePickerDialog1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog1.show();
            }
        });
        setListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker v1, int year1, int month1, int day1) {
                month1 = month1 + 1;
                String date1 = day1 + "/" + month1 + "/" + year1;
                textViewend.setText(date1);
            }


        };

    }


    ///ayush edited section started
    public void addEvent(){
        String name = editTextname.getText().toString().trim();
        String venue = editTextvenue.getText().toString().trim();
        String start= textViewstart.getText().toString().trim();
        String end= textViewend.getText().toString().trim();

        if (!TextUtils.isEmpty(name)){
            String Id = databaseReference.push().getKey();
            Event2 event =new Event2(Id, name, start, end, venue );
            databaseReference.child(Id).setValue(event);
            Toast.makeText(this,"Event Details Entered",Toast.LENGTH_LONG).show();
            register();
        }
        else {
            Toast.makeText(this,"you should enter name",Toast.LENGTH_LONG).show();
        }

    }

    private void register() {
        final DatabaseReference RootReference;
        RootReference=FirebaseDatabase.getInstance().getReference();

        editTextname.setText("");
        editTextvenue.setText("");
        RootReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Toast.makeText(Cocurricular.this, "Cocurricular called", Toast.LENGTH_SHORT).show();

                String Id2 = RootReference.push().getKey();
                Event2 event20 = dataSnapshot.child("event1").child("name").getValue(Event2.class);
                RootReference.child(Id2).setValue(event20);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Cocurricular.this, "Can't store value", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

    }

    //ayush edited section ends
}