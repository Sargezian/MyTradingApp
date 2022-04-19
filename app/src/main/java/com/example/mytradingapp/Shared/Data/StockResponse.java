package com.example.mytradingapp.Shared.Data;

import com.example.mytradingapp.Shared.Transferobjects.Stock;

public class StockResponse {

    private String ticker;
    private double price;
    private double changesPercentage;
    private String companyName;

    public Stock getStock() {
        return new Stock(ticker,price,changesPercentage, companyName);
    }


}
