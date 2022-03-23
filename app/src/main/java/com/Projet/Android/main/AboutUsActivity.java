package com.Projet.Android.main;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.Projet.Android.R;

public class AboutUsActivity extends AppCompatActivity {

    private Button buttonBack;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        buttonBack = findViewById(R.id.btnScoreRetour);
        buttonBack.setOnClickListener(view -> getback());
        img = findViewById(R.id.imageView);
        img.setImageResource(R.drawable.logoinfocontact);
    }

    private void getback() {
        finish();
    }
}