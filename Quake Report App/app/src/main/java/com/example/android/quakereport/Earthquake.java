package com.example.android.quakereport;

/**
 * Created by Luis on 12/23/2016.
 */

public class Earthquake {
    private double mMagnitude;
    private String mLocation;
    private Long mDate;

    public Earthquake(double mag, String loc, Long mDate){
        mMagnitude = mag;
        mLocation = loc;
        this.mDate = mDate;
    }

    public Long getmDate() {
        return mDate;
    }

    public void setmDate(Long mDate) {
        this.mDate = mDate;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public double getmMagnitude() {
        return mMagnitude;
    }

    public void setmMagnitude(double mMagnitude) {
        this.mMagnitude = mMagnitude;
    }
}
