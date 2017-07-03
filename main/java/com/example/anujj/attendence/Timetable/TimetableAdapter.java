package com.example.anujj.attendence.Timetable;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.anujj.attendence.R;

import java.util.ArrayList;

/**
 * Created by anujj on 02-07-2017.
 */

public class TimetableAdapter extends ArrayAdapter {
private Context context;
    private int resource;
    private ArrayList<PojoTimtTable> pojoTimtTables=new ArrayList<>();
    private LayoutInflater layoutInflater;

    public TimetableAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<PojoTimtTable> pojoTimtTables) {
        super(context, resource, pojoTimtTables);
        this.context=context;
        this.resource=resource;
        this.pojoTimtTables=pojoTimtTables;
        layoutInflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=layoutInflater.inflate(R.layout.timetable_row_layout,null);
        TextView RowLayoutSubjectTextView= (TextView) view.findViewById(R.id.RowLayoutSubjectTextView);
        TextView RowLayoutStartTimeTextView= (TextView) view.findViewById(R.id.RowLayoutStartTimeTextView);
        TextView RowLayoutEndTimeTextView= (TextView) view.findViewById(R.id.RowLayoutEndTimeTextView);

        PojoTimtTable pojoTimtTable=pojoTimtTables.get(position);

        RowLayoutSubjectTextView.setText(pojoTimtTable.getSubject());
        RowLayoutStartTimeTextView.setText(pojoTimtTable.getDay_of_week()+","+pojoTimtTable.getStart_time());
        RowLayoutEndTimeTextView.setText(pojoTimtTable.getEnd_time());

        return view;
    }
}
