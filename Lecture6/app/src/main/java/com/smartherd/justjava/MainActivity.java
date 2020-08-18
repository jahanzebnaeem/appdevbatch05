package com.smartherd.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void decrement(View view) {
        if(quantity <= 0) {
            quantity = 0;
        } else {
            quantity = quantity - 1;
        }
        displayOrderOfCoffee(quantity);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        displayOrderOfCoffee(quantity);
    }

    public void updateNumberOfCoffee(View view) {
        Double d = Double.valueOf(quantity);
//        displayCalculatedPrice(d * 0.18);
        String message = "Total: " + convertToCurrency(d * 0.18);
        message = message + "\nThank you!";
        displayMessage(message);
    }

    private void displayOrderOfCoffee(int val) {
        TextView orderdQuantity = (TextView) findViewById(R.id.number_of_coffee);
        orderdQuantity.setText("" + val);
    }

    private void displayCalculatedPrice(double price) {
        TextView orderPrice = (TextView) findViewById(R.id.ordered_price);
        orderPrice.setText(NumberFormat.getCurrencyInstance().format(price));
    }

    private String convertToCurrency(double price) {
        return NumberFormat.getCurrencyInstance().format(price);
    }

    private void displayMessage(String message) {
        TextView orderdPrice = (TextView) findViewById(R.id.ordered_price);
        orderdPrice.setText(message);
    }
}