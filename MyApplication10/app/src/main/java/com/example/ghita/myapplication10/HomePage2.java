package com.example.ghita.myapplication10;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomePage2 extends AppCompatActivity {

    private Toolbar toolbar;
    boolean status = false;
    Button btn1,btn2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.containers2);
        toolbar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        btn1 = (Button)findViewById(R.id.profil);
        btn2 = (Button)findViewById(R.id.schedul);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(!status) {
            Profile profile = new Profile();
            ft.add(R.id.fragment_container2, profile);
            ft.commit();
            btn1.setBackgroundResource(R.drawable.shadow_box_top);
            btn2.setBackgroundResource(R.drawable.inactive_shadow_box);
            status = true;
        }
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                if(!status){
                    Profile profile = new Profile();
                    ft.replace(R.id.fragment_container2,profile);
                    ft.commit();
                    btn1.setBackgroundResource(R.drawable.shadow_box_top);
                    btn2.setBackgroundResource(R.drawable.inactive_shadow_box);
                    status = true;
                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                if(status==true){
                    Schedule schedule = new Schedule();
                    ft.replace(R.id.fragment_container2,schedule);
                    ft.commit();
                    btn2.setBackgroundResource(R.drawable.shadow_box_top);
                    btn1.setBackgroundResource(R.drawable.inactive_shadow_box);
                    status = false;
                }
            }
        });


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
