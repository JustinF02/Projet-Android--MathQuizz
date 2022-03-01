package com.Projet.Android.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

import com.Projet.Android.R;
import com.Projet.Android.data.Calcul;
import com.Projet.Android.data.CalculDao;
import com.Projet.Android.data.CalculService;
import com.Projet.Android.data.ComputeBaseHelper;

import org.w3c.dom.Text;


public class Scores extends AppCompatActivity {

    private CalculService scoreservice;
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

        scoreservice = new CalculService(new CalculDao(new ComputeBaseHelper(this)));

        Calcul dernierScore = scoreservice.getLast();
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
            textViewEASYNombreCalcul.setText(dernierScore.getNbOpEASY());
            textViewMEDIUMNombreCalcul.setText(dernierScore.getNbOpMEDIUM());
            textViewDIFFICULTNombreCalcul.setText(dernierScore.getNbOpDIFFICULT());

            textViewEASYSuccess.setText(dernierScore.getNbSuccesEASY());
            textViewMEDIUMSuccess.setText(dernierScore.getNbSuccesMEDIUM());
            textViewDIFFICULTSuccess.setText(dernierScore.getNbSuccesDIFFICULT());

            textViewEASYRate.setText((dernierScore.getNbSuccesEASY()/dernierScore.getNbOpEASY())*100);
            textViewMEDIUMRate.setText((dernierScore.getNbSuccesMEDIUM()/dernierScore.getNbOpMEDIUM())*100);
            textViewDIFFICULTRate.setText((dernierScore.getNbSuccesDIFFICULT()/dernierScore.getNbOpDIFFICULT())*100);
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