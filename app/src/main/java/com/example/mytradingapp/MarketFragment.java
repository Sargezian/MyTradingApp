package com.example.mytradingapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MarketFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MarketFragment extends Fragment  implements PostAdapter.OnListItemClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private RecyclerView recyclerView;

    public MarketFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MarketFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MarketFragment newInstance(String param1, String param2) {
        MarketFragment fragment = new MarketFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_market, container, false);


        recyclerView = inflate.findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(inflate.getContext()));
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

        recyclerView.setAdapter(adapter);

        return inflate;


    }

    @Override
    public void onClick(int position) {
        Toast.makeText(getContext(), "Position: ", Toast.LENGTH_SHORT).show();
    }
}