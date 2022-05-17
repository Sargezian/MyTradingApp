package com.example.mytradingapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.mytradingapp.API.ServiceGenerator;
import com.example.mytradingapp.API.StockApi;
import com.example.mytradingapp.Adapter.StockSparkAdapter;
import com.example.mytradingapp.Shared.Transferobjects.Historical;
import com.example.mytradingapp.Shared.Transferobjects.StockGraph;
import com.robinhood.spark.SparkView;
import com.robinhood.spark.animation.SparkAnimator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class StockDetails extends Fragment {
    
    private TextView textViewTicker;
    private TextView textViewPrice;
    private TextView textViewProcent;
    private Toolbar toolbar;
    private List<Historical> historicalArrayList = new ArrayList<>();
    private TextView textViewDate;
    private SparkView sparkView;
    private TextView closedPrice;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_stock_details, container, false);

        sparkView = inflate.findViewById(R.id.sparkview);
        textViewTicker = inflate.findViewById(R.id.tv_ticker);
        closedPrice = inflate.findViewById(R.id.tv_closed_price);

        textViewTicker.setText(getArguments().getString("ticker"));

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(getArguments().getString("companyName"));
        textViewPrice = inflate.findViewById(R.id.tv_price);

        textViewPrice.setText(Double.toString(getArguments().getDouble("price")));

        textViewProcent = inflate.findViewById(R.id.tv_procent);
        textViewProcent.setText(Double.toString(getArguments().getDouble("changesPercentage")) + " %");

           textViewDate = inflate.findViewById(R.id.tv_date);
        getChangesPercentage();


        StockApi stockApi = ServiceGenerator.getStockApi();
        Call<StockGraph> call = stockApi.getGraph(textViewTicker.getText().toString());

        call.enqueue(new Callback<StockGraph>() {
            @Override
            public void onResponse(Call<StockGraph> call, Response<StockGraph> response) {
                if (response.isSuccessful()){

                    StockGraph body = response.body();
                    List<Historical> historical = body.getHistorical();
                    Collections.reverse(historical);

                    sparkView.setScrubEnabled(true);
                    sparkView.setScrubListener( t -> {

                        if (t instanceof Historical){
                            updateInfoForDate((Historical) t);
                        }
                    });


                    historicalArrayList = historical;
                    Log.e("test","det virker");
                    updateDisplayWithData(historicalArrayList);

                }
            }

            @Override
            public void onFailure(Call<StockGraph> call, Throwable t) {
                Log.e("Retrofit", "Something went wrong getting Stocks graphs :(" + t);
            }
        });



        ImageView sendStockDetails = inflate.findViewById(R.id.share);

        sendStockDetails.setOnClickListener(this::ShareToFriend);



        return inflate;
    }

    private void updateDisplayWithData(List<Historical> dailyData) {


       StockSparkAdapter stockSparkAdapter = new StockSparkAdapter(dailyData);

       sparkView.setAdapter(stockSparkAdapter);

         updateInfoForDate(dailyData.get(dailyData.size()-1));

    }

    private void updateInfoForDate(Historical historical) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy");
        textViewDate.setText(simpleDateFormat.format(historical.getDate()));
        closedPrice.setText(Double.toString(historical.getClose()));

    }


    public void getChangesPercentage(){
        String s = textViewProcent.getText().toString();

        if (Double.valueOf(textViewProcent.getText().toString().substring(0,s.length()-3)) < 0){
            textViewProcent.setTextColor(ContextCompat.getColor(getContext(),R.color.RED));
        } else if (Double.valueOf(textViewProcent.getText().toString().substring(0,s.length()-3)) == 0){
            textViewProcent.setTextColor(ContextCompat.getColor(getContext(),R.color.grey));
        }
        else {
            textViewProcent.setTextColor(ContextCompat.getColor(getContext(),R.color.GreenColor));
        }
    }



    public void ShareToFriend(View v) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {""});

        intent.putExtra(Intent.EXTRA_SUBJECT,"StockDetails");
        intent.putExtra(Intent.EXTRA_TEXT,"Check this stock out! " + textViewTicker.getText().toString() + " Current price " + closedPrice.getText().toString());

        startActivity(intent);
    }



}