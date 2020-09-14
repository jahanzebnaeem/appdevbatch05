package com.example.android.recylcerwithcard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private LayoutInflater layoutInflater;
    private List<Model> data;

    public Adapter(Context context, List<Model> data) {
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
        String albumTitle = data.get(position).albumTitle;
        String artistName = data.get(position).artistName;
        String albumUrl = data.get(position).albumUrl;
        String artistUrl = data.get(position).artistUrl;
        String btnUrl = data.get(position).btnUrl;

        holder.album_name.setText(albumTitle);
        holder.artist_name.setText(artistName);
        Picasso.get().load(albumUrl).into(holder.album_image);
        Picasso.get().load(artistUrl).into(holder.artist_image);
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
