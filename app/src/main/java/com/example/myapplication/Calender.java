package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.widget.CalendarView;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class Calender extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    CalendarView calendar;
    TextView date_view;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState){
      super.onCreate(savedInstanceState);
      setContentView(R.layout.calender);

      calendar=findViewById(R.id.calendar);
      date_view=findViewById(R.id.date_view);
      date_view.setVisibility(TextView.INVISIBLE);
      navigationView=findViewById(R.id.nav_viewc);
        Toolbar toolbar = findViewById(R.id.toolbarc);
        setSupportActionBar(toolbar);
        drawerLayout=findViewById(R.id.drawerc);
        navigationView=findViewById(R.id.nav_viewc);
        toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
      calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
          @Override
          public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
              String Date = dayOfMonth+"/"+(month+1)+"/"+year;
              date_view.setText(Date);
              date_view.setVisibility(TextView.VISIBLE);

          }
      });
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.FirstItem:
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);

                return true;
            case R.id.SecondItem:
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            default:
                return true;
        }
    }
}