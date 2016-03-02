package com.example.shikha.navigationdrawer;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar mtoolbar;
    NavigationView mdrawer;
    DrawerLayout drawerlayout;
    ActionBarDrawerToggle mtoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar mtoolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(mtoolbar);
        NavigationView mdrawer=(NavigationView)findViewById(R.id.main_drwaer);
        mdrawer.setNavigationItemSelectedListener(this);

        drawerlayout=(DrawerLayout)findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle mtoogle=new ActionBarDrawerToggle(this,drawerlayout,mtoolbar,
                R.string.open_drawer,R.string.close_drawer);

        drawerlayout.setDrawerListener(mtoogle);
        mtoogle.syncState();


    }
    @Override
    public void onConfigurationChanged(Configuration newconfig)
    {
        super.onConfigurationChanged(newconfig);
        mtoogle.onConfigurationChanged(newconfig);

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Intent intent=null;
        if(item.getItemId()==R.id.navigation_item_1)
        {
            drawerlayout.closeDrawer(GravityCompat.START);
            intent=new Intent(this,SecondActivity.class);
            startActivity(intent);

            return true;
        }
        if(item.getItemId()==R.id.navigation_item_2)
        {
            drawerlayout.closeDrawer(GravityCompat.START);
            intent=new Intent(this,ThirdActivity.class);
            startActivity(intent);

            return true;
        }
        return false;
    }
}
