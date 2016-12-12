package com.example.android.miwok;

/**
 * Created by Luis on 12/10/2016.
 */

public class Word {
    private static final int NO_IMAGE_PROVIDED = -1;
    private String englishTranslation;
    private String miwokTranslation;
    private Integer ImageResourceId = NO_IMAGE_PROVIDED;

    public Word(String miwok, String english, Integer imageID){
        miwokTranslation = miwok;
        englishTranslation = english;
        ImageResourceId = imageID;
    }

    public Word(String miwok, String english){
        miwokTranslation = miwok;
        englishTranslation = english;
    }


    public String getEnglishTranslation() {
        return englishTranslation;
    }

    public void setEnglishTranslation(String englishTranslation) {
        this.englishTranslation = englishTranslation;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }

    public void setMiwokTranslation(String miwokTranslation) {
        this.miwokTranslation = miwokTranslation;
    }

    public Integer getImageResourceId() {
        return ImageResourceId;
    }

    public void setImageResourceId(Integer imageResourceId) {
        this.ImageResourceId = imageResourceId;
    }

    public boolean hasImage(){
        return ImageResourceId != NO_IMAGE_PROVIDED;
    }
}
