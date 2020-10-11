package com.example.julia.myproject;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GraphView1 extends Activity implements View.OnClickListener {

    EditText function;
    EditText derivative;
    EditText inputA;
    EditText inputB;
    String strA,strB,strH;
    EditText inputH;
    TextView inputN;



    Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_view1);
        function = (EditText) findViewById(R.id.function);
        derivative= (EditText) findViewById(R.id.derivative);
        inputA= (EditText) findViewById(R.id.a);
        inputB= (EditText) findViewById(R.id.b);
        inputH= (EditText) findViewById(R.id.h);

        start = (Button) findViewById(R.id.start);
        start.setOnClickListener(this);
        strA=inputA.getText().toString();
        strB=inputB.getText().toString();
        strH=inputH.getText().toString();
    }
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, GraphView2.class);

            if (inputA.getText().toString().isEmpty() || inputB.getText().toString().isEmpty() || inputH.getText().toString().isEmpty()) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Введите все данные в таблицу", Toast.LENGTH_LONG);
                toast.show();
            } else {
                if (function.toString().isEmpty() || derivative.toString().isEmpty()) {
                    Toast toast = Toast.makeText(getApplicationContext(),
                            "Введите все данные в таблицу", Toast.LENGTH_LONG);
                    toast.show();
                }




        else{

                intent.putExtra("nameofFunction", function.getText().toString());
                intent.putExtra("nameofDerivative", derivative.getText().toString());
                intent.putExtra("inputA", inputA.getText().toString());
                intent.putExtra("inputB", inputB.getText().toString());
                intent.putExtra("inputH", inputH.getText().toString());
                startActivityForResult(intent, 0);

            }
        }
    }

    }
