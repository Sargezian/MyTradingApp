package com.example.mytradingapp.View.Search;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mytradingapp.Repository.StockRepository;
import com.example.mytradingapp.Shared.Transferobjects.StockSearch;

public class SearchViewModel extends AndroidViewModel {

    StockRepository repository;

    public SearchViewModel(@NonNull Application application) {
        super(application);
        repository = StockRepository.getInstance(application);
    }

    LiveData<StockSearch> getSearchedStock() {
        LiveData<StockSearch> searchedStock = repository.getSearchedStock();

        return searchedStock;
    }

    public  LiveData<StockSearch> searchForStock(String s) {
        LiveData<StockSearch> stockSearchLiveData = repository.searchForStock(s);

        return stockSearchLiveData;
    }




}
