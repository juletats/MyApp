package com.example.julia.myproject;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;


public class KeypadAdapter extends BaseAdapter {
    private Context mContext;

    private OnClickListener mOnButtonClick;

    public KeypadAdapter(Context c) {
        mContext = c;
    }

    public void setOnButtonClickListener(OnClickListener listener) {
        mOnButtonClick = listener;
    }

    public int getCount() {
        return mButtons.length;
    }

    public Object getItem(int position) {
        return mButtons[position];
    }

    public long getItemId(int position) {
        return 0;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        Button btn;
        if (convertView == null) {

            btn = new Button(mContext);
            KeypadButton keypadButton = mButtons[position];

            if (keypadButton != KeypadButton.DUMMY)
                btn.setOnClickListener(mOnButtonClick);
            if((keypadButton == KeypadButton.CTG)|| (keypadButton == KeypadButton.TAN) || (keypadButton== KeypadButton.SIN)|| (keypadButton==KeypadButton.COS))
            btn.setBackgroundResource(R.drawable.trigonometry);
            if((keypadButton ==KeypadButton.ONE)||(keypadButton ==KeypadButton.TWO)||(keypadButton ==KeypadButton.THREE)||
            (keypadButton ==KeypadButton.FOUR)||(keypadButton ==KeypadButton.FIVE)||(keypadButton ==KeypadButton.SIX)||
            (keypadButton ==KeypadButton.SEVEN)||(keypadButton ==KeypadButton.EIGHT)||(keypadButton ==KeypadButton.NINE)||
            (keypadButton ==KeypadButton.ZERO)){
                btn.setBackgroundResource(R.drawable.number);
            }
            if((keypadButton==keypadButton.PLUS)|| (keypadButton == keypadButton.MINUS)
                    ||(keypadButton==keypadButton.MULTIPLY)||(keypadButton==keypadButton.DIV))
            {btn.setBackgroundResource(R.drawable.operator);}
            if( (keypadButton==keypadButton.SQRT)||(keypadButton==keypadButton.POW)|| (keypadButton==keypadButton.Point)|| (keypadButton == keypadButton.DIV1onX))
            {btn.setBackgroundResource(R.drawable.other);}
           if (( keypadButton == keypadButton.BRACKETCLOSE) || (keypadButton == keypadButton.BRACKETOPEN))
            {btn.setBackgroundResource(R.drawable.brackets);}
            if ( (keypadButton== keypadButton.CALCULATE)) {
                btn.setBackgroundResource(R.drawable.result);
            }
            if((keypadButton == keypadButton.C)||(keypadButton == keypadButton.BACKSPACE)){
                btn.setBackgroundResource(R.drawable.clear);
            }
            if((keypadButton== keypadButton.X)||(keypadButton== keypadButton.Z)|| (keypadButton == keypadButton.Y)){
                btn.setBackgroundResource(R.drawable.variables);
            }
            btn.setTag(keypadButton);
        } else {
            btn = (Button) convertView;
        }

        btn.setText(mButtons[position].getText());
        return btn;
    }

    public void setButtons(KeypadButton[] mButtons) {
        this.mButtons = mButtons;
        this.notifyDataSetChanged();
    }



    private KeypadButton[] mButtons = {

            KeypadButton.Point,KeypadButton.C,KeypadButton.BACKSPACE,KeypadButton.CALCULATE,KeypadButton.POW,
            KeypadButton.SQRT,KeypadButton.SEVEN,KeypadButton.EIGHT,KeypadButton.NINE,KeypadButton.SIN,
            KeypadButton.DIV,KeypadButton.FOUR,KeypadButton.FIVE,KeypadButton.SIX,KeypadButton.COS,
            KeypadButton.MULTIPLY,KeypadButton.ONE,KeypadButton.TWO,KeypadButton.THREE,KeypadButton.TAN,
            KeypadButton.PLUS,KeypadButton.BRACKETOPEN,KeypadButton.ZERO, KeypadButton.BRACKETCLOSE,KeypadButton.CTG,
            KeypadButton.MINUS,KeypadButton.X,KeypadButton.Y,KeypadButton.Z, KeypadButton.DIV1onX};
}