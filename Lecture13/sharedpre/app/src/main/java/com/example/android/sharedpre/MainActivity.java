package com.example.android.sharedpre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mDisplayMessage;
    EditText mPreferredText;
    Button mSavePreference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDisplayMessage = findViewById(R.id.lbl_display_shared_preference);
        mPreferredText = findViewById(R.id.txt_display_shared_preference);
        mSavePreference = findViewById(R.id.btn_add_shared_preference);

        mSavePreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textEntered = mPreferredText.getText().toString();

                SharedPreferences sharedPreference = getSharedPreferences("demo", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreference.edit();

                editor.putString("str", textEntered);
                editor.apply();
                mDisplayMessage.setText(textEntered);
            }
        });

        SharedPreferences getPreference = getSharedPreferences("demo", MODE_PRIVATE);
        String value = getPreference.getString("str", "No shared prefernece found");
        mDisplayMessage.setText(value);
    }
}