package com.example.ghita.myapplication10;

import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by ghita on 28/11/2016.
 */

public class Schedule extends Fragment  {

    public Schedule(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.schedule_view2, container, false);
        //Button button = (Button)v.findViewById(R.id.profil);
        //button.setOnClickListener(this);
        return v;
    }


}
