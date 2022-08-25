package com.example.mytradingapp.View.Market;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mytradingapp.Repository.StockRepository;
import com.example.mytradingapp.Shared.Transferobjects.Stock;

import java.util.List;

public class TopActiveViewModel extends AndroidViewModel {

   private StockRepository stockRepository;
   private LiveData<List<Stock>> ActiveStockResponseLiveData;

    public TopActiveViewModel(@NonNull Application application) {
        super(application);

        stockRepository = StockRepository.getInstance(application);
        ActiveStockResponseLiveData = stockRepository.getActiveStocks();
    }


    public LiveData<List<Stock>> getActiveStockLiveData() {
        return ActiveStockResponseLiveData;
    }



}
