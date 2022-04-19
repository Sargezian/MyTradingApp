package com.example.mytradingapp.API;

import com.example.mytradingapp.Shared.Transferobjects.Stock;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StockApi {

    @GET("api/v3/actives?apikey=ea82a0933406160c3b57dfd366dda6d0")
    Call<List<Stock>>getActiveStocks();

    @GET("api/v3/losers?apikey=ea82a0933406160c3b57dfd366dda6d0")
    Call<List<Stock>>getLosersStock();

    @GET("api/v3/gainers?apikey=ea82a0933406160c3b57dfd366dda6d0")
    Call<List<Stock>>getGainersStock();



}
