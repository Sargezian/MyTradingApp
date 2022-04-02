package com.example.mytradingapp.View.Market;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytradingapp.R;
import com.example.mytradingapp.Shared.Transferobjects.Item;
import com.example.mytradingapp.Shared.Adapter.StockTitleAdapter;
import com.example.mytradingapp.Shared.Transferobjects.Stock;
import com.example.mytradingapp.Shared.Transferobjects.Title;

import java.util.ArrayList;


public class UsaFragment extends Fragment implements StockTitleAdapter.OnListItemClickListener  {



    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_usa, container, false);


        recyclerView = inflate.findViewById(R.id.rv_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(inflate.getContext()));
        recyclerView.hasFixedSize();

        ArrayList<Item> items = new ArrayList<>();

        Title title = new Title(1,"Markets Top Active");
        items.add(new Item(0,title));

        Stock stock = new Stock("F",16.65,-1.53755,"Ford Motor Company");

        Stock stock1 = new Stock("F",16.65,1.53755,"Ford Motor Company");

        Stock stock2 = new Stock("F",16.65,-1.53755,"Ford Motor Company");

        Stock stock3 = new Stock("F",16.65,0.0,"Ford Motor Company");
        Stock stock10 = new Stock("F",16.65,-1.53755,"Ford Motor Company");
        Stock stock4 = new Stock("F",16.65,-1.53755,"Ford Motor Company");
        Stock stock5 = new Stock("F",16.65,-1.53755,"Ford Motor Company");
        Stock stock6 = new Stock("F",16.65,-1.53755,"Ford Motor Company");
        Stock stock7 = new Stock("F",16.65,-1.53755,"Ford Motor Company");
        Stock stock8 = new Stock("F",16.65,0.0,"Ford Motor Company");
        Stock stock9 = new Stock("F",16.65,-1.53755,"Ford Motor Company");

        items.add(new Item(1,stock));
        items.add(new Item(1,stock1));
        items.add(new Item(1,stock2));
        items.add(new Item(1,stock3));

        items.add(new Item(1,stock));
        items.add(new Item(1,stock1));

        Title title1 = new Title(1,"Markets Top Losers");
        items.add(new Item(0,title1));

        items.add(new Item(1,stock));
        items.add(new Item(1,stock1));
        items.add(new Item(1,stock2));
        items.add(new Item(1,stock3));
        items.add(new Item(1,stock));
        items.add(new Item(1,stock1));


        Title title2 = new Title(1,"Markets Top Gainers");
        items.add(new Item(0,title2));

        items.add(new Item(1,stock));
        items.add(new Item(1,stock1));
        items.add(new Item(1,stock2));
        items.add(new Item(1,stock3));
        items.add(new Item(1,stock));
        items.add(new Item(1,stock1));




        StockTitleAdapter adapter = new StockTitleAdapter(items,this);



        recyclerView.setAdapter(adapter);

        recyclerView.setAdapter(adapter);





        return inflate;

    }


    @Override
    public void onClick(int position) {
        Toast.makeText(getContext(), "Position: " + position, Toast.LENGTH_SHORT).show();
    }
}