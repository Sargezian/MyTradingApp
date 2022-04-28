package com.example.mytradingapp.Repository;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mytradingapp.API.ServiceGenerator;
import com.example.mytradingapp.API.StockApi;
import com.example.mytradingapp.Shared.Transferobjects.Stock;
import com.example.mytradingapp.Shared.Transferobjects.StockGraph;
import com.example.mytradingapp.Shared.Transferobjects.StockSearch;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class StockRepository {

    private static StockRepository instance;
    private final MutableLiveData<List<Stock>> stockList;
    private final MutableLiveData<List<Stock>> stockList2;
    private final MutableLiveData<List<Stock>> stockList3;
    private final MutableLiveData<List<StockGraph>> stockGraphList;

    private final MutableLiveData<StockSearch> searchedStock;


    public StockRepository() {
        stockList = new MutableLiveData<>();
        stockList2 = new MutableLiveData<>();
        stockList3 = new MutableLiveData<>();
        stockGraphList = new MutableLiveData<>();
        searchedStock = new MutableLiveData<>();

    }

    public static synchronized StockRepository getInstance() {

        if (instance == null){
            instance = new StockRepository();
        }

        return instance;
    }

    public LiveData<StockSearch> getSearchedStock() {
        return searchedStock;
    }

    public LiveData<List<Stock>> getStockList() {
        return stockList;
    }

    public MutableLiveData<List<Stock>> getStockList2() {
        return stockList2;
    }

    public void searchForStock(String name) {
        StockApi stockApi = ServiceGenerator.getStockApi();
        Call<List<StockSearch>> call = stockApi.getStock(name);

        call.enqueue(new Callback<List<StockSearch>>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<List<StockSearch>> call, Response<List<StockSearch>> response) {

                if (response.isSuccessful()) {
                    searchedStock.setValue(response.body().get(0).getStock());

                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<List<StockSearch>> call, Throwable t) {
                Log.i("Retrofit", t.getMessage());
            }
        });
    }


    public LiveData<List<Stock>> getActiveStocks(){
        StockApi stockApi = ServiceGenerator.getStockApi();
        Call<List<Stock>> call = stockApi.getActiveStocks();

        call.enqueue(new Callback<List<Stock>>() {
            @Override
            public void onResponse(Call<List<Stock>> call, Response<List<Stock>> response) {

                if (response.isSuccessful()){
                    stockList.setValue(response.body());

                }


            }

            @Override
            public void onFailure(Call<List<Stock>> call, Throwable t) {
                Log.e("Retrofit", "Something went wrong getting active Stocks :(");

            }
        });


        return stockList;
    }

    public LiveData<List<Stock>>getLoserStocks(){
        StockApi stockApi = ServiceGenerator.getStockApi();
        Call<List<Stock>>call = stockApi.getLosersStock();

        call.enqueue(new Callback<List<Stock>>() {
            @Override
            public void onResponse(Call<List<Stock>> call, Response<List<Stock>> response) {
                if (response.isSuccessful()){
                    stockList2.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Stock>> call, Throwable t) {
                Log.e("Retrofit", "Something went wrong getting losers Stocks :(");

            }
        });

        return stockList2;
    }

    public LiveData<List<Stock>>getGainersStock(){
        StockApi stockApi = ServiceGenerator.getStockApi();
        Call<List<Stock>> call = stockApi.getGainersStock();

        call.enqueue(new Callback<List<Stock>>() {
            @Override
            public void onResponse(Call<List<Stock>> call, Response<List<Stock>> response) {

                if (response.isSuccessful()){
                    stockList3.setValue(response.body());
                    Log.e("Retrofit", "getting Gainers Stocks :(");
                }
            }

            @Override
            public void onFailure(Call<List<Stock>> call, Throwable t) {

                Log.e("Retrofit", "Something went wrong getting Gainers Stocks :(");
            }
        });

        return stockList3;

    }



    public LiveData<List<StockGraph>>getStockGraph(String name){

//        StockApi stockApi = ServiceGenerator.getStockApi();
//        Call<List<StockGraph>> call = stockApi.getGraph(name);
//
//        call.enqueue(new Callback<List<StockGraph>>() {
//            @Override
//            public void onResponse(Call<List<StockGraph>> call, Response<List<StockGraph>> response) {
//                   if (response.isSuccessful()){
//
//
//                       List<StockGraph> body = response.body();
//                       Collections.reverse(body);
//                       stockGraphList.setValue(body);
//                   }
//            }
//
//            @Override
//            public void onFailure(Call<List<StockGraph>> call, Throwable t) {
//                Log.e("Retrofit", "Something went wrong getting Stocks graphs :(" + t);
//            }
//        });

        return stockGraphList;

    }


}
