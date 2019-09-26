package com.example.myapplication58;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import static com.example.myapplication58.R.id.result_tv;


public class Customadapter  extends ArrayAdapter<Calculator>
         {
            private Activity context;
            private List<Calculator> calculatorlist;


             public Customadapter(Activity context,  List<Calculator> calculatorlist) {
                 super(context,R.layout.sample, calculatorlist);
                 this.context=context;
                 this.calculatorlist = calculatorlist;
             }


             public View getView(int position, View convertView, ViewGroup parent) {
                 LayoutInflater layoutInflater=context.getLayoutInflater();
                 View view=layoutInflater.inflate(R.layout.sample,null,true);
                 Calculator calculator=calculatorlist.get(position);

                 TextView n11_et=view.findViewById(R.id.n11_et);
                TextView n21_et=view.findViewById(R.id.n21_et);
                TextView result1_tv;
                 result1_tv = view. findViewById(R.id.result1_tv);
                 n11_et.setText(calculator.getNum1());
                 n21_et.setText(calculator.getNum2());
                 result1_tv.setText(calculator.getNum3());
                 return view;
             }


         }
