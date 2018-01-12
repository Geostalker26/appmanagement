package com.example.brent;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.brent.appmanagement.R;


public class myfragment extends Fragment {

    public static myfragment newInstance(int index) {
        myfragment f = new myfragment();
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.myfragmentlayout, container, false);


        Button mybutton  = view.findViewById(R.id.fragmentbutton);
        mybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),
                        "This Button is a fragment", Toast.LENGTH_LONG).show();
            }
        });




        return view;
    }
}
