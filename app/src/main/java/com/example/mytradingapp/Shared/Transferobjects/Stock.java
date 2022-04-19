package com.example.mytradingapp.Shared.Transferobjects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stock {


    private String ticker;

    private double price;

    private double changesPercentage;

    private String companyName;


    public Stock(String ticker, double price, double changesPercentage, String companyName) {
        this.ticker = ticker;
        this.price = price;
        this.changesPercentage = changesPercentage;
        this.companyName = companyName;
    }


    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getChangesPercentage() {
        return changesPercentage;
    }

    public void setChangesPercentage(double changesPercentage) {
        this.changesPercentage = changesPercentage;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
