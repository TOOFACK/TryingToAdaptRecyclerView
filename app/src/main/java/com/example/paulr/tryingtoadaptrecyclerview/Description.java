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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        Intent intent = new Intent();
        String artist = intent.getStringExtra("artist");
        String description = intent.getStringExtra("description");
        Bundle bundle = this.getIntent().getExtras();
        int pic = bundle.getInt("image");

        albumImageV = findViewById(R.id.ImageDes);
        artistV = findViewById(R.id.artistDes);
        descriptionV = findViewById(R.id.DesDes);

        artistV.setText(artist);
        descriptionV.setText(description);



    }
}
