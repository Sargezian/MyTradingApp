package com.example.mytradingapp.View.StockView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.mytradingapp.R;
import com.example.mytradingapp.View.Home.HomeFragment;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.scichart.charting.modifiers.ModifierGroup;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.HorizontalAnchorPoint;
import com.scichart.charting.visuals.annotations.TextAnnotation;
import com.scichart.charting.visuals.annotations.VerticalAnchorPoint;
import com.scichart.charting.visuals.axes.IAxis;
import com.scichart.drawing.utility.ColorUtil;
import com.scichart.extensions.builders.SciChartBuilder;

import java.util.Collections;

public class StockViewActivity extends AppCompatActivity {

    GraphView graphView;

    @SuppressLint("ResourceAsColor")
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_view);

        Button button = findViewById(R.id.BackToHome);

        button.setOnClickListener(this::Back);

        // on below line we are initializing our graph view.
        graphView = findViewById(R.id.idGraphView);

        // on below line we are adding data to our graph view.
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(getDataPoint());
        graphView.addSeries(series);
        series.setColor(Color.rgb(88,255,69));
        series.setThickness(18);
        series.setDrawBackground(true);
        series.setBackgroundColor(Color.argb(60,95,226,156));
        series.setDrawDataPoints(true);
        series.setDataPointsRadius(15);


        graphView.setTitle("My Graph View");
        graphView.setTitleColor(R.color.purple_200);
        graphView.setBackgroundColor(Color.rgb(36,34,41));
        graphView.setTitleTextSize(18);

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

    public void Back(View v) {
        Intent intent = new Intent(this, HomeFragment.class);
        startActivity(intent);
    }

}