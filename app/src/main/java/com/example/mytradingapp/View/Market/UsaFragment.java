package com.example.mytradingapp.View.Market;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mytradingapp.R;
import com.example.mytradingapp.Shared.Transferobjects.Post;
import com.example.mytradingapp.Shared.Adapter.PostAdapter;

import java.util.ArrayList;
import java.util.List;


public class UsaFragment extends Fragment implements PostAdapter.OnListItemClickListener {



    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_usa, container, false);


        recyclerView = inflate.findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(inflate.getContext()));
        recyclerView.hasFixedSize();

        List<Post> posts = new ArrayList<>();

        posts.add(new Post("AMD"));
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

        recyclerView.setAdapter(adapter);

        return inflate;

    }

    @Override
    public void onClick(int position) {
        Toast.makeText(getContext(), "Position: " + position, Toast.LENGTH_SHORT).show();
    }
}