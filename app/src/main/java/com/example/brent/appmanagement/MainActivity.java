package com.example.brent.appmanagement;

import android.content.Intent;
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
        getrating();


    }



    private void getrating(){
        //firstrating = findViewById(R.id.savedrating1);
       // secondrating = findViewById(R.id.savedrating2);


        //Intent i = getIntent();
        //firstrating.setText(i.getExtras().getString("rating"));
       // secondrating.setText(i.getStringExtra("rating2"));

//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            String rating = extras.getString("rating");
//            firstrating = findViewById(R.id.savedrating1);
//            firstrating.setText(rating);
//            String rating2 = extras.getString("rating2");
//            secondrating = findViewById(R.id.savedrating2);
//            secondrating.setText(rating2);
//        }

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
                    startActivityForResult(intent, 1);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1){
            if(null != data){
                String r1 = data.getStringExtra("rating");
                firstrating = findViewById(R.id.savedrating1);
                firstrating.setText(r1);
                String r2 = data.getStringExtra("rating2");
                secondrating = findViewById(R.id.savedrating2);
                secondrating.setText(r2);
            }
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
//                    Bundle extras = getIntent().getExtras();
//                    if(extras != null) {
//                        firstrating =  findViewById(R.id.savedrating1);
//                        firstrating.setText(extras.getString("rating"));
//                    }
                    Intent intent2 = new Intent(getApplicationContext(), secondapp.class);
                    startActivityForResult(intent2, 1);
                }
            }
        });
    }
}
