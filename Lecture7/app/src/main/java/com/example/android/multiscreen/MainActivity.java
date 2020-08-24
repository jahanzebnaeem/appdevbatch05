package com.example.android.multiscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String MSG = "com.example.android.multiscreen.ORDER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setOrder(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        TextView orderItem1 = findViewById(R.id.txt_order_item_1);
        TextView orderItem2 = findViewById(R.id.txt_order_item_2);
        TextView orderItem3 = findViewById(R.id.txt_order_item_3);

        String message = "Your order for Items " +
                orderItem1.getText().toString() + ", " +
                orderItem2.getText().toString() + " & " +
                orderItem3.getText().toString() + " has been placed.";

        Log.d("MainActivity.java", message);
        intent.putExtra(MSG, message);
        startActivity(intent);
    }
}