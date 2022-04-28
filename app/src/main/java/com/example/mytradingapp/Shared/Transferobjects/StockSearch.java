package com.example.mytradingapp.Shared.Transferobjects;

public class StockSearch {

    private final double price;
    private final String companyName;
    private final String symbol;
    private final String website;
    private final String description;
    private final String image;
    private final double changes;

    public StockSearch(double price, String companyName, String symbol, String website, String description, String image, double changes) {
        this.price = price;
        this.companyName = companyName;
        this.symbol = symbol;
        this.website = website;
        this.description = description;
        this.image = image;
        this.changes = changes;
    }

    public StockSearch getStock() {
        return new StockSearch(price, companyName, symbol, website, description, image, changes);
    }

    public String getCompanyName() {
        return companyName;
    }
    public double getPrice() {
        return price;
    }
    public String getSymbol() {
        return symbol;
    }


    public String getWebsite() {
        return website;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public double getChanges() {
        return changes;
    }
}
