package com.example.android.firebasertdbartist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AddTrackActivity extends AppCompatActivity {

    TextView textViewArtistName;
    EditText editTextTrackName;
    SeekBar seekBarRating;

    Button buttonAddTrack;

    ListView listViewTracks;
    DatabaseReference databaseTrack;
    List<Track> trackList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_track);

        textViewArtistName = findViewById(R.id.textViewArtistName);
        editTextTrackName = findViewById(R.id.editTextTrackName);
        seekBarRating = findViewById(R.id.seekBarRating);

        buttonAddTrack = findViewById(R.id.buttonAddTrack);
        listViewTracks = findViewById(R.id.listViewTracks);

        Intent intent = getIntent();

        String id = intent.getStringExtra(MainActivity.ARTIST_ID);
        String name = intent.getStringExtra(MainActivity.ARTIST_NAME);

        textViewArtistName.setText(name);

        databaseTrack = FirebaseDatabase.getInstance().getReference("tracks").child(id);

        trackList = new ArrayList<>();

        buttonAddTrack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addTrack();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseTrack.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                trackList.clear();

                for(DataSnapshot trackSnapshot: snapshot.getChildren()) {
                    Track track = trackSnapshot.getValue(Track.class);
                    trackList.add(track);
                }

                TrackList trackListAdapter = new TrackList(AddTrackActivity.this, trackList);
                listViewTracks.setAdapter(trackListAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void addTrack() {
        String trackName = editTextTrackName.getText().toString().trim();
        int rating = seekBarRating.getProgress();

        if(!TextUtils.isEmpty(trackName)) {
            String id = databaseTrack.push().getKey();

            Track track = new Track(id, trackName, rating);

            databaseTrack.child(id).setValue(track);

            Toast.makeText(this, "Track saved successfully", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Track name should not be empty", Toast.LENGTH_LONG).show();
        }
    }
}