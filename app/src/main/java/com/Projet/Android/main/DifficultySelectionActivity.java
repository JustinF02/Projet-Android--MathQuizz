package com.Projet.Android.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.Projet.Android.typeEnum.typeDifficulty;
import com.Projet.Android.R;

public class DifficultySelectionActivity extends AppCompatActivity {

    private typeDifficulty level = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_selection);

        Button boutonEasy = findViewById(R.id.btnEasy);
        Button boutonMedium = findViewById(R.id.btnMedium);
        Button boutonDifficult = findViewById(R.id.btnDifficult);

        Button boutonRetour = findViewById(R.id.btnDifficultyRetour);

        boutonEasy.setOnClickListener(view -> StatutLevel(typeDifficulty.EASY));
        boutonMedium.setOnClickListener(view ->StatutLevel(typeDifficulty.MEDIUM));
        boutonDifficult.setOnClickListener(view ->StatutLevel(typeDifficulty.DIFFICULT));

        boutonRetour.setOnClickListener(view -> retourneAuPrecedent());
    }
    private void StatutLevel(typeDifficulty level) {
        switch (level){
            case EASY:
                this.level = typeDifficulty.EASY;
                break;
            case MEDIUM:
                this.level = typeDifficulty.MEDIUM;
                break;
            case DIFFICULT:
                this.level = typeDifficulty.DIFFICULT;
                break;
        }
        ouvrePlayZone(level);
    }

    public typeDifficulty getLevel(){
        return level;
    }

    private void ouvrePlayZone(typeDifficulty level) {
        Intent intent = new Intent(this, PlayZoneActivity.class);
        intent.putExtra("level", level);
        startActivity(intent);
    }
    private void retourneAuPrecedent() {
        finish();
    }
}