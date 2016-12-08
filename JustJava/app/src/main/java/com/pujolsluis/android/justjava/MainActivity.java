package com.pujolsluis.android.justjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import static android.content.Intent.ACTION_SEND;
import static android.content.Intent.EXTRA_SUBJECT;
import static android.content.Intent.EXTRA_TEXT;

public class MainActivity extends AppCompatActivity {

    Integer quantity = 0;
    TextView quantityTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantityTextView = (TextView) findViewById(R.id.textView_QuantityTotal);

    }


    public void increaseQuantity(View v){
        quantity++;
        quantityTextView.setText(quantity.toString());

    }

    public void decreaseQuantity(View v){

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

        String bodyText = "Name: " + name + "\n" + "Add whipped cream? " + whippedCream.isChecked() + "\n" + "Add chocolate? " + chocolate.isChecked()
                + "Quantity: " + quantity + "\n" + "Total: $" + orderTotal + "\n" + "Thank you!";

        Intent sendEmail = new Intent(ACTION_SEND);
        sendEmail.setType("text/plain");
        sendEmail.putExtra(EXTRA_SUBJECT, "Just Java order for " + name);
        sendEmail.putExtra(EXTRA_TEXT, bodyText);
        
        if(sendEmail.resolveActivity(getPackageManager()) != null){
            startActivity(sendEmail);
        }
    }

}
