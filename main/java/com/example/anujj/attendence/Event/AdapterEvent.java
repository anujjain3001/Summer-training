package com.example.anujj.attendence.Event;

import android.content.Context;
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

public class AdapterEvent extends ArrayAdapter {
    private Context context;
    private int resource;
    private ArrayList<PojoEvent> pojoevents=new ArrayList<>();
    LayoutInflater inflaterEvent;

    public AdapterEvent(Context context,int resource,ArrayList<PojoEvent> pojoevents ) {
        super(context, resource, pojoevents);
        this.context=context;
        this.resource=resource;
        this.pojoevents=pojoevents;
        inflaterEvent= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=inflaterEvent.inflate(R.layout.event_row_layout,null);
        TextView addEventItemTextView= (TextView) view.findViewById(R.id.addEventItemTextView);
        TextView addEventTimeTextView = (TextView) view.findViewById(R.id.addEventTimeTextView);

        PojoEvent pojoEvent=pojoevents.get(position);

        addEventItemTextView.setText(pojoEvent.getWhatEvent());
        addEventTimeTextView.setText(pojoEvent.getDate()+ "\n" +pojoEvent.getTime());



        return view;
    }
}
