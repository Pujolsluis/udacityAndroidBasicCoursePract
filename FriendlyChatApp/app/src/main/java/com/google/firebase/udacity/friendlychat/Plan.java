package com.google.firebase.udacity.friendlychat;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.IgnoreExtraProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Luis on 1/15/2017.
 */

@IgnoreExtraProperties
public class Plan {
    private String mAuthorID;
    private String mTitle;
    private String mDescription = " ";
    private String mImageBannerResource = " ";
    private String mType = " ";
    private String mCreationDate = " ";

    public Plan() {
        // Default constructor required for calls to DataSnapshot.getValue(Post.class)
    }

    public Plan(String author, String title, String creationDate){
        mAuthorID = author;
        mTitle = title;
        mCreationDate = creationDate;
    }

    public String getmAuthorID() {
        return mAuthorID;
    }

    public void setmAuthorID(String mAuthorID) {
        this.mAuthorID = mAuthorID;
    }

    public String getmCreationDate() {
        return mCreationDate;
    }

    public void setmCreationDate(String mCreationDate) {
        this.mCreationDate = mCreationDate;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmImageBannerResource() {
        return mImageBannerResource;
    }

    public void setmImageBannerResource(String mImageBannerResource) {
        this.mImageBannerResource = mImageBannerResource;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("mAuthorID", mAuthorID);
        result.put("mTitle", mTitle);
        result.put("mDescription", mDescription);
        result.put("mImageBannerResource", mImageBannerResource);
        result.put("mType", mType);
        result.put("mCreationDate", mCreationDate);

        return result;
    }
}
