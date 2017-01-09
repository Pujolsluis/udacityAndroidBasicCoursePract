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

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeActivity extends AppCompatActivity implements android.app.LoaderManager.LoaderCallbacks<List<Earthquake> > {

    private static final int EARTHQUAKE_LOADER_ID = 1;
    public static final String LOG_TAG = EarthquakeActivity.class.getName();
    public Context context = this;
    List<Earthquake> earthquakes;
    public static final String USGS_REQUEST_URL = "http://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&eventtype=earthquake&orderby=time&minmag=6&limit=10";
    private EarthquakeListAdapter earthquakeListAdapter;
    private TextView emptyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        earthquakeListAdapter = new EarthquakeListAdapter(this, new ArrayList<Earthquake>());

        // Find a reference to the {@link ListView} in the layout
        ListView earthquakeListView = (ListView) findViewById(R.id.list);

        emptyTextView = (TextView) findViewById(R.id.empty_view);
        earthquakeListView.setEmptyView(emptyTextView);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(earthquakeListAdapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Earthquake currEarthquake = earthquakeListAdapter.getItem(position);
                Uri websiteURL = Uri.parse(currEarthquake.getEarthquakeURL());
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, websiteURL);
                startActivity(websiteIntent);
            }
        });

        // Get a reference to the LoaderManager, in order to interact with loaders.
        android.app.LoaderManager loaderManager = getLoaderManager();

        // Initialize the loader. Pass in the int ID constant defined above and pass in null for
        // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
        // because this activity implements the LoaderCallbacks interface).
        loaderManager.initLoader(EARTHQUAKE_LOADER_ID, null, this);
//        Log.v(LOG_TAG, earthquakes.get(0).getmLocation());


    }


    @Override
    public android.content.Loader<List<Earthquake>> onCreateLoader(int i, Bundle bundle) {
        // Create a new loader for the given URL
        return new EarthquakeLoader(this, USGS_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(android.content.Loader<List<Earthquake>> loader, List<Earthquake> data) {
        emptyTextView.setText(R.string.no_earthquakes);
        // Clear the adapter of previous earthquake data
        earthquakeListAdapter.clear();
        earthquakes = data;

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (earthquakes != null && !earthquakes.isEmpty()) {
            earthquakeListAdapter.addAll(earthquakes);
        }
    }

    @Override
    public void onLoaderReset(android.content.Loader<List<Earthquake>> loader) {
        earthquakeListAdapter.clear();
    }


}
