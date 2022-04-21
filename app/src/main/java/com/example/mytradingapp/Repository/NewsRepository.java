package com.example.mytradingapp.Repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mytradingapp.API.ServiceGenerator;
import com.example.mytradingapp.API.StockApi;
import com.example.mytradingapp.Shared.Transferobjects.News;
import com.example.mytradingapp.Shared.Transferobjects.Stock;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class NewsRepository {

    private static NewsRepository instance;
    private final MutableLiveData<List<News>>stockNews;


    private NewsRepository() {
        stockNews = new MutableLiveData<>();
    }

    public static synchronized NewsRepository getInstance() {
        if (instance == null) {
            instance = new NewsRepository();
        }
        return instance;
    }

    public LiveData<List<News>> getStockNews() {
        return stockNews;
    }

    public LiveData <List<News>> getStocksNews() {
        StockApi stockApi = ServiceGenerator.getStockApi();
        Call<List<News>> call = stockApi.getStockNews();

        call.enqueue(new Callback<List<News>>() {
     @Override
     public void onResponse(Call<List<News>> call, Response<List<News>> response) {

         if (response.isSuccessful()){
             stockNews.setValue(response.body());

         }
     }

     @Override
     public void onFailure(Call<List<News>> call, Throwable t) {
         Log.e("Retrofit", "Something went wrong getting Stocks news :(");

     }
        });
        return stockNews;
    }

}
