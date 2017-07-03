package com.example.anujj.attendence.Event;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.anujj.attendence.R;

import java.util.Calendar;

public class AddEventActivity extends AppCompatActivity {
    TextView AddEventTypeHeading, StartTimeEditTextEvent, EndTimeEditTextEvent, Add_Reminder_in_Event_TextView;
    EditText add_Subject_Event_EditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        init();

        Intent i = getIntent();
        String eventName = i.getStringExtra("eventName");
        Log.d("123", eventName);
        AddEventTypeHeading.setText(eventName);

        listeners();

    }

    private void listeners() {
        reminderListener();

        //date picker
        StartTimeEditTextEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDate();
            }
        });
        //TIME PICKER
        EndTimeEditTextEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTime();
            }
        });

    }

    private void addDate() {
        final int day,month,year;
        Calendar cal=Calendar.getInstance();
        day= cal.get(Calendar.DAY_OF_MONTH);
        month= cal.get(Calendar.MONTH);
        year=cal.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog=new DatePickerDialog(AddEventActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                StartTimeEditTextEvent.setText(dayOfMonth+"/"+month+"/"+year);
            }
        },year,month,day);
        datePickerDialog.show();


    }

    private void addTime(){
        final int hour,minute;
        Calendar cal=Calendar.getInstance();
       hour= cal.get(Calendar.HOUR);
       minute= cal.get(Calendar.MINUTE);
        EndTimeEditTextEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog=new TimePickerDialog(AddEventActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        EndTimeEditTextEvent.setText(hourOfDay+":"+minute);
                    }
                },hour,minute,false);
                timePickerDialog.show();
            }
        });
    }

    private void reminderListener() {
        Add_Reminder_in_Event_TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("event", "onClick: Add_Reminder_in_Event_TextView ");
            }
        });
    }

    private void init() {
        AddEventTypeHeading = (TextView) findViewById(R.id.AddEventTypeHeading);
        Add_Reminder_in_Event_TextView = (TextView) findViewById(R.id.Add_Reminder_in_Event_TextView);
        add_Subject_Event_EditText = (EditText) findViewById(R.id.add_Subject_Event_EditText);
        StartTimeEditTextEvent = (TextView) findViewById(R.id.StartTimeEditTextEvent);
        EndTimeEditTextEvent = (TextView) findViewById(R.id.EndTimeEditTextEvent);

    }
}
