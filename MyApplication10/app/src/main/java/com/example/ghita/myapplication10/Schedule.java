package com.example.ghita.myapplication10;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.provider.DocumentsContract;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.util.Date;
import java.util.Locale;

/**
 * Created by ghita on 28/11/2016.
 */

@RequiresApi(api = Build.VERSION_CODES.N)
public class Schedule extends Fragment  {

    CompactCalendarView calendar;
    FrameLayout frame;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());

    public Schedule(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.schedule_view2, container, false);
        //Button button = (Button)v.findViewById(R.id.profil);
        //button.setOnClickListener(this);
        final android.support.v7.app.ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(false);
        //actionBar.setTitle(null);
        //frame = (FrameLayout) v.findViewById(R.id.frame);
        calendar = (CompactCalendarView) v.findViewById(R.id.calendar_view);

        Event ev1 = new Event(Color.RED, 1485352800L, "Tu as une réunion avec ton tuteur");
        calendar.addEvent(ev1);
        calendar.setListener(new CompactCalendarView.CompactCalendarViewListener(){
            @Override
            public void onDayClick(Date dateClicked){
                Context context = getContext();
                if(dateClicked.toString().compareTo("Wed Jan 25 14:00:00 AST 2017")==0){
                    Toast.makeText(context,"Réunion tuteur",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(context,"Vous n'avez pas prévu de tâches",Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onMonthScroll(Date firstDayOfNewMonth){
                //actionBar.setTitle(dateFormatMonth.format(firstDayOfNewMonth));
            }
        });


        return v;
    }


}
