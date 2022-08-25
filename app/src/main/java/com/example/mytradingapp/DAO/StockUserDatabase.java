package com.example.mytradingapp.DAO;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mytradingapp.Shared.Entity.User;
import com.example.mytradingapp.Shared.Transferobjects.Stock;

@Database(entities = {User.class, Stock.class}, version = 7)
public abstract class StockUserDatabase extends RoomDatabase {

    private static StockUserDatabase instance;

    public abstract StockDao stockDao();


    public static synchronized StockUserDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context,
                            StockUserDatabase.class, "stockUser_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
