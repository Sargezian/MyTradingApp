package com.example.mytradingapp.Adapter;

import com.example.mytradingapp.Shared.Transferobjects.Historical;
import com.robinhood.spark.SparkAdapter;

import java.util.List;

public class StockSparkAdapter extends SparkAdapter {

    private List<Historical> dailyData;


    public StockSparkAdapter(List<Historical> dailyData) {
        this.dailyData = dailyData;
    }

    @Override
    public int getCount() {
        return dailyData.size();
    }

    @Override
    public Object getItem(int index) {
        return dailyData.get(index);
    }

    @Override
    public float getY(int index) {

        Historical dayData = dailyData.get(index);

        return (float) dayData.getClose();
    }
}
