package com.example.mytradingapp.Shared.Transferobjects;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StockGraph {

    private String symbol;
    @SerializedName("historical")
    private List<Historical> historical;

    public List<Historical> getHistorical() {
        return historical;
    }

    public void setHistorical(List<Historical> historical) {
        this.historical = historical;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
}
