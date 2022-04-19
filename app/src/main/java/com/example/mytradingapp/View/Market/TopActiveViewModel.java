package com.example.mytradingapp.View.Market;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mytradingapp.Repository.StockRepository;
import com.example.mytradingapp.Shared.Transferobjects.Stock;

import java.util.List;

public class TopActiveViewModel extends ViewModel {

   private StockRepository stockRepository;
   private LiveData<List<Stock>> stockResponseLiveData;

    public TopActiveViewModel() {

        stockRepository = StockRepository.getInstance();
        stockResponseLiveData = stockRepository.getActiveStocks();
    }


    public LiveData<List<Stock>> getActiveStockLiveData() {
        return stockResponseLiveData;
    }



}
