package com.example.paulr.tryingtoadaptrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class Description extends AppCompatActivity {

    private ImageView albumImageV;
    private TextView artistV;
    private TextView descriptionV;
    private Music music;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);


       music = (Music) getIntent().getSerializableExtra("musicObject");

        albumImageV = findViewById(R.id.albumImage2);
        artistV = findViewById(R.id.artistDescription2);
        descriptionV = findViewById(R.id.artistDescription2);

        artistV.setText(music.getArtist());
        albumImageV.setImageResource(music.getAlbunImageId());
        descriptionV.setText(music.getMusic());



    }
}
