package edu.psu.ist.hcdd340.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        Button button = findViewById(R.id.loginButton);
        button.setOnClickListener(this);

    }

    private final static String TAG = "LOG_IN";

    @Override
    public void onClick(View view) {
        EditText emailEditText = findViewById(R.id.editTextEmail);
        String email = emailEditText.getText().toString();;

        EditText passwordEditText = findViewById(R.id.editTextPassword);
        String password = passwordEditText.getText().toString();
        Button button = findViewById(R.id.loginButton);

        if (email.equals("")){
            Snackbar.make(button, R.string.no_email, Snackbar.LENGTH_LONG).show();
        }
        else if (password.equals("")) {
            Snackbar.make(button, R.string.no_password, Snackbar.LENGTH_LONG).show();
        }
        else{

        Intent intent = new Intent(MainActivity.this, WatchListActivity.class);
        startActivity(intent);

        Log.d(TAG, "Email entered: " + email + " and Password: " + password);
        }
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
        else if(menuId == R.id.menu_profile){
            Intent profileIntent = new Intent(this, ProfileActivity.class);
            startActivity(profileIntent);
            return true;
        }
        return false;
    }

}