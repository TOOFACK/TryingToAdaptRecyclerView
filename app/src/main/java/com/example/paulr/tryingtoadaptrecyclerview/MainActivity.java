package com.example.paulr.tryingtoadaptrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.paulr.tryingtoadaptrecyclerview.enities.User;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  implements AsyncResponse {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserTask usersTask = new UserTask(this);
        usersTask.execute();


    }

    @Override
    public void processFinish(ArrayList<User> users) {
        Log.d(MainActivity.class.getName(), String.valueOf(users));
        RecyclerView musicRecycler = findViewById(R.id.musicRecycler);
        musicRecycler.setLayoutManager(new GridLayoutManager(this, 1));
        musicRecycler.setAdapter(new UserAdapter(users));
    }
}
