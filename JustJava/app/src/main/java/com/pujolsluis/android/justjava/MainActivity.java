package com.pujolsluis.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Integer quantity = 0;
    TextView thankyouTextView;
    TextView orderTotalTextView;
    TextView quantityTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thankyouTextView = (TextView) findViewById(R.id.textView_thankYou);
        quantityTextView = (TextView) findViewById(R.id.textView_QuantityTotal);
        orderTotalTextView = (TextView) findViewById(R.id.textView_priceTotal);

    }


    public void increaseQuantity(View v){
        quantity++;

        if(thankyouTextView.getVisibility() == View.VISIBLE){
            orderTotalTextView.setText("$0");
            thankyouTextView.setVisibility(View.GONE);
        }

        quantityTextView.setText(quantity.toString());

    }

    public void decreaseQuantity(View v){

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
        EditText customerName = (EditText) findViewById(R.id.editText_personName);
        Integer orderTotal = quantity * 5;

        CheckBox whippedCream = (CheckBox) findViewById(R.id.checkBox_whippedCream);
        CheckBox chocolate = (CheckBox) findViewById(R.id.checkBox_chocolate);

        String name = customerName.getText().toString();

        if(whippedCream.isChecked()) orderTotal++;
        if(chocolate.isChecked()) orderTotal += 2;

        orderTotalTextView.setText("$" + orderTotal.toString());
        thankyouTextView.setText("Thank you! " + name);
        thankyouTextView.setVisibility(View.VISIBLE);
    }

}
