package com.Projet.Android.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import com.Projet.Android.R;

public class Scores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        Button boutonRetour = findViewById(R.id.btnScoreRetour);
        boutonRetour.setOnClickListener(view -> retourneAuPrecedent());
    }
    /*
    private boolean videScores() {

    }*/

    private void retourneAuPrecedent() {
        finish();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_scores, menu);

        MenuItem itemClean = menu.findItem(R.id.toolbarViderScores);
        itemClean.setOnMenuItemClickListener(menuItem -> videScores());
        return super.onCreateOptionsMenu(menu);
    }
    public boolean videScores() {

        return true;
    }
}