package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.plusminusview.PlusMinusView;

public class MainActivity extends AppCompatActivity {

    PlusMinusView plusMinusView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        plusMinusView = findViewById(R.id.plus_minu_view);

        plusMinusView.setInterface(new PlusMinusView.OnPlusMinusClickListeners() {
            @Override
            public void onButtonTypeClicked(String type) {
                Toast.makeText(MainActivity.this, ""+type, Toast.LENGTH_SHORT).show();

            }
        });



        findViewById(R.id.trial).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, ""+plusMinusView.getValue(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
