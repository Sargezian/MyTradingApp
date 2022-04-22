package com.example.mytradingapp.API;

import com.example.mytradingapp.Shared.Transferobjects.News;
import com.example.mytradingapp.Shared.Transferobjects.Stock;
import com.example.mytradingapp.Shared.Transferobjects.StockGraph;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StockApi {

    //ActiveStocks
    @GET("api/v3/actives?apikey=ea82a0933406160c3b57dfd366dda6d0")
    Call<List<Stock>>getActiveStocks();

    //LoserStocks
    @GET("api/v3/losers?apikey=ea82a0933406160c3b57dfd366dda6d0")
    Call<List<Stock>>getLosersStock();

    //GainerStocks
    @GET("api/v3/gainers?apikey=ea82a0933406160c3b57dfd366dda6d0")
    Call<List<Stock>>getGainersStock();

    //StockNews
    @GET("api/v3/stock_news?limit=50&apikey=ea82a0933406160c3b57dfd366dda6d0")
    Call<List<News>>getStockNews();


    @GET("api/v3/historical-price-full/{name}?apikey=ea82a0933406160c3b57dfd366dda6d0")
    Call<StockGraph>getGraph(@Path("name") String name);



}
