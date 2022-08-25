package com.example.mytradingapp.Repository;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mytradingapp.API.ServiceGenerator;
import com.example.mytradingapp.API.StockApi;
import com.example.mytradingapp.DAO.StockDao;
import com.example.mytradingapp.DAO.StockUserDatabase;
import com.example.mytradingapp.Shared.StockUser;
import com.example.mytradingapp.Shared.Transferobjects.Stock;
import com.example.mytradingapp.Shared.Transferobjects.StockGraph;
import com.example.mytradingapp.Shared.Transferobjects.StockSearch;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class StockRepository {

    private FirebaseAuth firebaseAuth;
    private static StockRepository instance;
    private final MutableLiveData<List<Stock>> stockList;
    private final MutableLiveData<List<Stock>> stockList2;
    private final MutableLiveData<List<Stock>> stockList3;
    private final MutableLiveData<List<StockGraph>> stockGraphList;

    private final MutableLiveData<StockSearch> searchedStock;
    private final ExecutorService executorService;
    private final StockDao stockDao;


    private DatabaseReference databaseReference;
    private StockLiveData stockLiveData;


    public StockRepository(Application application) {
        StockUserDatabase database = StockUserDatabase.getInstance(application);
        stockDao = database.stockDao();
        executorService = Executors.newFixedThreadPool(2);
        stockList = new MutableLiveData<>();
        stockList2 = new MutableLiveData<>();
        stockList3 = new MutableLiveData<>();
        stockGraphList = new MutableLiveData<>();
        searchedStock = new MutableLiveData<>();
        firebaseAuth = FirebaseAuth.getInstance();

    }

    public static synchronized StockRepository getInstance(Application application) {

        if (instance == null){
            instance = new StockRepository(application);
        }

        return instance;
    }

    public void init (){
        FirebaseUser user = firebaseAuth.getCurrentUser();

        if (user != null){
            databaseReference =  FirebaseDatabase.getInstance("https://mytradingapp-d2411-default-rtdb.europe-west1.firebasedatabase.app/").getReference("stock")
                    .child(user.getUid());
            stockLiveData = new StockLiveData(databaseReference);
        }

    }

    public void saveStock(Stock stock){
        databaseReference.push().setValue(stock);

    }

    public void deleteStock(String stock){


        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                   String key  = postSnapshot.getKey();
                    databaseReference.child(key).orderByValue().equalTo(stock).getRef().removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            Log.e("delte",key);
                        }
                    });

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public StockLiveData getSavedStock(){
        return stockLiveData;
    }

    public LiveData<StockSearch> getSearchedStock() {
        return searchedStock;
    }

    public LiveData<List<Stock>> getStockList() {
        return stockList;
    }

    public MutableLiveData<List<Stock>> getStockList2() {
        return stockList2;
    }

    public LiveData<StockSearch> searchForStock(String companyName) {
        StockApi stockApi = ServiceGenerator.getStockApi();
        Call<List<StockSearch>> call = stockApi.getStock(companyName);

        call.enqueue(new Callback<List<StockSearch>>() {
            @EverythingIsNonNull
            @Override
            public void onResponse(Call<List<StockSearch>> call, Response<List<StockSearch>> response) {

                if (response.isSuccessful()) {

                    if (!response.body().isEmpty()){
                        searchedStock.setValue(response.body().get(0).getStock());
                    } else {
                        Log.e("retrofit","something went wrong");
                    }


                }
            }

            @EverythingIsNonNull
            @Override
            public void onFailure(Call<List<StockSearch>> call, Throwable t) {
                Log.i("Retrofit", t.getMessage());
            }
        });

        return searchedStock;
    }


    public LiveData<List<Stock>> getActiveStocks(){
        StockApi stockApi = ServiceGenerator.getStockApi();
        Call<List<Stock>> call = stockApi.getActiveStocks();

        call.enqueue(new Callback<List<Stock>>() {
            @Override
            public void onResponse(Call<List<Stock>> call, Response<List<Stock>> response) {

                if (response.isSuccessful()){
                    stockList.setValue(response.body());

                }


            }

            @Override
            public void onFailure(Call<List<Stock>> call, Throwable t) {
                Log.e("Retrofit", "Something went wrong getting active Stocks :(");

            }
        });


        return stockList;
    }

    public LiveData<List<Stock>>getLoserStocks(){
        StockApi stockApi = ServiceGenerator.getStockApi();
        Call<List<Stock>>call = stockApi.getLosersStock();

        call.enqueue(new Callback<List<Stock>>() {
            @Override
            public void onResponse(Call<List<Stock>> call, Response<List<Stock>> response) {
                if (response.isSuccessful()){
                    stockList2.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Stock>> call, Throwable t) {
                Log.e("Retrofit", "Something went wrong getting losers Stocks :(");

            }
        });

        return stockList2;
    }

    public LiveData<List<Stock>>getGainersStock(){
        StockApi stockApi = ServiceGenerator.getStockApi();
        Call<List<Stock>> call = stockApi.getGainersStock();

        call.enqueue(new Callback<List<Stock>>() {
            @Override
            public void onResponse(Call<List<Stock>> call, Response<List<Stock>> response) {

                if (response.isSuccessful()){
                    stockList3.setValue(response.body());
                    Log.e("Retrofit", "getting Gainers Stocks :(");
                }
            }

            @Override
            public void onFailure(Call<List<Stock>> call, Throwable t) {

                Log.e("Retrofit", "Something went wrong getting Gainers Stocks :(");
            }
        });

        return stockList3;

    }

    public LiveData<List<StockUser>> getStockByUserId(String userId){
        return stockDao.getStockByUserId(userId);
    }


    public void insert(Stock stock) {
        executorService.execute(() -> stockDao.addStock(stock));
    }

}
