package com.example.mytradingapp.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static  StockApi stockApi;


    public static StockApi getStockApi(){
        if (stockApi == null){
            stockApi = new Retrofit.Builder()
                    .baseUrl("https://fmpcloud.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(StockApi.class);
        }

        return stockApi;
    }





}
