package com.smartherd.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void decrement(View view) {
        quantity = quantity - 1;
        displayOrderOfCoffee(quantity);
    }

    public void increment(View view) {
        quantity = quantity + 1;
        displayOrderOfCoffee(quantity);
    }

    public void updateNumberOfCoffee(View view) {
        displayOrderOfCoffee(quantity);
    }

    private void displayOrderOfCoffee(int val) {
        TextView ordedQuantity = (TextView) findViewById(R.id.number_of_coffee);
        ordedQuantity.setText("" + val);
    }
}