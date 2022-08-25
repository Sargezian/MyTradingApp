package com.example.mytradingapp.Shared.Transferobjects;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.example.mytradingapp.Shared.Entity.User;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
@Entity(tableName = "stock_table",foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "id",
        childColumns = "fkUser",  onDelete = ForeignKey.CASCADE),
        indices = @Index("fkUser"

     ))

public class Stock {

@PrimaryKey(autoGenerate = true)
    private int id;
    private String ticker;
    private double price;
    private double changesPercentage;
    private String companyName;
    private String fkUser;





    public Stock() {
    }

    public Stock(String ticker, double price, double changesPercentage, String companyName, String fkUser) {
        this.ticker = ticker;
        this.price = price;
        this.changesPercentage = changesPercentage;
        this.companyName = companyName;
        this.fkUser = fkUser;
    }

    @Ignore
    public Stock(String ticker, double price, double changesPercentage, String companyName) {
        this.ticker = ticker;
        this.price = price;
        this.changesPercentage = changesPercentage;
        this.companyName = companyName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getFkUser() {
        return fkUser;
    }

    public void setFkUser(String fkUser) {
        this.fkUser = fkUser;
    }
}
