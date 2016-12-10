package com.example.android.miwok;

/**
 * Created by Luis on 12/10/2016.
 */

public class Word {
    private String englishTranslation;
    private String miwokTranslation;

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
}
