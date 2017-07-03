package com.example.anujj.attendence.Event;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.anujj.attendence.R;

public class EventActivity extends AppCompatActivity {
    ListView addEventListView;
    TextView addEventTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogMethod();
            }
        });

        init();

    }

    private void dialogMethod() {
        String[] event={"Exam","Homework","Assignment","Tournament"};
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(EventActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View convertView = (View) inflater.inflate(R.layout.dialog_layout, null);
        alertDialog.setView(convertView);
        alertDialog.setTitle("List");
        final ListView lv = (ListView) convertView.findViewById(R.id.listviewDialog);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,event);
        lv.setAdapter(adapter);
        alertDialog.show();
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(EventActivity.this, AddEventActivity.class);
                String eventFromListview= (String) lv.getItemAtPosition(position);
                i.putExtra("eventName",eventFromListview);
                startActivity(i);
            }
        });
    }

    private void init() {
        addEventListView= (ListView) findViewById(R.id.addEventListView);
        addEventTextView= (TextView) findViewById(R.id.addEventTextView);
    }

}
