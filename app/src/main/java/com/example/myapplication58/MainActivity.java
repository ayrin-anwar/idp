package com.example.myapplication58;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {


    private EditText n1_et,n2_et;
    private TextView result_tv;
    DatabaseReference  databaseReference;
    private Button add_bt,sub_bt,mul_bt,div_bt,adv_bt;
private Button load_bt;
    int n1,n2,result;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        n1_et=findViewById(R.id.n1_et);
        n2_et=findViewById(R.id.n2_et);

        result_tv=findViewById(R.id.result_tv);

        add_bt=findViewById(R.id.add_bt);
        sub_bt=findViewById(R.id.sub_bt);
        mul_bt=findViewById(R.id.mul_bt);
        div_bt=findViewById(R.id.div_bt);
        adv_bt=findViewById(R.id.adv_bt);
        load_bt=findViewById(R.id.load_bt);
        databaseReference = FirebaseDatabase.getInstance().getReference("Calculator");databaseReference = FirebaseDatabase.getInstance().getReference("Calculator");databaseReference = FirebaseDatabase.getInstance().getReference("Calculator");
        add_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (n1_et.getText().toString().isEmpty() || n2_et.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Please first fill up the numbers",Toast.LENGTH_LONG).show();
                    return;
                }
                n1=Integer.parseInt(n1_et.getText().toString());
                n2=Integer.parseInt(n2_et.getText().toString());
                result=n1+n2;
                result_tv.setText(String.valueOf(result));
                String num3;
                String num1;
                String num2;
                num1=n1_et.getText().toString();
                num2=n2_et.getText().toString();

                num3=String.valueOf(result);
                String key=databaseReference.push().getKey();
                Calculator calculator1=new Calculator(num1,num2,num3);
                databaseReference.child(key).setValue(calculator1);
            }
        });

        sub_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (n1_et.getText().toString().isEmpty() || n2_et.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Please first fill up the numbers",Toast.LENGTH_LONG).show();
                    return;
                }
                n1=Integer.parseInt(n1_et.getText().toString());
                n2=Integer.parseInt(n2_et.getText().toString());
                result=n1-n2;
                result_tv.setText(String.valueOf(result));
                String num3;
                String num1;
                String num2;
                num1=n1_et.getText().toString();
                num2=n2_et.getText().toString();

                num3=String.valueOf(result);
                String key=databaseReference.push().getKey();
                Calculator calculator1=new Calculator(num1,num2,num3);
                databaseReference.child(key).setValue(calculator1);
            }
        });

        mul_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (n1_et.getText().toString().isEmpty() || n2_et.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Please first fill up the numbers",Toast.LENGTH_LONG).show();
                    return;
                }
                n1=Integer.parseInt(n1_et.getText().toString());
                n2=Integer.parseInt(n2_et.getText().toString());
                result=n1*n2;
                result_tv.setText(String.valueOf(result));
                String num3;
                String num1;
                String num2;
                num1=n1_et.getText().toString();
                num2=n2_et.getText().toString();
                num3=String.valueOf(result);
                String key=databaseReference.push().getKey();
                Calculator calculator1=new Calculator(num1,num2,num3);
                databaseReference.child(key).setValue(calculator1);
            }
        });

        div_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (n1_et.getText().toString().isEmpty() || n2_et.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"Please first fill up the numbers",Toast.LENGTH_LONG).show();
                    return;
                }
                n1=Integer.parseInt(n1_et.getText().toString());
                n2=Integer.parseInt(n2_et.getText().toString());
                if (n2==0){
                    result_tv.setText(String.valueOf("Infinite"));
                    return;
                }
                result=n1/n2;
                result_tv.setText(String.valueOf(result));
                String num3;
                String num1;
                String num2;
                num1=n1_et.getText().toString();
                num2=n2_et.getText().toString();

                num3=String.valueOf(result);
                String key=databaseReference.push().getKey();
                Calculator calculator1=new Calculator(num1,num2,num3);
                databaseReference.child(key).setValue(calculator1);
            }
        });

        adv_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goto_advanced_activity();
            }
        });
        load_bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent adv_in = new Intent(MainActivity.this,DetailActivity
                        .class);
                startActivity(adv_in);
            }
        });
    }
    public void goto_advanced_activity(){
        Intent adv_in = new Intent(MainActivity.this,AdvcalActivity
                .class);
       startActivity(adv_in);
    }

}
