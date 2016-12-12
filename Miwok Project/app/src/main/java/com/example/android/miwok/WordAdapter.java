package com.example.android.miwok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Luis on 12/10/2016.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int backgroundColor;

    public WordAdapter(Context context, ArrayList<Word> wordList, int color) {
        super(context, 0,wordList);
        backgroundColor = color;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        ImageView image = (ImageView) listItemView.findViewById(R.id.item_imageView);
        if(currentWord.hasImage()){
            image.setImageResource(currentWord.getImageResourceId());
            image.setVisibility(View.VISIBLE);
        }else{
            image.setVisibility(View.GONE);
        }


        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_textView);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView englishTextView = (TextView) listItemView.findViewById(R.id.english_textView);
        englishTextView.setText(currentWord.getEnglishTranslation());

        LinearLayout rootLayout = (LinearLayout) listItemView.findViewById(R.id.rootLinearLayout);
        rootLayout.setBackgroundResource(this.backgroundColor);

        return listItemView;
    }
}
