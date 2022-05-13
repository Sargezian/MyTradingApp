package com.example.mytradingapp.View.Search;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mytradingapp.Repository.StockRepository;
import com.example.mytradingapp.Shared.Transferobjects.StockSearch;

public class SearchViewModel extends ViewModel {

    StockRepository repository;

    public SearchViewModel() {
        repository = StockRepository.getInstance();
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
