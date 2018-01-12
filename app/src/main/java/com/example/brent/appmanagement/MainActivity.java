package com.example.brent.appmanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView firstrating, secondrating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingapp1();
        ratingapp2();

        SharedPreferences datasent = getSharedPreferences("SendingData", MODE_PRIVATE);
        float SetText1  = datasent.getFloat("rating1", 0f);
        float SetText2 = datasent.getFloat("rating2", 0f);
        firstrating = findViewById(R.id.savedrating1);
        if (SetText1 == 0f){
            firstrating.setText("");
        }else {
            firstrating.setText("You rated this app " + String.valueOf(SetText1) + " out of 5 stars");
        }
        secondrating = findViewById(R.id.savedrating2);
        if(SetText2 == 0f){
            secondrating.setText("");
        }else {
            secondrating.setText("You rated this app " + String.valueOf(SetText2) + " out of 5 stars");
        }
    }





    private void ratingapp2(){
        Button rateapp2 = findViewById(R.id.rateapp2);
        rateapp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT){
                    Toast.makeText(getApplicationContext(),
                            "Sorry you need to upgrade your phone before you can rate the apps", Toast.LENGTH_LONG).show();
                }else {
                    Intent intent2 = new Intent(getApplicationContext(), secondapp.class);
                    //startActivity(intent2);
                }
            }
        });
    }
    private void ratingapp1(){
        Button rateapp1 = findViewById(R.id.rateapp1);
        rateapp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT){
                    Toast.makeText(getApplicationContext(),
                            "Sorry you need to upgrade your phone before you can rate the apps", Toast.LENGTH_LONG).show();
                }else {
                    Intent intent = new Intent(getApplicationContext(), firstapp.class);
                    startActivity(intent);
                }
            }
        });
    }
}
