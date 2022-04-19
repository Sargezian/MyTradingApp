package com.example.mytradingapp.View.Market;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.mytradingapp.R;
import com.example.mytradingapp.Shared.Adapter.StockTitleAdapter;
import com.example.mytradingapp.Shared.Transferobjects.Stock;

import java.util.ArrayList;
import java.util.List;


public class TopLosersFragment extends Fragment implements StockTitleAdapter.OnListItemClickListener{


    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ArrayList<Stock> stockArrayList = new ArrayList<>();
    private StockTitleAdapter stockTitleAdapter;
    private TopLosersViewModel topLosersViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_europe, container, false);

        recyclerView = inflate.findViewById(R.id.rv_list2);
        progressBar = inflate.findViewById(R.id.progress_bar2);
        recyclerView.setLayoutManager(new LinearLayoutManager(inflate.getContext()));
        recyclerView.hasFixedSize();
        stockTitleAdapter = new StockTitleAdapter(stockArrayList,this);

        recyclerView.setAdapter(stockTitleAdapter);

        topLosersViewModel = new ViewModelProvider(this).get(TopLosersViewModel.class);


        getLoserStock();




        return inflate;
    }

    private void getLoserStock() {

        topLosersViewModel.getLoserStockResponseLiveData().observe(getViewLifecycleOwner(), stocks -> {

            if (stocks != null && !stocks.isEmpty()){
                progressBar.setVisibility(View.GONE);
                List<Stock> stockList = stocks;
                stockArrayList.addAll(stockList);

                stockTitleAdapter.notifyDataSetChanged();

            }

        });

    }


    @Override
    public void onClick(int position) {

    }
}