package edu.psu.ist.hcdd340.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Rating;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;

public class PlanningListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plan_watch_activity);

        RatingBar theBearRB = findViewById(R.id.theBearRatingBar);
        RatingBar youRB = findViewById(R.id.youRatingBar);
        RatingBar theBoysRB = findViewById(R.id.theBoysRatingBar);

        // Sets AVG Rating
        theBearRB.setRating(4.5f);
        youRB.setRating(4f);
        theBoysRB.setRating(4.5f);

        // Disables rating bars
        theBearRB.setIsIndicator(true);
        youRB.setIsIndicator(true);
        theBoysRB.setIsIndicator(true);
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
        if (menuId == R.id.menu_planning) {
            Intent planningListIntent = new Intent(this, PlanningListActivity.class);
            startActivity(planningListIntent);
            return true;
        }
        return false;
    }
}