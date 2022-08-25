package com.example.mytradingapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytradingapp.R;
import com.example.mytradingapp.Shared.StockUser;
import com.example.mytradingapp.Shared.Transferobjects.Stock;

import java.util.ArrayList;


public class StockTitleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements OnListItemClickListener {

    private ArrayList<StockUser> stocks;
    OnListItemClickListener listener;

    public StockTitleAdapter(ArrayList<StockUser> stocks, OnListItemClickListener listener) {
        this.stocks = stocks;
        this.listener = listener;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            return new StockViewHolder(
                    LayoutInflater.from(parent.getContext()).inflate(
                            R.layout.post_item,
                            parent,
                            false
                    )
            );



    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        StockUser stock = (StockUser) stocks.get(position);
            ((StockViewHolder)holder).setStock(stock,position);



    }

    @Override
    public int getItemCount() {
        return stocks.size();
    }

    @Override
    public void onClick(int position) {

    }


    public class StockViewHolder extends RecyclerView.ViewHolder {


        private TextView ticker;
        private TextView price;
        private TextView changesPercentage;
        private TextView companyName;


        public StockViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(getBindingAdapterPosition());
                }
            });
            ticker = itemView.findViewById(R.id.ticker);
            price = itemView.findViewById(R.id.price);
            changesPercentage = itemView.findViewById(R.id.changesPercentage);
            companyName = itemView.findViewById(R.id.companyName);
        }




        public void setStock(StockUser stock, int position){

            ticker.setText(stock.userStockList.get(position).getTicker());
            price.setText(Double.toString(stock.userStockList.get(position).getPrice()));
            changesPercentage.setText(Double.toString(stock.userStockList.get(position).getChangesPercentage()) + "%");
            companyName.setText(stock.userStockList.get(position).getCompanyName());
            getChangesPercentage();

        }

        public void getChangesPercentage(){
           String s = changesPercentage.getText().toString();

            if (Double.valueOf(changesPercentage.getText().toString().substring(0,s.length()-2)) < 0){
                changesPercentage.setBackgroundResource(R.color.RED);
            } else if (Double.valueOf(changesPercentage.getText().toString().substring(0,s.length()-2)) == 0){
                changesPercentage.setBackgroundResource(R.color.grey);
            }
            else {
                changesPercentage.setBackgroundResource(R.color.GreenColor);
            }
        }



    }



}
