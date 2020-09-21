package com.example.android.firebasertdbartist;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TrackList extends ArrayAdapter<Track> {
    private Activity context;
    private List<Track> trackList;

    public TrackList (Activity context, List<Track> trackList) {
        super(context, R.layout.layout_track_list, trackList);
        this.context = context;
        this.trackList = trackList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.layout_track_list, null, true);

        TextView textViewName = listViewItem.findViewById(R.id.textViewName);
        TextView textViewRating = listViewItem.findViewById(R.id.textViewRating);

        Track track = trackList.get(position);

        textViewName.setText(track.getTrackName());
        textViewRating.setText(String.valueOf(track.getTrackRating()));

        return listViewItem;
    }
}
