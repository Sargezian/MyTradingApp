package com.example.mytradingapp.View.Search;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.os.Looper;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.mytradingapp.R;
import com.example.mytradingapp.Shared.Transferobjects.Stock;
import com.example.mytradingapp.Shared.Transferobjects.StockSearch;

import java.util.ArrayList;


public class SearchFragment extends Fragment {


    private EditText editText;
    private SearchViewModel viewModel;
    private TextView companyName;
    private TextView stockPrice;
    private TextView tickerName;
    private TextView percent;
    private TextView error;
    private Bundle bundle = new Bundle();
    private MutableLiveData<Stock> stockArrayList = new MutableLiveData<>();

    private Button button;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

         view = inflater.inflate(R.layout.fragment_search, container, false);

        editText = view.findViewById(R.id.editText);
        companyName = view.findViewById(R.id.companyName);
        stockPrice = view.findViewById(R.id.price);
        tickerName = view.findViewById(R.id.ticker);

        percent = view.findViewById(R.id.changesPercentage);

        error = view.findViewById(R.id.tv_error);


        button = view.findViewById(R.id.button);

        viewModel = new ViewModelProvider(this).get(SearchViewModel.class);

        LiveData<StockSearch> searchedStock = viewModel.getSearchedStock();



        searchedStock.observe(getViewLifecycleOwner(), stock -> {

            tickerName.setText(stock.getSymbol());

            companyName.setText(stock.getCompanyName());
            stockPrice.setText(Double.toString(stock.getPrice()));
            percent.setText(Double.toString(stock.getChanges()));
            getChangesPercentage();
            stockArrayList.setValue(new Stock(stock.getSymbol(),stock.getPrice(),stock.getChanges(),stock.getCompanyName()));
            error.setText("");

        });

        button.setOnClickListener(this::searchForStock);

        tickerName.setOnClickListener(this::details);
        companyName.setOnClickListener(this::details);
        stockPrice.setOnClickListener(this::details);
        percent.setOnClickListener(this::details);


        return view;
    }

    private void details(View view) {

        bundle.putString("ticker", stockArrayList.getValue().getTicker());
        bundle.putDouble("price",stockArrayList.getValue().getPrice());
        bundle.putDouble("changesPercentage",stockArrayList.getValue().getChangesPercentage());
        bundle.putString("companyName",stockArrayList.getValue().getCompanyName());


        Navigation.findNavController(view).navigate(R.id.action_searchFragment_to_stockDetails,bundle);
    }

    public void searchForStock(View view) {
        LiveData<StockSearch> stockSearchLiveData = viewModel.searchForStock(editText.getText().toString());
            companyName.setText("");
            tickerName.setText("");
            stockPrice.setText("");
            percent.setText("");
            percent.setBackgroundResource(R.color.DarkTheme);


        Handler handler = new Handler(Looper.getMainLooper());

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (companyName.getText().toString().isEmpty()){
                    error.setText("Please Enter a Valid Ticker");
                    return;
                }

            }
        },500);


    }


    public void getChangesPercentage(){
        String s = percent.getText().toString();

        if (Double.valueOf(percent.getText().toString().substring(0,s.length()-3)) < 0){
            percent.setBackgroundResource(R.color.RED);
        } else if (Double.valueOf(percent.getText().toString().substring(0,s.length()-3)) == 0){
            percent.setBackgroundResource(R.color.grey);
        }
        else {
            percent.setBackgroundResource(R.color.GreenColor);
        }
    }



}