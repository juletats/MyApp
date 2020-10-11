package com.example.julia.myproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class GraphView2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_view2);

        Intent intent = getIntent();

        String inputA = intent.getStringExtra("inputA");
        String inputB = intent.getStringExtra("inputB");
        String inputH = intent.getStringExtra("inputH");
        String nameofFn = intent.getStringExtra("nameofFunction");
        String nameofDer = intent.getStringExtra("nameofDerivative");

        Double a = Double.parseDouble(inputA);
        Double h = Double.parseDouble(inputH);
        Double b = Double.parseDouble(inputB);

        int count = (int) ((b - a) / h + 2);

        MatchParser matchParser = new MatchParser();
        //function
        DataPoint[] dataPoint = new DataPoint[count];
        DataPoint[] derPoint = new DataPoint[count];

        for (int i = 0; i < count; i++) {
            matchParser.setVariable("x", a);
            Double dy = 0.0;
            Double y = 0.0;
            try {
                y = matchParser.Parse(nameofFn);
                dy = matchParser.Parse(nameofDer);
            } catch (Exception e) {
                e.printStackTrace();
            }
            dataPoint[i] = new DataPoint(a, y);
            derPoint[i] = new DataPoint(a, dy);
            a += h;
        }
        GraphView graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(dataPoint);
        LineGraphSeries<DataPoint> series1 = new LineGraphSeries<>(derPoint);


        series.setDrawDataPoints(true);
        series.setDataPointsRadius(2);
        series.setThickness(1);
        series1.setDrawDataPoints(true);
        series1.setDataPointsRadius(3);
        series1.setThickness(0);

        graph.getViewport().setScalable(true);
        graph.getViewport().setScalableY(true);
        graph.getViewport().setScrollable(true);
        graph.getViewport().setScrollableY(true);
        graph.addSeries(series);
        graph.addSeries(series1);


    }
}
