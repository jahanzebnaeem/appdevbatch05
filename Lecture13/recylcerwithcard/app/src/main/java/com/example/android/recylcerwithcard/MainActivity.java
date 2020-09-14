package com.example.android.recylcerwithcard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Adapter adapter;
    List<Model> models;
    private static String JSON_URL = "https://rallycoding.herokuapp.com/api/music_albums";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_main);
        models = new ArrayList<Model>();
        loadModels();

    }

    private void loadModels() {
        final RequestQueue requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                for(int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject obj = response.getJSONObject(i);
                        Log.d("QueLog", "onResponse: " + obj.getString("title"));

                        Model model = new Model();
                        model.setAlbumTitle(obj.getString("title"));
                        model.setArtistName(obj.getString("artist"));
                        model.setAlbumUrl(obj.getString("image"));
                        model.setArtistUrl(obj.getString("thumbnail_image"));
                        model.setBtnUrl(obj.getString("url"));

                        models.add(model);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new Adapter(getApplicationContext(), models);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("QueLog", "Something went wrong");
                Toast.makeText(MainActivity.this, "Someting went wrong", Toast.LENGTH_LONG);
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}