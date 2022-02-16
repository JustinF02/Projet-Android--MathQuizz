package com.Projet.Android.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.Projet.Android.exception.exceptionNull;
import com.Projet.Android.typeEnum.TypeOperation;
import com.Projet.Android.typeEnum.typeDifficulty;
import com.Projet.Android.R;

import java.util.Random;

public class PlayZone extends AppCompatActivity{

    private int element1, element2;
    private Double answer = 0.0;
    private Double resultatCorrect = 0.0;

    private String result = "?";

    private int maxiEASY = 100,
                maxiMedium = 100,
                miniMedium = -50,
                maxiDifficult = 1000,
                miniDifficult = -500;

    private typeDifficulty level;
    private TypeOperation typeOperation = null;

    private TextView txtVOperation;
    private EditText txtAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_zone);
        Intent intent =getIntent();

        level = (typeDifficulty) intent.getSerializableExtra("level");

        txtVOperation = findViewById(R.id.textViewCalcul);

        Button boutonRetour = findViewById(R.id.btnRetourMain);
        boutonRetour.setOnClickListener(view -> retourneAuPrecedent());
        Button boutonVerif = findViewById(R.id.btnVerify);
        boutonVerif.setOnClickListener(view -> verificationResultat());

        txtAnswer = findViewById(R.id.editTextNumberDecimal);

        genereUneOperation();
        affichage();
    }

    private void verificationResultat() {
        try {
            //a revoir pour l'erreur :
            if (txtAnswer.getText().equals("")) throw new exceptionNull();
            answer = Double.valueOf(txtAnswer.getText().toString()).doubleValue();
            if (resultatCorrect.equals(answer)) {
                txtAnswer.setBackgroundResource(R.color.green);
            } else {
                txtAnswer.setBackgroundResource(R.color.red);
            }
            result = resultatCorrect.toString();
            affichage();
        }catch(exceptionNull e){
            Toast.makeText(this, getString(R.string.message_valeur_null), Toast.LENGTH_LONG).show();
        }
    }

    private void retourneAuPrecedent() { finish(); }

    private void genereUnTypeOperation(){
        Random random = new Random();
        int mainInnocente = random.nextInt(4);
        switch (mainInnocente){
            case 0:
                this.typeOperation = TypeOperation.ADD;
                break;
            case 1:
                this.typeOperation = TypeOperation.DIVIDE;
                break;
            case 2:
                this.typeOperation = TypeOperation.SUBSTRACT;
                break;
            default:
                this.typeOperation = TypeOperation.MULTIPLY;
                break;
        }
    }
    private void calculeUneOperation(){
        switch (typeOperation){
            case ADD:
                resultatCorrect = (double)element1 + element2;
                break;
            case DIVIDE:
                resultatCorrect = (double) element1/element2;
                break;
            case SUBSTRACT:
                resultatCorrect = (double) element1-element2;
                break;
            case MULTIPLY:
                resultatCorrect = (double) element1 * element2;
                break;
        }
        //Permet de conserver uniquement les dizaines et centaines d'unité :
        resultatCorrect *=100;
        int variableTransition = (int)((double)resultatCorrect);
        resultatCorrect = (double)variableTransition / 100;
    }
    private void genereUneOperation(){
        Random random = new Random();
        switch(level){
            case EASY:
                element1 = random.nextInt(maxiEASY + 1);
                element2 = random.nextInt(maxiEASY + 1);
                typeOperation = TypeOperation.ADD;
                calculeUneOperation();
                break;
            case MEDIUM:
                element1 = miniMedium + random.nextInt(maxiMedium);
                element2 = miniMedium + random.nextInt(maxiMedium);
                genereUnTypeOperation();
                calculeUneOperation();
                break;
            case DIFFICULT:
                element1 = miniDifficult + random.nextInt(maxiDifficult);
                element2 = miniDifficult + random.nextInt(maxiDifficult);
                genereUnTypeOperation();
                calculeUneOperation();
                break;
        }
    }
    private void affichage(){
        txtVOperation.setText(element1 + " " + typeOperation.getSymbol() + " " + element2 + " = " + result);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_playzone, menu);

        MenuItem itemScores = menu.findItem(R.id.toolbarScores);
        itemScores.setOnMenuItemClickListener(menuItem -> ouvreActivityScore());

        MenuItem itemClean = menu.findItem(R.id.toolbarViderScores);
        itemClean.setOnMenuItemClickListener(menuItem -> videScore());
        return super.onCreateOptionsMenu(menu);
    }
    private boolean videScore() {

        return true;
    }

    private boolean ouvreActivityScore() {
        Intent intent = new Intent(this, Scores.class);
        startActivity(intent);
        return true;
    }
}