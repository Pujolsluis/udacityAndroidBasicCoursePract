package com.example.android.quakereport;

/**
 * Created by Luis on 12/23/2016.
 */

public class Earthquake {
    String magnitude, location, date;

    public Earthquake(String mag, String loc, String Date){
        magnitude = mag;
        location = loc;
        date = Date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
        this.magnitude = magnitude;
    }
}
