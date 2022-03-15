package com.Projet.Android.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import com.Projet.Android.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boutonScore = findViewById(R.id.btnScores);
        boutonScore.setOnClickListener(view -> ouvreActivityScore());
        Button boutonPlay = findViewById(R.id.btnPlay);
        boutonPlay.setOnClickListener(view -> ouvreActivityDifficultySelection());
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_mainactivity, menu);

        MenuItem itemScores = menu.findItem(R.id.toolbarAbout);
        itemScores.setOnMenuItemClickListener(menuItem -> ouvreActivityAboutUs());
        return super.onCreateOptionsMenu(menu);
    }

    private boolean ouvreActivityAboutUs() {
        Intent intent = new Intent(this, aboutus.class);
        startActivity(intent);
        return true;
    }

    private void ouvreActivityScore() {
        Intent intent = new Intent(this, ScoresActivity.class);
        startActivity(intent);
    }

    private void ouvreActivityDifficultySelection() {
        Intent intent = new Intent(this, DifficultySelection.class);
        startActivity(intent);
    }
}