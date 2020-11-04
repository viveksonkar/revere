package in.co.ingenieur.revere.service;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import in.co.ingenieur.revere.R;
import in.co.ingenieur.revere.activities.MovieMaker;
import in.co.ingenieur.revere.activities.Trending;

public class BottomNavigationMenuService {

    private final static String TAG = "BottomNavigationMenuService";

    public static void handleNavigation(BottomNavigationView bottomNavigationView, AppCompatActivity appCompatActivity){
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    Log.i(TAG, "Home Clicked");
                    break;
                case R.id.nav_trending:
                    Log.i(TAG, "Trending Clicked");
                    Intent trendingIntent = new Intent(appCompatActivity.getApplicationContext(), Trending.class);
                    appCompatActivity.startActivity(trendingIntent);
                    break;
                case R.id.nav_composer:
                    Log.i(TAG, "Composer Clicked");
                    Intent movieMakerIntent = new Intent(appCompatActivity.getApplicationContext(), MovieMaker.class);
                    appCompatActivity.startActivity(movieMakerIntent);
                    break;
                case R.id.nav_notifications:
                    Log.i(TAG, "Notifications Clicked");
                    break;
                case R.id.nav_profile:
                    Log.i(TAG, "Profile Clicked");
                    break;
            }
            return true;
        });

        BadgeDrawable notificationBadge = bottomNavigationView.getOrCreateBadge(R.id.nav_notifications);
        notificationBadge.setVisible(true);
        notificationBadge.setNumber(7);

        FloatingActionButton floatingActionButton = (FloatingActionButton)bottomNavigationView
                .findViewById(R.id.nav_composer_large);

        floatingActionButton.setOnClickListener(view -> {
            Log.d(TAG,"FAB Composer button clicked");
            Intent intent = new Intent(appCompatActivity.getApplicationContext(), MovieMaker.class);
            appCompatActivity.startActivity(intent);
        });
    }

}
