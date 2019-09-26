package com.example.myapplication58;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private ListView l1_lv;
    DatabaseReference databaseReference;
    private List<Calculator>calculatorList;
    private  Customadapter customadapter;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        databaseReference= FirebaseDatabase.getInstance().getReference("Calculator");
        calculatorList=new ArrayList<>();
        customadapter=new Customadapter(DetailActivity.this,calculatorList);
        l1_lv=(ListView)findViewById(R.id.l1_lv);
    }
    protected  void onStart()
    {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                calculatorList.clear();
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren())
                {
                    Calculator calculator=dataSnapshot1.getValue(Calculator.class);
                    calculatorList.add(calculator);
                }
                l1_lv.setAdapter(customadapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }

}
