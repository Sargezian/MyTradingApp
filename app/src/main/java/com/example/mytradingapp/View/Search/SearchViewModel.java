package com.example.mytradingapp.View.Search;

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
        return repository.getSearchedStock();
    }

    public void searchForStock(String s) {
        repository.searchForStock(s);
    }




}
