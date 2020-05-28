/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    public static final String LOG_TAG = EarthquakeActivity.class.getName();
    static final String ACTION_GO_TO_URL = "com.example.action.GO_TO_URL";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        // Create a fake list of earthquake locations.
        ArrayList<String> earthquakes = new ArrayList<>();
        earthquakes.add("San Francisco");
        earthquakes.add("London");
        earthquakes.add("Tokyo");
        earthquakes.add("Mexico City");
        earthquakes.add("Moscow");
        earthquakes.add("Rio de Janeiro");
        earthquakes.add("Paris");

        // Create a new {@link ArrayAdapter} of earthquakes
        ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, earthquakes);



        //step 2, add from Query utils
        ArrayList<Earthquake> earthquakes2;
        earthquakes2 = QueryUtils.extractEarthquakes();




        //Override old adapter to use new.
        final EarthQuakeAdapter earthquakeEarthQuakeAdapter;
        earthquakeEarthQuakeAdapter = new EarthQuakeAdapter(
                this, earthquakes2);

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView;
        earthquakeListView = findViewById(R.id.list);


        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(earthquakeEarthQuakeAdapter);
        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String value =  parent.getItemAtPosition(position).toString();
                Toast toast = Toast.makeText(getApplicationContext(), "You pressed + " + value, Toast.LENGTH_LONG);
                toast.setMargin(70, 50);
                toast.show();
                Uri uri = Uri.parse(value);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });



    }
}


