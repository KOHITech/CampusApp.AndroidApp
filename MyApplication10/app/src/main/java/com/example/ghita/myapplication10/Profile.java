package com.example.ghita.myapplication10;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import static android.view.View.*;


public class Profile extends Fragment{

    public Profile(){

    }

    Context ctx;
    ImageView img;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.profile_view2, container, false);
        ImageView imageView = (ImageView) v.findViewById(R.id.imageView4);
        //Button button = (Button)v.findViewById(R.id.schedul);
        //button.setOnClickListener(this);
        return v;
    }

}
