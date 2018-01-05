package com.example.brent.appmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class firstapp extends AppCompatActivity {


    public RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstapp);
        ratingBar =  findViewById(R.id.ratingBar);
        return1();
    }
    public void rateMe(View view){

        Toast.makeText(getApplicationContext(),
                String.valueOf(ratingBar.getRating()), Toast.LENGTH_LONG).show();


    }
    private void return1(){
        Button returntomain1 = findViewById(R.id.returntomain1);
        returntomain1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);

                i.putExtra("rating", "You have rated this app " + String.valueOf(ratingBar.getRating() + " stars out of 5"));
                setResult(1, i);
                finish();
            }
        });
    }
}
