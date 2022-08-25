package com.example.mytradingapp.View.StockDetails;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mytradingapp.Repository.StockRepository;
import com.example.mytradingapp.Shared.StockUser;
import com.example.mytradingapp.Shared.Transferobjects.Stock;

import java.util.List;

public class StockDetailsViewModel extends AndroidViewModel {

    StockRepository repository;
    public StockDetailsViewModel(@NonNull Application application) {
        super(application);
        repository = StockRepository.getInstance(application);
    }

    public void addStock(Stock stock) {
        repository.insert(stock);
    }

   





}


