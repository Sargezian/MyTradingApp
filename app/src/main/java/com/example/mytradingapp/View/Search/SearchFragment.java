package com.example.mytradingapp.View.Search;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.mytradingapp.R;


public class SearchFragment extends Fragment {


    private EditText editText;
    private SearchViewModel viewModel;
    private TextView textView;

    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_search, container, false);

        editText = view.findViewById(R.id.editText);
        textView = view.findViewById(R.id.tekst);

        button = view.findViewById(R.id.button);

        viewModel = new ViewModelProvider(this).get(SearchViewModel.class);

        viewModel.getSearchedStock().observe(getViewLifecycleOwner(),stock -> {

            textView.setText(stock.getName());

        });

        button.setOnClickListener(this::searchForStock);


        return view;
    }

    public void searchForStock(View view) {
        viewModel.searchForStock(editText.getText().toString());
        textView.setText("");

    }

}