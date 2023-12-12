package edu.psu.ist.hcdd340.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RatingBar;

public class WatchListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.watch_list_activity);

        //Creates data saving object for ratings
        SharedPreferences watchListRatings = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = watchListRatings.edit();

        RatingBar parasiteRatingBar = findViewById(R.id.parasiteRatingBar);
        RatingBar bladeRunnerRatingBar = findViewById(R.id.bladeRunnerRatingBar);
        RatingBar barbieRatingBar = findViewById(R.id.barbieRatingBar);

        //Sets the data saved in watchListRatings to what is displayed
        float parasiteSavedRating = watchListRatings.getFloat("parasite", 0.0f);
        float bladeRunnerSavedRating = watchListRatings.getFloat("blade runner", 0.0f);
        float barbieSavedRating = watchListRatings.getFloat("barbie", 0.0f);

        parasiteRatingBar.setRating(parasiteSavedRating);
        bladeRunnerRatingBar.setRating(bladeRunnerSavedRating);
        barbieRatingBar.setRating(barbieSavedRating);
        parasiteRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingBar.setRating(rating);
                //applies changes to SharedPreferences object
                editor.putFloat("parasite", ratingBar.getRating());
                editor.apply();

            }
        });
        bladeRunnerRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingBar.setRating(rating);
                //applies changes to SharedPreferences object
                editor.putFloat("blade runner", ratingBar.getRating());
                editor.apply();

            }
        });
        barbieRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ratingBar.setRating(rating);
                //applies changes to SharedPreferences object
                editor.putFloat("barbie", ratingBar.getRating());
                editor.apply();

            }
        });
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