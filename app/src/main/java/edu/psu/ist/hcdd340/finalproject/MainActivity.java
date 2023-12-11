package edu.psu.ist.hcdd340.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);


    }
    // Menu Handling
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId = item.getItemId();
        if (menuId == R.id.menu_watched) {
            Intent watchListIntent = new Intent(this, WatchListActivity.class);
            startActivity(watchListIntent);
            return true;
        }
        else if (menuId == R.id.menu_planning) {
            Intent planningListIntent = new Intent(this, PlanningListActivity.class);
            startActivity(planningListIntent);
            return true;
        }
        return false;
    }

}