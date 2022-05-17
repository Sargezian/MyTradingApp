package com.example.mytradingapp.View.Home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mytradingapp.Adapter.OnListItemClickListener;
import com.example.mytradingapp.Adapter.StockTitleAdapter;
import com.example.mytradingapp.R;
import com.example.mytradingapp.Shared.Transferobjects.Stock;
import com.example.mytradingapp.View.Login.LoginActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements OnListItemClickListener {


    private ArrayList<Stock> stockArrayList = new ArrayList<>();
    private StockTitleAdapter stockTitleAdapter;
    private RecyclerView recyclerView;
    private final DecimalFormat df = new DecimalFormat("0.00");


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.hasFixedSize();

        stockTitleAdapter = new StockTitleAdapter(stockArrayList,this);

        recyclerView.setAdapter(stockTitleAdapter);

        getGainersStock();

        return view;
    }

    private void getGainersStock() {
        df.setRoundingMode(RoundingMode.HALF_UP);

        topGainersViewModel.getGainersStockResponseLiveData().observe(getViewLifecycleOwner(),stocks -> {
            if (stocks != null && !stocks.isEmpty()){
                progressBar.setVisibility(View.GONE);
                List<Stock> stockList = stocks;

                for (Stock stock : stockList) {

                    stock.setChangesPercentage(Double.parseDouble(df.format(stock.getChangesPercentage())));
                }
                stockArrayList.clear();
                stockArrayList.addAll(stockList);

                stockTitleAdapter.notifyDataSetChanged();

            }

        });

    }




    @Override
    public void onClick(int position) {

    }
}