package com.example.emad3;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Course extends AppCompatActivity {

    EditText editTextcoursename;
    EditText editTextduration;
    Button buttonsubmit;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        editTextcoursename = (EditText)findViewById(R.id.editText4);
        editTextduration = (EditText)findViewById(R.id.editText6);
        buttonsubmit = (Button)findViewById(R.id.button9);

        databaseReference = FirebaseDatabase.getInstance().getReference("course");


        buttonsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addCourse();

            }
        });


    }

    public void addCourse(){
        String name = editTextcoursename.getText().toString().trim();
        String duration = editTextduration.getText().toString().trim();

        if (!TextUtils.isEmpty(name)){
            String Id = databaseReference.push().getKey();
            CourseTable event =new CourseTable(Id,name,duration);
            databaseReference.child(Id).setValue(event);
            Toast.makeText(this,"Course Details Entered",Toast.LENGTH_LONG).show();
            register();
        }
        else {
            Toast.makeText(this,"you should enter name",Toast.LENGTH_LONG).show();
        }

    }

    private void register() {
        final DatabaseReference RootReference;
        RootReference=FirebaseDatabase.getInstance().getReference();

        editTextcoursename.setText("");
        editTextduration.setText("");
        RootReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Toast.makeText(Course.this, "Course called", Toast.LENGTH_SHORT).show();

                String Id2 = RootReference.push().getKey();
                CourseTable event20 = dataSnapshot.child("event1").child("name").getValue(CourseTable.class);
                RootReference.child(Id2).setValue(event20);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(Course.this, "Can't store value", Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

    }



}
