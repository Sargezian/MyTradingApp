package com.example.mytradingapp.View.Market;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mytradingapp.Repository.StockRepository;
import com.example.mytradingapp.Shared.Transferobjects.Stock;

import java.util.List;

public class TopGainersViewModel extends ViewModel {

    private StockRepository stockRepository;
    private LiveData<List<Stock>> gainersStockResponseLiveData;


    public TopGainersViewModel() {

        stockRepository = StockRepository.getInstance();
        gainersStockResponseLiveData = stockRepository.getGainersStock();

    }


    public LiveData<List<Stock>> getGainersStockResponseLiveData() {
        return gainersStockResponseLiveData;
    }
}
