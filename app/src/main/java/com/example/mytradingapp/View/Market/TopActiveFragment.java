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
import android.widget.Toast;

import com.example.mytradingapp.R;
import com.example.mytradingapp.Shared.Adapter.StockTitleAdapter;
import com.example.mytradingapp.Shared.Transferobjects.Stock;

import java.util.ArrayList;
import java.util.List;


public class TopActiveFragment extends Fragment implements StockTitleAdapter.OnListItemClickListener  {



    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ArrayList<Stock> stockArrayList = new ArrayList<>();
    private TopActiveViewModel topactiveViewmodel;
    private StockTitleAdapter stockTitleAdapter;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_usa, container, false);


        recyclerView = inflate.findViewById(R.id.rv_list);
        progressBar = inflate.findViewById(R.id.progress_bar);
        recyclerView.setLayoutManager(new LinearLayoutManager(inflate.getContext()));
        recyclerView.hasFixedSize();

        stockTitleAdapter = new StockTitleAdapter(stockArrayList,this);

        recyclerView.setAdapter(stockTitleAdapter);

        topactiveViewmodel = new ViewModelProvider(this).get(TopActiveViewModel.class);

       getActiveStocks();



        return inflate;

    }

    private void getActiveStocks() {

    topactiveViewmodel.getActiveStockLiveData().observe(getViewLifecycleOwner(), stockResponse -> {
        if (stockResponse != null && !stockResponse.isEmpty()){

            progressBar.setVisibility(View.GONE);
            List<Stock> stocks = stockResponse;
            stockArrayList.addAll(stocks);

            stockTitleAdapter.notifyDataSetChanged();

        }
    });


    }


    @Override
    public void onClick(int position) {
        Toast.makeText(getContext(), "Position: " + position, Toast.LENGTH_SHORT).show();
    }
}