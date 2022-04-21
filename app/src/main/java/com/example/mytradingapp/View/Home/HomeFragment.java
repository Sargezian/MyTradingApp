package com.example.mytradingapp.View.Home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mytradingapp.R;
import com.example.mytradingapp.View.StockView.StockFragment;


public class HomeFragment extends Fragment {

    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        button = view.findViewById(R.id.stockView);
        button.setOnClickListener(this::onClick);

        // Inflate the layout for this fragment
        return view;
    }

    public void onClick(View view ) {
        FragmentTransaction fr = getFragmentManager().beginTransaction();
        fr.replace(R.id.nav_host_fragment, new StockFragment());
        fr.commit();
    }


}