package com.example.android.quakereport;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Luis on 12/23/2016.
 */

public class EarthquakeListAdapter extends ArrayAdapter<Earthquake> {


    public EarthquakeListAdapter(Context context, List<Earthquake> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude_text_view);
        String magnitudeConvert = "" + currentEarthquake.getmMagnitude();
        magnitudeTextView.setText(magnitudeConvert);

        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location_text_view);
        locationTextView.setText(currentEarthquake.getmLocation());

        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text_view);
        String date = "" + currentEarthquake.getmDate();
        Long dateInMilliSeconds = currentEarthquake.getmDate();
        SimpleDateFormat dateFormater = new SimpleDateFormat("MMM DD, yyyy");
        dateTextView.setText(dateFormater.format(dateInMilliSeconds));

        return listItemView;
    }
}
