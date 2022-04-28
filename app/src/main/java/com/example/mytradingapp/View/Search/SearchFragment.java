package com.example.mytradingapp.View.Search;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    private TextView percent;

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

        percent = view.findViewById(R.id.percent);


        companyLogo = view.findViewById(R.id.companyLogo);

        description.setMovementMethod(new ScrollingMovementMethod());

        button = view.findViewById(R.id.button);

        viewModel = new ViewModelProvider(this).get(SearchViewModel.class);

        viewModel.getSearchedStock().observe(getViewLifecycleOwner(),stock -> {

            tickerName.setText(stock.getSymbol());
            companyName.setText(stock.getCompanyName());
            stockPrice.setText(Double.toString(stock.getPrice()));
            Website.setText(stock.getWebsite());
            description.setText(stock.getDescription());

            //stock.getChanges()/stock.getPrice()*100 = dette gør vi fordi vi vil gerne have det vist i procent
            percent.setText(Double.toString(stock.getChanges()/stock.getPrice()*100));
            Glide.with(this).load(stock.getImage()).into(companyLogo);
            getChangesPercentage();

        });



        Website.setOnClickListener(this::onWeblinkClick);

        button.setOnClickListener(this::searchForStock);


        return view;
    }

    public void searchForStock(View view) {
        viewModel.searchForStock(editText.getText().toString());
        companyName.setText("");

    }


    public void onWeblinkClick(View view) {

        Uri webpage = Uri.parse(Website.getText().toString());
        Intent webIntent = new Intent(Intent.ACTION_VIEW,webpage);

        startActivity(webIntent);

    }

    public void getChangesPercentage(){
        String s = percent.getText().toString();

        if (Double.valueOf(percent.getText().toString().substring(0,s.length()-3)) < 0){
            percent.setTextColor(ContextCompat.getColor(getContext(),R.color.RED));
        } else if (Double.valueOf(percent.getText().toString().substring(0,s.length()-3)) == 0){
            percent.setTextColor(ContextCompat.getColor(getContext(),R.color.grey));
        }
        else {
            percent.setTextColor(ContextCompat.getColor(getContext(),R.color.GreenColor));
        }
    }



}