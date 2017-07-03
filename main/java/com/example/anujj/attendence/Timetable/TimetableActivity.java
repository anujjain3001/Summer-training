package com.example.anujj.attendence.Timetable;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.anujj.attendence.R;

public class TimetableActivity extends AppCompatActivity {
    ListView MonTimeTableListView, TueTimeTableListView, wedTimeTableListView, thuTimeTableListView,
            friTimeTableListView, satTimeTableListView, sunTimeTableListView;
    TextView MonTimeTableTextview, TueTimeTableTextview, wedTimeTableTextview, thuTimeTableTextview,
            friTimeTableTextview, satTimeTableTextview, sunTimeTableTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageResource(R.drawable.add);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(TimetableActivity.this, AddTimeTableActivity.class);
                startActivity(i);
            }
        });

        init();
    }

    private void init() {
        //list view find view by id
        MonTimeTableListView = (ListView) findViewById(R.id.MonTimeTableListView);
        TueTimeTableListView = (ListView) findViewById(R.id.TueTimeTableListView);
        wedTimeTableListView = (ListView) findViewById(R.id.wedTimeTableListView);
        thuTimeTableListView = (ListView) findViewById(R.id.thuTimeTableListView);
        friTimeTableListView = (ListView) findViewById(R.id.friTimeTableListView);
        satTimeTableListView = (ListView) findViewById(R.id.satTimeTableListView);
        sunTimeTableListView = (ListView) findViewById(R.id.sunTimeTableListView);
        //text view find view by id
        MonTimeTableTextview = (TextView) findViewById(R.id.MonTimeTableTextview);
        TueTimeTableTextview = (TextView) findViewById(R.id.TueTimeTableTextview);
        wedTimeTableTextview = (TextView) findViewById(R.id.wedTimeTableTextview);
        thuTimeTableTextview = (TextView) findViewById(R.id.thuTimeTableTextview);
        friTimeTableTextview = (TextView) findViewById(R.id.friTimeTableTextview);
        satTimeTableTextview = (TextView) findViewById(R.id.satTimeTableTextview);
        sunTimeTableTextview = (TextView) findViewById(R.id.sunTimeTableTextview);
    }

}
