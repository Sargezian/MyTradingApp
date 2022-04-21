package com.example.mytradingapp.View.News;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.mytradingapp.Repository.NewsRepository;
import com.example.mytradingapp.Repository.StockRepository;
import com.example.mytradingapp.Shared.Transferobjects.News;
import com.example.mytradingapp.Shared.Transferobjects.Stock;

import java.util.List;

public class NewsViewModel extends ViewModel {


    private NewsRepository newsRepository;
    private LiveData<List<News>> StockNewsResponseLiveData;

    public NewsViewModel() {

        newsRepository = NewsRepository.getInstance();
        StockNewsResponseLiveData = newsRepository.getStocksNews();
    }


    public LiveData<List<News>> getStockNewsLiveData() {
        return StockNewsResponseLiveData;
    }



}
