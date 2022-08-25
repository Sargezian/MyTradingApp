package com.example.mytradingapp.Shared;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.example.mytradingapp.Shared.Entity.User;
import com.example.mytradingapp.Shared.Transferobjects.Stock;

import java.util.List;


public class StockUser {

    @Embedded
    public User user;

    @Relation(
            parentColumn = "id",
            entityColumn = "ticker"
    )
    public List<Stock> userStockList;


    public StockUser(User user, List<Stock> userStockList) {
        this.user = user;
        this.userStockList = userStockList;
    }
}
