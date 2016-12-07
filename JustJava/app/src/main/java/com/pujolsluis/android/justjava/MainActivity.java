package com.pujolsluis.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Integer quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increaseQuantity(View v){
        quantity++;
        TextView thankyouTextView = (TextView) findViewById(R.id.textView_thankYou);
        TextView quantityTextView = (TextView) findViewById(R.id.textView_QuantityTotal);
        TextView orderTotalTextView = (TextView) findViewById(R.id.textView_priceTotal);

        if(thankyouTextView.getVisibility() == View.VISIBLE){
            orderTotalTextView.setText("$0");
            thankyouTextView.setVisibility(View.GONE);
        }

        quantityTextView.setText(quantity.toString());

    }

    public void decreaseQuantity(View v){
        TextView thankyouTextView = (TextView) findViewById(R.id.textView_thankYou);
        TextView orderTotalTextView = (TextView) findViewById(R.id.textView_priceTotal);
        TextView quantityTextView = (TextView) findViewById(R.id.textView_QuantityTotal);

        if(thankyouTextView.getVisibility() == View.VISIBLE){
            orderTotalTextView.setText("$0");
            thankyouTextView.setVisibility(View.GONE);
        }

        if(quantity > 0){
            quantity--;
            quantityTextView.setText(quantity.toString());
        }
    }

    public void orderCoffe(View v){
        TextView thankyouTextView = (TextView) findViewById(R.id.textView_thankYou);
        TextView orderTotalTextView = (TextView) findViewById(R.id.textView_priceTotal);

        Integer orderTotal = quantity * 5;
        orderTotalTextView.setText("$" + orderTotal.toString());
        thankyouTextView.setVisibility(View.VISIBLE);
    }

}
