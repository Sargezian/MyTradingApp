package com.example.mytradingapp.View.Market;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mytradingapp.Repository.StockRepository;
import com.example.mytradingapp.Shared.Transferobjects.Stock;

import java.util.List;

public class TopLosersViewModel extends ViewModel {

    private StockRepository stockRepository;
    private LiveData<List<Stock>> loserStockResponseLiveData;

    public TopLosersViewModel() {

        stockRepository = StockRepository.getInstance();
        loserStockResponseLiveData = stockRepository.getLoserStocks();

    }


    public LiveData<List<Stock>>getLoserStockResponseLiveData(){

        return loserStockResponseLiveData;
    }






}
