package com.example.myapplication;


import static android.content.ContentValues.TAG;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class First_Question extends AppCompatActivity {
EditText name;
Button button;
FirebaseFirestore db;
DatePickerDialog picker;
TimePickerDialog timePickerDialog;
    EditText date;
    EditText time;
    EditText topics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_ques);
        name=findViewById(R.id.Name);
        button = findViewById(R.id.sub);
        db=FirebaseFirestore.getInstance();
        date=(EditText) findViewById(R.id.Date);
        time=findViewById(R.id.Time);
        topics=findViewById(R.id.Topics);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                picker= new DatePickerDialog(First_Question.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        date.setText(dayOfMonth+"/"+(monthOfYear+1)+"/"+year);
                    }
                },year,month,day);
                picker.show();
            }
        });
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePickerDialog = new TimePickerDialog(First_Question.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        time.setText(hourOfDay+":"+minute);
                    }
                },0,0,false);
                timePickerDialog.show();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dat= date.getText().toString().trim();
               //button.setVisibility(View.GONE);
                String nam = name.getText().toString().trim();
                String tim = time.getText().toString().trim();
                String topic = topics.getText().toString().trim();
                if(nam.isEmpty()){
                    Toast.makeText(v.getContext(), "Name can't be empty", Toast.LENGTH_SHORT).show();
                    name.requestFocus();
                    return;
                }
                else if(dat.isEmpty()){
                    Toast.makeText(v.getContext(), "date can't be empty", Toast.LENGTH_SHORT).show();
                    date.requestFocus();
                    return;

                }
                else if (tim.isEmpty()){

                    Toast.makeText(v.getContext(), "date can't be empty", Toast.LENGTH_SHORT).show();
                    date.requestFocus();
                    return;
                }


                Map<String, Object> city = new HashMap<>();
                city.put("name",nam);
                city.put("date",dat);
                city.put("time",tim);

                city.put("topics",topic);

                db.collection("Exam").document(nam).set(city).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Log.d(TAG, "DocumentSnapshot successfully written!");
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG,"Error writing document",e);
                    }
                });
                finish();
                Fragment fragment = new First();
                FragmentManager fragmentManager=getSupportFragmentManager();

                fragmentManager.beginTransaction().replace(R.id.fi,fragment).addToBackStack(null).commit();

            }
        });
    }








}
