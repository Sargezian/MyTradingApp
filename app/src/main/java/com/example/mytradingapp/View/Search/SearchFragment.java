package com.example.mytradingapp.View.Search;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mytradingapp.R;


public class SearchFragment extends Fragment {


    private EditText editText;
    private SearchViewModel viewModel;
    private TextView companyName;
    private TextView stockPrice;
    private TextView tickerName;
    private TextView Website;
    private TextView description;
    private ImageView companyLogo;


    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_search, container, false);

        editText = view.findViewById(R.id.editText);
        companyName = view.findViewById(R.id.companyName);
        stockPrice = view.findViewById(R.id.StockPrice);
        tickerName = view.findViewById(R.id.tickerName);
        Website = view.findViewById(R.id.Website);
        description = view.findViewById(R.id.description);
        companyLogo = view.findViewById(R.id.companyLogo);



        button = view.findViewById(R.id.button);

        viewModel = new ViewModelProvider(this).get(SearchViewModel.class);

        viewModel.getSearchedStock().observe(getViewLifecycleOwner(),stock -> {

            tickerName.setText(stock.getSymbol());
            companyName.setText(stock.getCompanyName());
            stockPrice.setText(Double.toString(stock.getPrice()));
            Website.setText(stock.getWebsite());
            description.setText(stock.getDescription());
            Glide.with(this).load(stock.getImage()).into(companyLogo);


        });

        button.setOnClickListener(this::searchForStock);


        return view;
    }

    public void searchForStock(View view) {
        viewModel.searchForStock(editText.getText().toString());
        companyName.setText("");

    }

}