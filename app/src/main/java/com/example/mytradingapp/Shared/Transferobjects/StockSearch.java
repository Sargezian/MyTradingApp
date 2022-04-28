package com.example.mytradingapp.Shared.Transferobjects;

public class StockSearch {

    private final double price;
    private final String name;
    private final String symbol;

    public StockSearch(double price, String name, String symbol) {
        this.price = price;
        this.name = name;
        this.symbol = symbol;
    }

    public StockSearch getStock() {
        return new StockSearch(price, name, symbol);
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public String getSymbol() {
        return symbol;
    }



}
