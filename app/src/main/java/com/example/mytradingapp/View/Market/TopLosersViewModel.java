package com.example.mytradingapp.View.Market;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mytradingapp.Repository.StockRepository;
import com.example.mytradingapp.Shared.Transferobjects.Stock;

import java.util.List;

public class TopLosersViewModel extends AndroidViewModel {

    private StockRepository stockRepository;
    private LiveData<List<Stock>> loserStockResponseLiveData;

    public TopLosersViewModel(@NonNull Application application) {
        super(application);
        stockRepository = StockRepository.getInstance(application);
        loserStockResponseLiveData = stockRepository.getLoserStocks();

    }


    public LiveData<List<Stock>>getLoserStockResponseLiveData(){

        return loserStockResponseLiveData;
    }






}
