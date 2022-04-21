package com.example.mytradingapp.View.StockView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mytradingapp.R;
import com.example.mytradingapp.View.Home.HomeFragment;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


public class StockFragment extends Fragment {

    GraphView graphView;
    Button button;

    @SuppressLint("ResourceAsColor")

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stock, container, false);

        button = view.findViewById(R.id.stockView2);
        button.setOnClickListener(this::onClick);


        // on below line we are initializing our graph view.
        graphView = view.findViewById(R.id.idGraphView);

        // on below line we are adding data to our graph view.
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(getDataPoint());
        graphView.addSeries(series);
        series.setColor(Color.rgb(159,255,137));
        series.setThickness(18);
        series.setDrawBackground(true);
        series.setBackgroundColor(Color.argb(60,95,226,156));
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(15);


        graphView.setTitle("My Graph View");
        graphView.setTitleColor(R.color.purple_200);
        graphView.setBackgroundColor(Color.rgb(36,34,41));
        graphView.setTitleTextSize(18);

        // Inflate the layout for this fragment
        return view;
    }

    private DataPoint[] getDataPoint() {

        DataPoint[] dp=new DataPoint[] {
                new DataPoint(0,1),
                new DataPoint(2,5),
                new DataPoint(3,1),
                new DataPoint(5,6),
                new DataPoint(8,3)
        };
        return dp;
    }

    public void onClick(View view ) {
        FragmentTransaction fr = getFragmentManager().beginTransaction();
        fr.replace(R.id.nav_host_fragment, new HomeFragment());
        fr.commit();
    }

}