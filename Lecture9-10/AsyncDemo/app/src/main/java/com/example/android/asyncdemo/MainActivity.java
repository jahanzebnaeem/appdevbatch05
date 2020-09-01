package com.example.android.asyncdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    public class BGTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.d("JahanzebBG", "onPreExecute: Ran");
        }

        @Override
        protected String doInBackground(String... urls) {
            Log.d("JahanzebBG", "doInBackground: Started");

            String result = "";
            URL url;
            HttpURLConnection connection;

            try {
                url = new URL(urls[0]);
                connection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                int data = inputStreamReader.read();
                while (data != -1) {
                    char current = (char) data;
                    result += current;
                    data = inputStreamReader.read();
                }

            } catch (Exception e) {
                e.printStackTrace();
                return "Something went wrong";
            }

            Log.d("JahanzebBG", "doInBackground: Completed");
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("JahanzebBG", "onPostExecute: Ran");
            Log.d("JahanzebBG", s);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BGTask bgTask = new BGTask();
        bgTask.execute("https://www.prosoftsol.com/");
    }

    public void showWorking(View view) {
        Log.d("JahanzebBG", "Button Pressed");
        Toast.makeText(this, "This is working", Toast.LENGTH_LONG).show();
    }
}