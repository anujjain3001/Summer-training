package com.example.anujj.attendence;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.bumptech.glide.Glide;
import com.example.anujj.attendence.Event.EventActivity;
import com.example.anujj.attendence.Settings.settingsActivity;
import com.example.anujj.attendence.Subject.SubjectActivity;
import com.example.anujj.attendence.Timetable.TimetableActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    ImageButton MainScreenSubjects, MainScreenEvent, MainScreenMark,MainScreenAttendImg;
    CircleImageView MainScreenTimeTable,MainScreenSettings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        listeners();

    }

    private void init() {
        //img btn find view by id
        MainScreenSubjects = (ImageButton) findViewById(R.id.MainScreenSubjects);
        MainScreenTimeTable = (CircleImageView) findViewById(R.id.MainScreenTimeTable);
        MainScreenEvent = (ImageButton) findViewById(R.id.MainScreenEvent);
        MainScreenMark = (ImageButton) findViewById(R.id.MainScreenMark);
        MainScreenSettings = (CircleImageView) findViewById(R.id.MainScreenSettings);
        MainScreenAttendImg = (ImageButton) findViewById(R.id.MainScreenAttendImg);


    }

    private void intentFunctions() {
        goTosubjects();
        goToEvent();
        goToWeek();
        goToSettings();
    }

    private void listeners() {
        subjectListener();
        timetableListener();
        eventListener();
        marksLitsenr();
        settigsListener();
    attnedanceListener();
    }

    private void attnedanceListener() {


    }

    private void subjectListener() {
        Glide.with(MainActivity.this)
                .asBitmap()
                .load(R.drawable.book_icon)
                .into(MainScreenSubjects);

        MainScreenSubjects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTosubjects();
            }
        });
    }

    private void timetableListener() {
        Glide.with(MainActivity.this)
                .asBitmap()
                .load(R.drawable.clock)
                .into(MainScreenTimeTable);

        MainScreenTimeTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToWeek();
            }
        });
    }

    private void eventListener() {
        Glide.with(MainActivity.this)
                .load(R.drawable.schedule_icon)
                .into(MainScreenEvent);

        MainScreenEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToEvent();
            }
        });

    }

    private void marksLitsenr() {
        Glide.with(MainActivity.this)
                .asBitmap()
                .load(R.drawable.calculator_icon)
                .into(MainScreenMark);
    }

    private void settigsListener() {
        Glide.with(MainActivity.this)
                .asBitmap()
                .load(R.drawable.settings)
                .into(MainScreenSettings);
        MainScreenSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToSettings();
            }
        });


    }


    private void goToSettings() {
        Intent i = new Intent(MainActivity.this, settingsActivity.class);
        startActivity(i);
    }

    private void goToWeek() {
        Intent j = new Intent(MainActivity.this, TimetableActivity.class);
        startActivity(j);
    }

    private void goToEvent() {
        Intent k = new Intent(MainActivity.this, EventActivity.class);
        startActivity(k);
    }

    private void goTosubjects() {
        Intent i = new Intent(MainActivity.this, SubjectActivity.class);
        startActivity(i);
    }


}

