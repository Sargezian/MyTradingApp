package com.example.mytradingapp.View.StockView;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mytradingapp.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


public class StockViewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_stock_view, container, false);


        // Inflate the layout for this fragment
        return view;
    }


}


/*            setContentView(R.layout.activity_stock_view);
            // Create a SciChartSurface
            SciChartSurface surface = new SciChartSurface(this);
            // Get a layout declared in "activity_main.xml" by id
            ConstraintLayout constraintlayout = (ConstraintLayout) findViewById(R.id.chart_layout);
            // Add the SciChartSurface to the layout
            constraintlayout.addView(surface);
            // Initialize the SciChartBuilder
            SciChartBuilder.init(this);
            // Obtain the SciChartBuilder instance
            final SciChartBuilder sciChartBuilder = SciChartBuilder.instance();
            // Create a numeric X axis
            final IAxis xAxis = sciChartBuilder.newNumericAxis()
                    .withAxisTitle("X Axis Title")
                    .withVisibleRange(-5, 15)
                    .build();
            // Create a numeric Y axis
            final IAxis yAxis = sciChartBuilder.newNumericAxis()
                    .withAxisTitle("Y Axis Title").withVisibleRange(0, 100).build();
            // Create a TextAnnotation and specify the inscription and position for it
            TextAnnotation textAnnotation = sciChartBuilder.newTextAnnotation()
                    .withX1(5.0)
                    .withY1(55.0)
                    .withText("Hello World!")
                    .withHorizontalAnchorPoint(HorizontalAnchorPoint.Center)
                    .withVerticalAnchorPoint(VerticalAnchorPoint.Center)
                    .withFontStyle(20, ColorUtil.White)
                    .build();
            // Create interactivity modifiers
            ModifierGroup chartModifiers = sciChartBuilder.newModifierGroup()
                    .withPinchZoomModifier().withReceiveHandledEvents(true).build()
                    .withZoomPanModifier().withReceiveHandledEvents(true).build()
                    .build();
            // Add the Y axis to the YAxes collection of the surface
            Collections.addAll(surface.getYAxes(), yAxis);
            // Add the X axis to the XAxes collection of the surface
            Collections.addAll(surface.getXAxes(), xAxis);
            // Add the annotation to the Annotations collection of the surface
            Collections.addAll(surface.getAnnotations(), textAnnotation);
            // Add the interactions to the ChartModifiers collection of the surface
            Collections.addAll(surface.getChartModifiers(), chartModifiers); */