package com.example.julia.myproject;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView calc = (TextView) findViewById(R.id.ingcalc);
        calc.setOnClickListener(this);
        TextView ME= (TextView) findViewById(R.id.graphing);
        TextView about= (TextView) findViewById(R.id.about);
        TextView EXIT= (TextView) findViewById(R.id.exit);
        ME.setOnClickListener(this);
        about.setOnClickListener(this);
        EXIT.setOnClickListener(this);

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.cage);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ingcalc :
                startActivityForResult(new Intent(this, Calc.class), 0);
                break;
            case R.id.graphing:
                startActivityForResult(new Intent(this,GraphView1.class),0);
                break;
            case R.id.about:
                startActivityForResult(new Intent(this,Aboutapp.class),0);
                break;
            case R.id.exit:
                System.exit(0);


        }

    }
}
