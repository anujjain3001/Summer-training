package com.example.anujj.attendence.Timetable;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.anujj.attendence.R;

import java.util.Calendar;

public class AddTimeTableActivity extends AppCompatActivity {
    TextView add_DoW_TimeTable_tv, add_Subject_TimeTable_tv, StartTime_tv, EndTime_tv,
            Add_Reminder_in_subject_TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_time_table);
        init();
        listeners();

    }

    private void listeners() {
        add_DoW_TimeTable_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] event = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(AddTimeTableActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                View convertView = (View) inflater.inflate(R.layout.dialog_layout, null);
                alertDialog.setView(convertView);
                alertDialog.setTitle("List");
                final ListView lv = (ListView) convertView.findViewById(R.id.listviewDialog);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(AddTimeTableActivity.this, android.R.layout.simple_list_item_1, event);
                lv.setAdapter(adapter);
                alertDialog.show();

                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String dow = (String) lv.getItemAtPosition(position);
                        add_DoW_TimeTable_tv.setText(dow);
                    }
                });

            }
        });

        startTime();
        EndTime();
    }

    private void EndTime() {

        EndTime_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int hour, minute;
                Calendar cal = Calendar.getInstance();
                hour = cal.get(Calendar.HOUR) + 1;
                minute = cal.get(Calendar.MINUTE);
                EndTime_tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TimePickerDialog timePickerDialog = new TimePickerDialog(AddTimeTableActivity.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                EndTime_tv.setText(hourOfDay + ":" + minute);
                            }
                        }, hour, minute, false);
                        timePickerDialog.show();
                    }
                });

            }
        });
    }

    private void startTime() {

        StartTime_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int hour, minute;
                Calendar cal = Calendar.getInstance();
                hour = cal.get(Calendar.HOUR);
                minute = cal.get(Calendar.MINUTE);
                StartTime_tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        TimePickerDialog timePickerDialog = new TimePickerDialog(AddTimeTableActivity.this, new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                StartTime_tv.setText(hourOfDay + ":" + minute);
                            }
                        }, hour, minute, false);
                        timePickerDialog.show();
                    }
                });
            }
        });
    }

    private void init() {
        add_DoW_TimeTable_tv = (TextView) findViewById(R.id.add_DoW_TimeTable_tv);
        add_Subject_TimeTable_tv = (TextView) findViewById(R.id.add_Subject_TimeTable_tv);
        StartTime_tv = (TextView) findViewById(R.id.StartTime_tv);
        EndTime_tv = (TextView) findViewById(R.id.EndTime_tv);
        Add_Reminder_in_subject_TextView = (TextView) findViewById(R.id.Add_Reminder_in_subject_TextView);
    }
}
