package com.Projet.Android.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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

    private void ouvreActivityScore() {
        Intent intent = new Intent(this, Scores.class);
        startActivity(intent);
    }

    private void ouvreActivityDifficultySelection() {
        Intent intent = new Intent(this, DifficultySelection.class);
        startActivity(intent);
    }
}