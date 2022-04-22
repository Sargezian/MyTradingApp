package com.example.mytradingapp.View.Market;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mytradingapp.Adapter.OnListItemClickListener;
import com.example.mytradingapp.R;
import com.example.mytradingapp.Adapter.StockTitleAdapter;
import com.example.mytradingapp.Shared.Transferobjects.Stock;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;


public class TopActiveFragment extends Fragment implements OnListItemClickListener {



    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private ArrayList<Stock> stockArrayList = new ArrayList<>();
    private TopActiveViewModel topactiveViewmodel;
    private StockTitleAdapter stockTitleAdapter;
    private final DecimalFormat df = new DecimalFormat("0.00");
    private View inflate;
    private Bundle bundle = new Bundle();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        inflate = inflater.inflate(R.layout.fragment_usa, container, false);


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
        df.setRoundingMode(RoundingMode.HALF_UP);
    topactiveViewmodel.getActiveStockLiveData().observe(getViewLifecycleOwner(), stockResponse -> {
        if (stockResponse != null && !stockResponse.isEmpty()){

            progressBar.setVisibility(View.GONE);
            List<Stock> stocks = stockResponse;
            for (Stock stock : stocks) {

                stock.setChangesPercentage(Double.parseDouble(df.format(stock.getChangesPercentage())));
            }
            stockArrayList.addAll(stocks);

            stockTitleAdapter.notifyDataSetChanged();

        }
    });


    }


    @Override
    public void onClick(int position) {
        Toast.makeText(getContext(), "Position: " + position, Toast.LENGTH_SHORT).show();


        bundle.putString("ticker", stockArrayList.get(position).getTicker());
        bundle.putDouble("price",stockArrayList.get(position).getPrice());
        bundle.putDouble("changesPercentage",stockArrayList.get(position).getChangesPercentage());
        bundle.putString("companyName",stockArrayList.get(position).getCompanyName());


        Navigation.findNavController(inflate).navigate(R.id.action_marketFragment_to_stockDetails,bundle);

    }
}