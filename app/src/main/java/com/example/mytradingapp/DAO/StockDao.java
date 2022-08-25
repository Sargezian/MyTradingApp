package com.example.mytradingapp.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mytradingapp.Shared.Entity.User;
import com.example.mytradingapp.Shared.StockUser;
import com.example.mytradingapp.Shared.Transferobjects.Stock;

import java.util.List;

@Dao
public interface StockDao {

    @Query("select * from stock_table where fkUser = :userId")
    LiveData<List<StockUser>> getStockByUserId(String userId);


    //Insert Stock by id
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addStock(Stock stock);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addUser(User user);



}
