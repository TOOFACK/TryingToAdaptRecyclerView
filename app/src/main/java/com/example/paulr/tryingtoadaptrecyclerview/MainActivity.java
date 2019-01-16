package com.example.paulr.tryingtoadaptrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView musicRecycler = findViewById(R.id.musicRecycler);

        ArrayList<Music> musicList = new ArrayList<>();

        musicList.add(new Music("Nirvana", "The most famous aka Court Cobain", R.drawable.nir));
        musicList.add(new Music("Asking Alexandria", "Extreme vocal boys, nobody understand them", R.drawable.askingalexandria));
        musicRecycler.setLayoutManager(new GridLayoutManager(this, 1));
        musicRecycler.setAdapter(new MusicAdapter(musicList));
    }
}
