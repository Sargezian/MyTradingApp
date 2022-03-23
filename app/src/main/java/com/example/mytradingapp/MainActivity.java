package com.example.mytradingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PostAdapter.OnListItemClickListener {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.hasFixedSize();

        List<Post> posts = new ArrayList<>();

        posts.add(new Post("Stock"));
        posts.add(new Post("Stock1"));
        posts.add(new Post("Stock2"));
        posts.add(new Post("Stock"));
        posts.add(new Post("Stock1"));
        posts.add(new Post("Stock2"));
        posts.add(new Post("Stock"));
        posts.add(new Post("Stock1"));
        posts.add(new Post("Stock2"));
        posts.add(new Post("Stock"));
        posts.add(new Post("Stock1"));
        posts.add(new Post("Stock2"));
        posts.add(new Post("Stock"));
        posts.add(new Post("Stock1"));
        posts.add(new Post("Stock2"));
        posts.add(new Post("Stock"));
        posts.add(new Post("Stock1"));
        posts.add(new Post("Stock2"));

        PostAdapter adapter = new PostAdapter(posts,this);

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(int position) {
        Toast.makeText(this, "Position: " + position, Toast.LENGTH_SHORT).show();
    }
}