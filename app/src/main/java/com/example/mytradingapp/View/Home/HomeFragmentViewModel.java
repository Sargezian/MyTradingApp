package com.example.mytradingapp.View.Home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mytradingapp.Repository.StockRepository;
import com.example.mytradingapp.Shared.Transferobjects.Stock;
import com.google.firebase.database.DatabaseReference;

import java.util.List;

public class HomeFragmentViewModel extends AndroidViewModel {

    private final StockRepository stockRepository;


    public HomeFragmentViewModel(@NonNull Application application) {
        super(application);
        stockRepository = StockRepository.getInstance();


    }

    public void init(){
        stockRepository.init();
    }


    public void saveStock(Stock stock) {
        stockRepository.saveStock(stock);
    }

    public void remoVeStock(String stock){
        stockRepository.deleteStock(stock);
    }

    public LiveData<List<Stock>> getStock() {
        return stockRepository.getSavedStock();
    }


}
