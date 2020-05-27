package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
        TextView lm = convertView.findViewById(R.id.list_item_magnitude);
        TextView m = convertView.findViewById(R.id.magnitude);
        TextView ll = convertView.findViewById(R.id.list_item_location);
        TextView l = convertView.findViewById(R.id.location);
        TextView ld = convertView.findViewById(R.id.list_item_date);
        TextView d = convertView.findViewById(R.id.date);
        TextView lu = convertView.findViewById(R.id.list_item_url);
        TextView u = convertView.findViewById(R.id.url);

        lm.setText(R.string.list_item_magnitude);
        m.setText(String.valueOf(ea.getMagnitude()));

        ll.setText(R.string.list_item_location);
        l.setText(String.valueOf(ea.getLocation()));

        ld.setText(R.string.list_item_date);
        d.setText(String.valueOf(ea.getDate()));

        lu.setText(R.string.list_item_url);
        u.setText(String.valueOf(ea.getUrl()));

        return convertView;
    }
}
