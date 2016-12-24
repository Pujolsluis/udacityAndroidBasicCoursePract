package com.example.android.quakereport;

/**
 * Created by Luis on 12/23/2016.
 */

public class Earthquake {
    String mMagnitude, mLocation, mDate;

    public Earthquake(String mag, String loc, String mDate){
        mMagnitude = mag;
        mLocation = loc;
        this.mDate = mDate;
    }

    public String getmDate() {
        return mDate;
    }

    public void setmDate(String mDate) {
        this.mDate = mDate;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public String getmMagnitude() {
        return mMagnitude;
    }

    public void setmMagnitude(String mMagnitude) {
        this.mMagnitude = mMagnitude;
    }
}
