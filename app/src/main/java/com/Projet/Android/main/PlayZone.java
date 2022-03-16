package com.Projet.Android.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.Projet.Android.data.Score;
import com.Projet.Android.data.ScoreDao;
import com.Projet.Android.data.ScoreService;
import com.Projet.Android.data.ComputeBaseHelper;
import com.Projet.Android.typeEnum.TypeOperation;
import com.Projet.Android.typeEnum.typeDifficulty;
import com.Projet.Android.R;

import java.util.Random;

public class PlayZone extends AppCompatActivity{

    private int element1, element2;
    private int answer = 0;
    private Integer resultatCorrect = 0;
    private int ConstMaxLife = 3;
    private int nbLife = ConstMaxLife, streak = 0;
    private String result = "?";

    private int maxiEASY = 100,
                maxiMedium = 100,
                miniMedium = -50,
                maxiDifficult = 1000,
                miniDifficult = -500;

    private typeDifficulty level;
    private TypeOperation typeOperation = null;

    private TextView TextViewLife;
    private TextView txtVOperation;
    private EditText txtAnswer;
    private Button boutonRetour, boutonVerif;
    private boolean operationValidee = false;

    private MenuItem itemStreak;

    private ScoreService scoreService;
    private ContentValues values;

    private int nbOpEASY = 0;
    private int nbSucEASY = 0;
    private int nbOpMEDIUM = 0;
    private int nbSucMEDIUM = 0;
    private int nbOpDIFFICULT = 0;
    private int nbSucDIFFICULT = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_zone);

        scoreService = new ScoreService(new ScoreDao(new ComputeBaseHelper(this)));
        Intent intent =getIntent();
        level = (typeDifficulty) intent.getSerializableExtra("level");

        TextViewLife = findViewById(R.id.TextViewLife);
        txtVOperation = findViewById(R.id.textViewCalcul);

        boutonRetour = findViewById(R.id.btnRetourMain);
        boutonRetour.setOnClickListener(view -> FinishGame());

        boutonVerif = findViewById(R.id.btnVerify);
        boutonVerif.setOnClickListener(view -> appuieBouton(boutonVerif));

        txtAnswer = findViewById(R.id.editTextNumberDecimal);

        genereUneOperation();
        affichage();
        Score dernierScore = scoreService.getLast();
        nbOpEASY = dernierScore.getNbOpEASY();
        nbSucEASY = dernierScore.getNbSuccesEASY();
        nbOpMEDIUM = dernierScore.getNbOpMEDIUM();
        nbSucMEDIUM = dernierScore.getNbSuccesMEDIUM();
        nbOpDIFFICULT = dernierScore.getNbOpDIFFICULT();
        nbSucDIFFICULT = dernierScore.getNbSuccesDIFFICULT();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar_playzone, menu);

        itemStreak = menu.findItem(R.id.toolbarStreak);

        MenuItem itemScores = menu.findItem(R.id.toolbarScores);
        itemScores.setOnMenuItemClickListener(menuItem -> ouvreActivityScore());
        return super.onCreateOptionsMenu(menu);
    }

    private void appuieBouton(Button bouton) {
        if(operationValidee){
            if(nbLife <= 0){FinishGame();}
            efface();
            bouton.setText(R.string.btnVerifyInPlayZone);
        }else {
            verificationResultat();
            bouton.setText(R.string.btnNextInPlayZone);
        }
    }

    private void verificationResultat() {
        try{
            answer = Integer.valueOf(txtAnswer.getText().toString()).intValue();
            if (resultatCorrect.equals(answer)) {
                ajouteResultatCorrect();
            } else {
                ajouteResultatFaux();
            }
        }catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, getString(R.string.message_valeur_null), Toast.LENGTH_LONG).show();
            ajouteResultatFaux();
        }
        result = resultatCorrect.toString();
        affichage();
        operationValidee = true;
    }

    private void ajouteResultatFaux() {
        nbLife--;
        TextViewLife.setText("");
        for(int nb = 1; nb <= nbLife;nb++){
            TextViewLife.setText(TextViewLife.getText() + "❤ ");
        }
        txtAnswer.setBackgroundResource(R.color.red);
        switch(level){
            case EASY:
                nbOpEASY +=1;
                break;
            case MEDIUM:
                nbOpMEDIUM +=1;
                break;
            case DIFFICULT:
                nbOpDIFFICULT +=1;
                break;
        }
    }

    private void ajouteResultatCorrect() {
        streak++;
        itemStreak.setTitle(getString(R.string.streak)+streak);
        txtAnswer.setBackgroundResource(R.color.green);
        switch(level){
            case EASY:
                nbOpEASY+=1;
                nbSucEASY +=1;
                break;
            case MEDIUM:
                nbOpMEDIUM+=1;
                nbSucMEDIUM+=1;
                break;
            case DIFFICULT:
                nbOpDIFFICULT+=1;
                nbSucDIFFICULT+=1;
                break;
        }
    }

    private void updateBDD(){
        Score score = new Score();
        values = new ContentValues();
        switch(level){
            case EASY:
                values.put("cleNbOpEASY", nbOpEASY);
                values.put("cleNbSuccesEASY", nbSucEASY);
                score.setNbOpEASY(nbOpEASY);
                score.setNbSuccesEASY(nbSucEASY);
                break;
            case MEDIUM:
                values.put("cleNbOpMEDIUM", nbOpMEDIUM);
                values.put("cleNbSuccesMEDIUM", nbSucMEDIUM);
                score.setNbOpMEDIUM(nbOpMEDIUM);
                score.setNbSuccesMEDIUM(nbSucMEDIUM);
                break;
            case DIFFICULT:
                values.put("cleNbOpDIFFICULT", nbOpDIFFICULT);
                values.put("cleNbSuccesDIFFICULT", nbSucDIFFICULT);
                score.setNbOpDIFFICULT(nbOpDIFFICULT);
                score.setNbSuccesDIFFICULT(nbSucDIFFICULT);
                break;
        }
        scoreService.updateInDb(values, score);
    }
    private void FinishGame() {
        updateBDD();
        //TODO : UPDATE IN DB. VALUES NbOP & nbSuc etc etc

        //TODO : UPDATE AUSSI DANS LA METHODE ouvreActivityScore().
        finish(); }
    private void genereUnTypeOperation(){
        Random random = new Random();
        int mainInnocente = random.nextInt(4);
        switch (mainInnocente){
            case 0:
                this.typeOperation = TypeOperation.ADD;
                break;
            case 1:
                this.typeOperation = TypeOperation.MULTIPLY;
                break;
            case 2:
                this.typeOperation = TypeOperation.SUBSTRACT;
                break;
            /*default:
                this.typeOperation = TypeOperation.DIVIDE;
                break;*/
        }
    }
    private void calculeUneOperation(){
        switch (typeOperation){
            case ADD:
                resultatCorrect = element1 + element2;
                break;
            /*case DIVIDE:
                resultatCorrect = (double) element1/element2;
                break;*/
            case SUBSTRACT:
                resultatCorrect = element1-element2;
                break;
            case MULTIPLY:
                resultatCorrect = element1 * element2;
                break;
        }
        /*Permet d'arrondir aux centaines d'unité :
        * resultatCorrect *=100;
        * int variableTransition = (int)((double)resultatCorrect);
        * resultatCorrect = (double)variableTransition / 100;*/
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
    private void efface(){
        result = "?";
        element1 = 0;
        element2 = 0;
        answer = 0;
        resultatCorrect = 0;
        typeOperation = null;
        operationValidee = false;
        txtAnswer.setText("");
        txtAnswer.setBackgroundResource(R.color.white);
        genereUneOperation();
        affichage();
    }

    private boolean ouvreActivityScore() {
        //TODO UPDATE IN DB HERE TOO
        updateBDD();
        Intent intent = new Intent(this, ScoresActivity.class);
        startActivity(intent);
        return true;
    }
}