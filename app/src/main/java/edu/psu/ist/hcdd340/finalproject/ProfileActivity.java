package edu.psu.ist.hcdd340.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
    }
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
        } else if (menuId == R.id.menu_planning) {
            Intent planningListIntent = new Intent(this, PlanningListActivity.class);
            startActivity(planningListIntent);
            return true;
        } else if (menuId == R.id.menu_profile){
            Intent profileIntent = new Intent(this, ProfileActivity.class);
            startActivity(profileIntent);
            return true;
        } else if (menuId == R.id.menu_milestones) {
            Intent milestonesIntent = new Intent(this, MilestonesActivity.class);
            startActivity(milestonesIntent);
            return true;
        } else {
            return false;
        }
    }
}
