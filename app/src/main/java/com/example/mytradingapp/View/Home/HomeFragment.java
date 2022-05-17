package com.example.mytradingapp.View.Home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mytradingapp.Adapter.OnListItemClickListener;
import com.example.mytradingapp.Adapter.StockTitleAdapter;
import com.example.mytradingapp.R;
import com.example.mytradingapp.Shared.Transferobjects.Stock;
import com.example.mytradingapp.View.Login.LoginActivity;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements OnListItemClickListener {


    private ArrayList<Stock> stockArrayList = new ArrayList<>();
    private StockTitleAdapter stockTitleAdapter;
    private RecyclerView recyclerView;
    private final DecimalFormat df = new DecimalFormat("0.00");
    private HomeFragmentViewModel homeFragmentViewModel;
    private Bundle bundle = new Bundle();
    private  View view;
    private FirebaseAuth firebaseAuth;
    private TextView error;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_home, container, false);
        homeFragmentViewModel = new ViewModelProvider(this).get(HomeFragmentViewModel.class);
        homeFragmentViewModel.init();
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView.hasFixedSize();
        firebaseAuth = FirebaseAuth.getInstance();
        stockTitleAdapter = new StockTitleAdapter(stockArrayList,this);
         error = view.findViewById(R.id.tv_s_error);
        recyclerView.setAdapter(stockTitleAdapter);

        getGainersStock();

        return view;
    }

    private void getGainersStock() {


        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(getActivity(), LoginActivity.class));
            getActivity().finish();
        } else {
            homeFragmentViewModel.getStock().observe(getViewLifecycleOwner(), stock -> {
                if (stock != null && !stock.isEmpty()){
                    error.setVisibility(View.GONE);
                    List<Stock> stockList = stock;
                    stockArrayList.clear();
                    stockArrayList.addAll(stockList);
                    stockTitleAdapter.notifyDataSetChanged();

                }

            });

        }


    }




    @Override
    public void onClick(int position) {
        Toast.makeText(getContext(), "Position: " + position, Toast.LENGTH_SHORT).show();


        bundle.putString("ticker", stockArrayList.get(position).getTicker());
        bundle.putDouble("price",stockArrayList.get(position).getPrice());
        bundle.putDouble("changesPercentage",stockArrayList.get(position).getChangesPercentage());
        bundle.putString("companyName",stockArrayList.get(position).getCompanyName());


        Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_stockDetails,bundle);
    }
}