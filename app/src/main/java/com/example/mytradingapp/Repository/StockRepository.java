package com.example.mytradingapp.Repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mytradingapp.API.ServiceGenerator;
import com.example.mytradingapp.API.StockApi;
import com.example.mytradingapp.Shared.Transferobjects.Stock;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StockRepository {

    private static StockRepository instance;
    private final MutableLiveData<List<Stock>> stockList;


    public StockRepository() {
        stockList = new MutableLiveData<>();

    }

    public static synchronized StockRepository getInstance() {

        if (instance == null){
            instance = new StockRepository();
        }

        return instance;
    }


    public LiveData<List<Stock>> getStockList() {
        return stockList;
    }


    public LiveData<List<Stock>> getActiveStocks(){
        StockApi stockApi = ServiceGenerator.getStockApi();
        Call<List<Stock>> call = stockApi.getActiveStocks();

        call.enqueue(new Callback<List<Stock>>() {
            @Override
            public void onResponse(Call<List<Stock>> call, Response<List<Stock>> response) {

                if (response.isSuccessful()){
                    stockList.setValue(response.body());


                    Log.e("Retrofit", "YAYAYAY :(");
                }


            }

            @Override
            public void onFailure(Call<List<Stock>> call, Throwable t) {
                Log.e("Retrofit", "Something went wrong :(");

            }
        });


        return stockList;
    }








}
