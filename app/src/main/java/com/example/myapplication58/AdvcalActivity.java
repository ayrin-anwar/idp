package com.example.myapplication58;

import android.view.View;

import android.os.Bundle;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AdvcalActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edittext3;
    private TextView textview2;
    private Button button_sin, button_cos, button_tan, button_sqrt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.advcal);
        edittext3 = (EditText) findViewById(R.id.editText_numb3);
        textview2 = findViewById(R.id.textView_result2);
        button_sin = findViewById(R.id.button_sine);


        button_cos = findViewById(R.id.button_cos);
        button_tan = findViewById(R.id.button_tan);
        button_sqrt = findViewById(R.id.button_sqrt);

        button_sin.setOnClickListener(this);
        button_cos.setOnClickListener(this);
        button_tan.setOnClickListener(this);
        button_sqrt.setOnClickListener(this);
    }

    public void onClick(View view) {
        try {

            String n1 = edittext3.getText().toString();
            double n2 = Double.parseDouble(n1);
            double Change = (Math.PI / 180) * n2;

            if (view.getId() == R.id.button_sine) {
                Double R = Math.sin(Change);
                textview2.setText("Result :" + R);
            }


            if (view.getId() == R.id.button_cos) {
                Double R = Math.cos(Change);
                textview2.setText("Result :" + R);
            }


            if (view.getId() == R.id.button_tan) {
                Double R = Math.tan(Change);
                textview2.setText("Result :" + R);
            }


            if (view.getId() == R.id.button_sqrt) {
                Double R = Math.sqrt(n2);
                textview2.setText("Result :" + R);
            }
        } catch (Exception e) {
            Toast.makeText(AdvcalActivity.this, "Enter the correct number", Toast.LENGTH_LONG).show();

        }

    }
}
