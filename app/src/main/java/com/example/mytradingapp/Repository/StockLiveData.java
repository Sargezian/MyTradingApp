package com.example.mytradingapp.Repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.mytradingapp.Shared.Transferobjects.Stock;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class StockLiveData extends LiveData<List<Stock>> {

    private final ValueEventListener listener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
          List<Stock> stockList = new ArrayList<>();
            for (DataSnapshot postSnapshot: snapshot.getChildren()) {
               // stockList.add(postSnapshot.getValue(Stock.class));

            }

            setValue(stockList);

        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    };

    DatabaseReference databaseReference;

    public  StockLiveData(DatabaseReference databaseReference){
        this.databaseReference = databaseReference;
    }


    @Override
    protected void onActive() {
        super.onActive();
        databaseReference.addValueEventListener(listener);
    }

    @Override
    protected void onInactive() {
        super.onInactive();
        databaseReference.removeEventListener(listener);
    }
}
