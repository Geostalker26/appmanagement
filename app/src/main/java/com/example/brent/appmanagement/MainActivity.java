package com.example.brent.appmanagement;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
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
        getrating();

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putString("mydata", firstrating.getText().toString());
        outState.putString("alsomydata", secondrating.getText().toString());

        super.onSaveInstanceState(outState, outPersistentState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        firstrating.setText(savedInstanceState.getString("mydata"));
        secondrating.setText(savedInstanceState.getString("alsomydata"));
    }

    private void getrating(){
        firstrating = findViewById(R.id.savedrating1);
        secondrating = findViewById(R.id.savedrating2);

        Intent i = getIntent();
        firstrating.setText(i.getStringExtra ("rating"));
        secondrating.setText(i.getStringExtra("rating2"));

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
                    startActivity(new Intent(MainActivity.this, firstapp.class));
                }
            }
        });
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
                    startActivity(new Intent(MainActivity.this, secondapp.class));
                }
            }
        });
    }
}
