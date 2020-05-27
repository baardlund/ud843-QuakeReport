package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class EarthQuakeAdapter extends ArrayAdapter<Earthquake> {


    public EarthQuakeAdapter(Context context, ArrayList<Earthquake> earthquakes){
        super(context, 0, earthquakes);
    }

    public View getView(int position, View convertView, ViewGroup parent){

        //get the data item for this position
        Earthquake ea = getItem(position);

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_earthquakes, parent, false);
        }

        //Lookup view for datapopulation
        TextView lm = (TextView) convertView.findViewById(R.id.list_item_magnitude);
        TextView m = (TextView) convertView.findViewById(R.id.magnitude);
        TextView ll = (TextView) convertView.findViewById(R.id.list_item_location);
        TextView l = (TextView) convertView.findViewById(R.id.location);
        TextView ld = (TextView) convertView.findViewById(R.id.list_item_date);
        TextView d = (TextView) convertView.findViewById(R.id.date);
        TextView lu = (TextView) convertView.findViewById(R.id.list_item_url);
        TextView u = (TextView) convertView.findViewById(R.id.url);

        lm.setText(R.string.list_item_magnitude);
        m.setText(String.valueOf(ea.getMagnitude()));

        lm.setText(R.string.location);
        m.setText(String.valueOf(ea.getLocation()));

        lm.setText(R.string.list_item_date);
        m.setText(String.valueOf(ea.getDate()));

        lm.setText(R.string.list_item_url);
        m.setText(String.valueOf(ea.getUrl()));

        return convertView;
    }
}
