package com.example.paulr.tryingtoadaptrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class MusicAdapter extends RecyclerView.Adapter<com.example.paulr.tryingtoadaptrecyclerview.MusicAdapter.MusicVH> {
    List<Music> musicList;


    public MusicAdapter(List<Music> musicList) {
        this.musicList = musicList;
    }



    @NonNull
    @Override
    public MusicVH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View view = inflater.inflate(R.layout.nice_artist, viewGroup, false);

        return new MusicVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MusicVH musicVH, final int i) {
        final Music music = musicList.get(i);

        musicVH.albumImage.setImageResource(music.getAlbunImageId());
        musicVH.artist.setText(music.getArtist());
        musicVH.description.setText(music.getMusic());
        musicVH.artistCard.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                musicList.remove(i);
                notifyItemRemoved(i);
                notifyItemChanged(i);
                return false;
            }
        });
        musicVH.artistCard.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Description.class);
               intent.putExtra("musicObject", music);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return musicList.size();
    }


    class MusicVH extends RecyclerView.ViewHolder implements Serializable{
        private ImageView albumImage;
        private TextView artist;
        private TextView description;
        private CardView artistCard;

        public MusicVH(@NonNull View itemView, ImageView albumImage, TextView artist, TextView description) {
            super(itemView);
            this.albumImage = albumImage;
            this.artist = artist;
            this.description = description;
        }

        public MusicVH(@NonNull View itemView) {
            super(itemView);



            albumImage = itemView.findViewById(R.id.albumImage);
            artist = itemView.findViewById(R.id.artistName);
            description = itemView.findViewById(R.id.artistDescription);
            artistCard = itemView.findViewById(R.id.musicCard);

        }
    }
}
