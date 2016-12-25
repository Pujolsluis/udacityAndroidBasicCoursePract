package com.example.android.quakereport;

/**
 * Created by Luis on 12/23/2016.
 */

public class Earthquake {
    private double mMagnitude;
    private String mLocation;
    private String mNearby;
    private Long mDate;

    public Earthquake(double mag, String loc, Long mDate){
        mMagnitude = mag;

        this.mDate = mDate;
        int endOfFirstString = loc.indexOf(" of");
        String nearbyString, locationString;
        if(endOfFirstString == -1){
            nearbyString = "Nearby Of,";
            locationString = loc;
        }else{
            nearbyString = loc.substring(0, endOfFirstString+3)+",";
            locationString = loc.substring(endOfFirstString+4, loc.length());
        }

        mNearby = nearbyString;
        mLocation = locationString;

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

    public String getmNearby() {
        return mNearby;
    }

    public void setmNearby(String mNearby) {
        this.mNearby = mNearby;
    }
}
