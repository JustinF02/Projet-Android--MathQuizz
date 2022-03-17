package com.Projet.Android.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.Projet.Android.R;

public class AboutUsActivity extends AppCompatActivity {

    private Button buttonBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        buttonBack = findViewById(R.id.btnScoreRetour);
        buttonBack.setOnClickListener(view -> getback());
    }

    private void getback() {
        finish();
    }
}