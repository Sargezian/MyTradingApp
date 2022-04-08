package com.example.mytradingapp.Shared.Data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {


    private static StockAPI stockAPI;

    public static StockAPI getStockAPI() {
        if (stockAPI == null) {
            stockAPI = new Retrofit.Builder()
                    .baseUrl("https://pokeapi.co")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(StockAPI.class);
        }
        return stockAPI;
    }


}
