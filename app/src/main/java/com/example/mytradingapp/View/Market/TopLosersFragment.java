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

import com.example.mytradingapp.Adapter.OnListItemClickListener;
import com.example.mytradingapp.R;
import com.example.mytradingapp.Adapter.StockTitleAdapter;
import com.example.mytradingapp.Shared.Transferobjects.Stock;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class TopLosersFragment extends Fragment implements OnListItemClickListener {


    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ArrayList<Stock> stockArrayList = new ArrayList<>();
    private StockTitleAdapter stockTitleAdapter;
    private TopLosersViewModel topLosersViewModel;

    private final DecimalFormat df = new DecimalFormat("0.00");

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

        df.setRoundingMode(RoundingMode.HALF_UP);
        topLosersViewModel.getLoserStockResponseLiveData().observe(getViewLifecycleOwner(), stocks -> {

            if (stocks != null && !stocks.isEmpty()){
                progressBar.setVisibility(View.GONE);
                List<Stock> stockList = stocks;

                for (Stock stock : stockList) {

                    stock.setChangesPercentage(Double.parseDouble(df.format(stock.getChangesPercentage())));
                }
                stockArrayList.addAll(stockList);

                stockTitleAdapter.notifyDataSetChanged();

            }

        });

    }

    @Override
    public void onClick(int position) {

    }
}