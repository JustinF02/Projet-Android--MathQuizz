package com.Projet.Android.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.Projet.Android.R;
import com.Projet.Android.data.Score;
import com.Projet.Android.data.ScoreDao;
import com.Projet.Android.data.ScoreService;
import com.Projet.Android.data.ComputeBaseHelper;


public class ScoresActivity extends AppCompatActivity {

    private ScoreService scoreservice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        Button boutonRetour = findViewById(R.id.btnScoreRetour);
        boutonRetour.setOnClickListener(view -> retourneAuPrecedent());
        TextView textViewEASYNombreCalcul = findViewById(R.id.textViewEASYNombreCalculResult);
        TextView textViewMEDIUMNombreCalcul = findViewById(R.id.textViewMEDIUMNombreCalculResult);
        TextView textViewDIFFICULTNombreCalcul = findViewById(R.id.textViewDIFFICULTNombreCalculResult);

        TextView textViewEASYSuccess = findViewById(R.id.textViewEASYSuccessResult);
        TextView textViewMEDIUMSuccess = findViewById(R.id.textViewMEDIUMSuccesResult);
        TextView textViewDIFFICULTSuccess = findViewById(R.id.textViewDIFFICULTSuccesResult);

        TextView textViewEASYRate = findViewById(R.id.textViewEASYTauxResult);
        TextView textViewMEDIUMRate = findViewById(R.id.textViewMEDIUMTauxResult);
        TextView textViewDIFFICULTRate = findViewById(R.id.textViewDIFFICULTTauxResult);

        scoreservice = new ScoreService(new ScoreDao(new ComputeBaseHelper(this)));

        Score dernierScore = scoreservice.getLast();
        if(dernierScore == null){
            textViewEASYNombreCalcul.setText("");
            textViewMEDIUMNombreCalcul.setText("");
            textViewDIFFICULTNombreCalcul.setText("");

            textViewEASYSuccess.setText("");
            textViewMEDIUMSuccess.setText("");
            textViewDIFFICULTSuccess.setText("");

            textViewEASYRate.setText("");
            textViewMEDIUMRate.setText("");
            textViewDIFFICULTRate.setText("");
        }else{
            textViewEASYNombreCalcul.setText(dernierScore.getNbOpEASY().toString());
            textViewMEDIUMNombreCalcul.setText(dernierScore.getNbOpMEDIUM().toString());
            textViewDIFFICULTNombreCalcul.setText(dernierScore.getNbOpDIFFICULT().toString());

            textViewEASYSuccess.setText(dernierScore.getNbSuccesEASY().toString());
            textViewMEDIUMSuccess.setText(dernierScore.getNbSuccesMEDIUM().toString());
            textViewDIFFICULTSuccess.setText(dernierScore.getNbSuccesDIFFICULT().toString());

            Double nbOpEASY = Double.valueOf(dernierScore.getNbOpEASY());
            Double nbSucEASY =  Double.valueOf(dernierScore.getNbSuccesEASY());

            Double nbOpMEDIUM = Double.valueOf(dernierScore.getNbOpMEDIUM());
            Double nbSucMEDIUM =  Double.valueOf(dernierScore.getNbSuccesMEDIUM());

            Double nbOpDIFFICULT = Double.valueOf(dernierScore.getNbOpDIFFICULT());
            Double nbSucDIFFICULT =  Double.valueOf(dernierScore.getNbSuccesDIFFICULT());

            Double tauxEASY = (nbSucEASY/nbOpEASY)*100;
            Double tauxMEDIUM = (nbSucMEDIUM/nbOpMEDIUM)*100;
            Double tauxDIFFICULT = (nbSucDIFFICULT/nbOpDIFFICULT)*100;

            textViewEASYRate.setText(String.valueOf(Math.round(tauxEASY) + " %"));
            textViewMEDIUMRate.setText(String.valueOf(Math.round(tauxMEDIUM) + " %"));
            textViewDIFFICULTRate.setText(String.valueOf(Math.round(tauxDIFFICULT)+ " %"));
        }
    }

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
        scoreservice.clearTable();
        retourneAuPrecedent();
        return true;
    }
}