package com.example.android.recylcerwithcard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private LayoutInflater layoutInflater;
    private List<String> data;

    public Adapter(Context context, List<String> data) {
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = layoutInflater.inflate(R.layout.album_card, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        // Bind data
        String albumName = data.get(position);
        holder.album_name.setText(albumName);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView album_name, artist_name;
        ImageView album_image, artist_image;
        Button buy_now;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // Text
            album_name = itemView.findViewById(R.id.album_name);
            artist_name = itemView.findViewById(R.id.artist_name);

            // Image
            artist_image = itemView.findViewById(R.id.artist_image);
            album_image = itemView.findViewById(R.id.album_image);

            // Button
            buy_now = itemView.findViewById(R.id.buy_now);
        }
    }
}
