package com.example.ghita.myapplication10;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.LinearLayout;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import static android.support.v7.appcompat.R.styleable.View;

public class Planweek extends AppCompatActivity {

    CalendarView calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plan_week);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(myToolbar);
        calendar =(CalendarView) findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                Context context = getApplicationContext();
                String event ;
                //event = Event.getEvent(year, month, dayOfMonth);
                Toast.makeText(context,"Le "+String.valueOf(dayOfMonth)+ " " + String.valueOf(DateConverter.getMonth(month))+ " " + String.valueOf(year),Toast.LENGTH_SHORT).show();
                //Toast.makeText(context,event,Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void add_event(View v){
        startActivity(new Intent(Planweek.this, AddEventWindow.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.Home) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
