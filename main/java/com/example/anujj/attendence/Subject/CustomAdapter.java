package com.example.anujj.attendence.Subject;

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
 * Created by anujj on 01-07-2017.
 */

public class CustomAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private ArrayList<PojoSubject> pojoSubjects=new ArrayList<>();
    LayoutInflater inflater;
    public CustomAdapter(@NonNull Context context, @LayoutRes int resource, ArrayList<PojoSubject> pojoSubjects) {
        super(context, resource, pojoSubjects);
        this.context=context;
        this.resource=resource;
        this.pojoSubjects=pojoSubjects;
        inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       View view =inflater.inflate(R.layout.subject_row_layout,null);
        TextView subjectName= (TextView) view.findViewById(R.id.subjectName);
        TextView subjectNameShort= (TextView) view.findViewById(R.id.subjectNameShort);
        TextView teacherName= (TextView) view.findViewById(R.id.teacherName);

        PojoSubject pojoSubject=pojoSubjects.get(position);

        subjectName.setText(pojoSubject.getSubName());
        subjectNameShort.setText(pojoSubject.getSubNameShort());
        teacherName.setText(pojoSubject.getTeacherName());




        return super.getView(position, convertView, parent);
    }
}
