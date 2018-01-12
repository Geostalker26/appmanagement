package com.example.brent.appmanagement;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class secondapp extends AppCompatActivity {

    public RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondapp);
        return2();
        ratingBar =  findViewById(R.id.ratingBar);
    }
    public void rateMe(View view){

        Toast.makeText(getApplicationContext(),
                String.valueOf(ratingBar.getRating()), Toast.LENGTH_LONG).show();
    }
    public void return2(){
        Button returntomain2 = findViewById(R.id.returntomain2);
        returntomain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent i = new Intent(getApplicationContext(), MainActivity.class);*//*
                i.putExtra("rating2", "you have rated this app " + String.valueOf(ratingBar.getRating() + " stars out of 5"));
                setResult(-1);
                finish();*/
                Float data2 = (ratingBar.getRating());


                SharedPreferences datasent = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = datasent.edit();
                editor.putFloat("rating1", data2);
                editor.apply();

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}
