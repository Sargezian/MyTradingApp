package com.example.mytradingapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;


public class StockDetails extends Fragment {


    private TextView textViewTicker;
    private TextView textViewPrice;
    private TextView textViewProcent;
    private Toolbar toolbar;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_stock_details, container, false);

        textViewTicker = inflate.findViewById(R.id.tv_ticker);

        textViewTicker.setText(getArguments().getString("ticker"));

        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(getArguments().getString("companyName"));


        textViewPrice = inflate.findViewById(R.id.tv_price);

        textViewPrice.setText(Double.toString(getArguments().getDouble("price")));

        textViewProcent = inflate.findViewById(R.id.tv_procent);
        textViewProcent.setText(Double.toString(getArguments().getDouble("changesPercentage")) + " %");


        getChangesPercentage();


        return inflate;
    }




    public void getChangesPercentage(){
        String s = textViewProcent.getText().toString();

        if (Double.valueOf(textViewProcent.getText().toString().substring(0,s.length()-3)) < 0){
            textViewProcent.setTextColor(ContextCompat.getColor(getContext(),R.color.RED));
        } else if (Double.valueOf(textViewProcent.getText().toString().substring(0,s.length()-3)) == 0){
            textViewProcent.setTextColor(ContextCompat.getColor(getContext(),R.color.grey));
        }
        else {
            textViewProcent.setTextColor(ContextCompat.getColor(getContext(),R.color.GreenColor));
        }
    }




}