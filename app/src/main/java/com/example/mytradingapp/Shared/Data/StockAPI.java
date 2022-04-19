package com.example.mytradingapp.Shared.Data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface StockAPI {

    @GET("api/v2/stock/{name}")
    Call<StockResponse> getPokemon(@Path("name") String name);

}
