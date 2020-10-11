package com.example.julia.myproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;

public class Calc extends Activity {
    GridView mKeypadGrid;
    KeypadAdapter mKeypadAdapter;
    TextView textResult;
    TextView inputX;
    TextView inputY;
    TextView inputZ;
    TextView currentView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);
        textResult = (TextView) findViewById(R.id.result);
        inputX = (TextView) findViewById(R.id.inputX);
        inputY= (TextView) findViewById(R.id.inputY);
        inputZ= (TextView) findViewById(R.id.inputZ);

        mKeypadGrid = (GridView) findViewById(R.id.grdButtons);
        mKeypadAdapter = new KeypadAdapter(this);
        mKeypadGrid.setAdapter(mKeypadAdapter);

        currentView = textResult;
        textResult.setBackgroundResource(R.color.activeText);
        inputX.setBackgroundResource(R.color.inActiveText);
        inputZ.setBackgroundResource(R.color.inActiveText);
        inputY.setBackgroundResource(R.color.inActiveText);



        mKeypadAdapter.setOnButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button btn = (Button) v;
                KeypadButton keypadButton = (KeypadButton) btn.getTag();
                ProcessKeypadInput(currentView, keypadButton);
            }
        });

        textResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentView.setBackgroundResource(R.color.inActiveText);
                currentView = textResult;
                currentView.setBackgroundResource(R.color.activeText);
                mKeypadAdapter.setButtons(new KeypadButton[]{
                        KeypadButton.Point,KeypadButton.C,KeypadButton.BACKSPACE,KeypadButton.CALCULATE,KeypadButton.POW,
                        KeypadButton.SQRT,KeypadButton.SEVEN,KeypadButton.EIGHT,KeypadButton.NINE,KeypadButton.SIN,
                        KeypadButton.DIV,KeypadButton.FOUR,KeypadButton.FIVE,KeypadButton.SIX,KeypadButton.COS,
                        KeypadButton.MULTIPLY,KeypadButton.ONE,KeypadButton.TWO,KeypadButton.THREE,KeypadButton.TAN,
                        KeypadButton.PLUS,KeypadButton.BRACKETOPEN,KeypadButton.ZERO, KeypadButton.BRACKETCLOSE,KeypadButton.CTG,
                        KeypadButton.MINUS,KeypadButton.X,KeypadButton.Y,KeypadButton.Z, KeypadButton.DIV1onX}
                );
            }
        });

        inputX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentView.setBackgroundResource(R.color.inActiveText);
                currentView = inputX;
                currentView.setBackgroundResource(R.color.activeText);
                mKeypadAdapter.setButtons(new KeypadButton[]{
                        KeypadButton.Point,KeypadButton.C,KeypadButton.BACKSPACE,KeypadButton.DUMMY,KeypadButton.POW,
                        KeypadButton.SQRT,KeypadButton.SEVEN,KeypadButton.EIGHT,KeypadButton.NINE,KeypadButton.DUMMY,
                        KeypadButton.DIV,KeypadButton.FOUR,KeypadButton.FIVE,KeypadButton.SIX,KeypadButton.DUMMY,
                        KeypadButton.MULTIPLY,KeypadButton.ONE,KeypadButton.TWO,KeypadButton.THREE,KeypadButton.DUMMY,
                        KeypadButton.PLUS,KeypadButton.BRACKETOPEN,KeypadButton.ZERO, KeypadButton.BRACKETCLOSE,KeypadButton.DUMMY,
                        KeypadButton.MINUS,KeypadButton.DUMMY,KeypadButton.DUMMY,KeypadButton.DUMMY, KeypadButton.DUMMY}
                );
            }
        });

        inputY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentView.setBackgroundResource(R.color.inActiveText);
                currentView = inputY;
                currentView.setBackgroundResource(R.color.activeText);
                mKeypadAdapter.setButtons(new KeypadButton[]{
                        KeypadButton.Point,KeypadButton.C,KeypadButton.BACKSPACE,KeypadButton.DUMMY,KeypadButton.POW,
                        KeypadButton.SQRT,KeypadButton.SEVEN,KeypadButton.EIGHT,KeypadButton.NINE,KeypadButton.DUMMY,
                        KeypadButton.DIV,KeypadButton.FOUR,KeypadButton.FIVE,KeypadButton.SIX,KeypadButton.DUMMY,
                        KeypadButton.MULTIPLY,KeypadButton.ONE,KeypadButton.TWO,KeypadButton.THREE,KeypadButton.DUMMY,
                        KeypadButton.PLUS,KeypadButton.BRACKETOPEN,KeypadButton.ZERO, KeypadButton.BRACKETCLOSE,KeypadButton.DUMMY,
                        KeypadButton.MINUS,KeypadButton.DUMMY,KeypadButton.DUMMY,KeypadButton.DUMMY, KeypadButton.DUMMY}
                );
            }
        });
        inputZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentView.setBackgroundResource(R.color.inActiveText);
                currentView = inputZ;
                currentView.setBackgroundResource(R.color.activeText);
                mKeypadAdapter.setButtons(new KeypadButton[]{
                        KeypadButton.Point,KeypadButton.C,KeypadButton.BACKSPACE,KeypadButton.DUMMY,KeypadButton.POW,
                        KeypadButton.SQRT,KeypadButton.SEVEN,KeypadButton.EIGHT,KeypadButton.NINE,KeypadButton.DUMMY,
                        KeypadButton.DIV,KeypadButton.FOUR,KeypadButton.FIVE,KeypadButton.SIX,KeypadButton.DUMMY,
                        KeypadButton.MULTIPLY,KeypadButton.ONE,KeypadButton.TWO,KeypadButton.THREE,KeypadButton.DUMMY,
                        KeypadButton.PLUS,KeypadButton.BRACKETOPEN,KeypadButton.ZERO, KeypadButton.BRACKETCLOSE,KeypadButton.DUMMY,
                        KeypadButton.MINUS,KeypadButton.DUMMY,KeypadButton.DUMMY,KeypadButton.DUMMY, KeypadButton.DUMMY}
                );
            }
        });
        mKeypadGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

            }
        });
    }

    private void ProcessKeypadInput(TextView textView, KeypadButton keypadButton) {

        switch (keypadButton) {
            case C:
                textView.setText(null);
                break;
            case ONE:
            case TWO:
            case THREE:
            case FOUR:
            case FIVE:
            case SIX:
            case SEVEN:
            case EIGHT:
            case NINE:
                if (textView.getText().equals("0")) {
                    textView.setText(keypadButton.mText.toString());
                } else {
                    textView.setText(textView.getText().toString() + keypadButton.mText.toString());
                }
                break;
            case PLUS:
            case MINUS:
            case MULTIPLY:
            case DIV:
            case BRACKETCLOSE:
                textView.setText(textView.getText().toString() + keypadButton.mText.toString());
                break;
            case BRACKETOPEN:
                textView.setText(keypadButton.mText.toString()+textView.getText());
                break;
            case Point:
                if (textView.getText().equals("0")) {
                    textView.setText(textView.getText().toString() + keypadButton.mText.toString());
                } else {
                    String str = textView.getText().toString();
                    if (str.length() != 0) {
                        textView.setText(textView.getText().toString() + keypadButton.mText.toString());
                    }
                }
                break;
            case ZERO:
                if (textView.getText() != "0") {
                    textView.setText(textView.getText().toString() + keypadButton.mText.toString());
                }
                break;
            case SIN:
            case COS:
            case TAN:
            case CTG:
                String str2 = textView.getText().toString();
                if (str2.length() != 0) {
                    textView.setText(textView.getText().toString() + "*" + keypadButton.mText.toString()+"(");
                } else {
                    textView.setText(keypadButton.mText.toString());
                }
                break;
            case CALCULATE:
                MatchParser matchParser = new MatchParser();
                try {
                    double x = Double.parseDouble(inputX.getText().toString());
                    matchParser.setVariable("x", x);
                    double y= Double.parseDouble(inputY.getText().toString());
                    matchParser.setVariable("y",y);
                    double z=Double.parseDouble(inputZ.getText().toString());
                    matchParser.setVariable("z",z);
                    double d = matchParser.Parse(textResult.getText().toString());
                    textView.setText(d + "");
                } catch (Exception e) {
                }
                break;
            case BACKSPACE:
                String str3 = textView.getText().toString();
                try {
                    textView.setText(str3.substring(0, str3.length() - 1));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case X:
                if (textView.getText().length() != 0) {
                    textView.setText(textView.getText().toString() + keypadButton.mText.toString());
                } else {
                    textView.setText(keypadButton.mText.toString());
                }
                break;
            case Y:
                if (textView.getText().length() != 0) {
                    textView.setText(textView.getText().toString() + keypadButton.mText.toString());
                } else {
                    textView.setText(keypadButton.mText.toString());
                }
                break;
            case Z:
                if (textView.getText().length() != 0) {
                    textView.setText(textView.getText().toString() + keypadButton.mText.toString());
                } else {
                    textView.setText(keypadButton.mText.toString());
                }
                break;
            case SQRT:
                textView.setText("sqrt"+"(" +textView.getText().toString()+")");
                break;
            case POW:
                textView.setText("pow"+"("+textView.getText().toString()+")");
                break;
        }
    }


}
