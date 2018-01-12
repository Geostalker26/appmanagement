package com.example.brent.appmanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class firstapp extends AppCompatActivity {


    //Define Rating bar
    public RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstapp);

        SharedPreferences datasent = getSharedPreferences("SendingData", MODE_PRIVATE);

        ratingBar =  findViewById(R.id.ratingBar);
        float setrate = datasent.getFloat("rating1", 0f);
        ratingBar.setRating(setrate);
        return1();




    }
    public void rateMe(View view){

        Toast.makeText(getApplicationContext(),
                String.valueOf(ratingBar.getRating()), Toast.LENGTH_LONG).show();


    }


    public void return1(){
        Button returntomain1 = findViewById(R.id.returntomain1);

        SharedPreferences datasent = getSharedPreferences("SendingData", MODE_PRIVATE);
        final SharedPreferences.Editor editor = datasent.edit();

        returntomain1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Float data = (ratingBar.getRating());

                editor.putFloat("rating1", data);
                editor.apply();

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}
