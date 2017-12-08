package com.example.pushkar.seniordesign;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.SearchView;

public class Home extends AppCompatActivity {
    Toolbar toolbar;
    DrawerLayout drawer_layout;
    SearchView searchView;
    ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawer_layout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawer_layout.setDrawerListener(actionBarDrawerToggle);
        searchView = (SearchView) findViewById(R.id.searchViewID);
        searchView.setIconifiedByDefault(false);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                //Search button of keyboard
                goToNextPageFromSearch();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    private void goToNextPageFromSearch(){
        Intent intent = new Intent(Home.this,BusinessDisplay.class);
        startActivity(intent);

    }

    @Override
    public void onBackPressed() {
        //close the navigation drawer if its open or else do nothing.
        if(drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(Gravity.LEFT);
        }

    }

    @Override   //close the softkeyboard on touch on screen
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }

}
