package com.example.ghita.myapplication10;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

public class AddEventWindow extends AppCompatActivity {

    CalendarView calendar;
    int saveday;
    int savemonth;
    int saveyear;
    EditText editText;
    String description;
    int consultday;
    int consultmonth;
    int consultyear;
    String cdescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_event);
        editText = (EditText) findViewById(R.id.descr);
        calendar =(CalendarView) findViewById(R.id.calendarView);
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {
                Context context = getApplicationContext();
                String event ;
                saveday = dayOfMonth;
                savemonth = month;
                saveyear = year;
                //event = Event.getEvent(year, month, dayOfMonth);
                Toast.makeText(context,String.valueOf(dayOfMonth) + " " + String.valueOf(DateConverter.getMonth(month)) + " " + String.valueOf(year),Toast.LENGTH_SHORT).show();
                //editText.setText(String.valueOf(dayOfMonth) + " " + String.valueOf(DateConverter.getMonth(month)) + " " + String.valueOf(year));
            }
        });
    }
    public void save(View v){
        Context context = getApplicationContext();
        editText = (EditText) findViewById(R.id.descr);
        description = editText.getText().toString();
        //Toast.makeText(context,description + " est prévu pour le : " + saveday + "/" + savemonth + "/" + saveyear,Toast.LENGTH_SHORT).show();
        DBConnect dbConnect = new DBConnect(context);
        dbConnect.addEvent(saveyear,savemonth,saveday,description);
    }
    public void consult(View v){
        String[] info;
        Context c = getApplicationContext();
        DBConnect dbConnect = new DBConnect(c);
        info = dbConnect.getEvents();
        Toast.makeText(c,"L'événement numéro : "+info[0]+" qui consiste à "+info[1]+" est prévu pour le : "+info[2]+"/"+DateConverter.getMonth(Integer.parseInt(info[3]))+"/"+info[4],Toast.LENGTH_SHORT).show();
    }
}
