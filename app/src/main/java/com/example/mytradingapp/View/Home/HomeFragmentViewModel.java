package com.example.mytradingapp.View.Home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mytradingapp.Repository.StockRepository;
import com.example.mytradingapp.Shared.StockUser;
import com.example.mytradingapp.Shared.Transferobjects.Stock;

import java.util.List;

public class HomeFragmentViewModel extends AndroidViewModel {

    private final StockRepository stockRepository;


    public HomeFragmentViewModel(@NonNull Application application) {
        super(application);
        stockRepository = StockRepository.getInstance(application);


    }




    public LiveData<List<StockUser>> getStockByUserId(String userId){
        return stockRepository.getStockByUserId(userId);
    }


}
