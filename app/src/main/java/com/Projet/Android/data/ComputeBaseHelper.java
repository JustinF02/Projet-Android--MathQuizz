package com.Projet.Android.data;

import android.content.Context;

public class ComputeBaseHelper extends DataBaseHelper {


    public ComputeBaseHelper(Context context) {
        super(context, "Calcul", 1);
    }

    @Override
    protected String getCreationSql() {

        return "CREATE TABLE IF NOT EXISTS historique (" +
                "id" + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ScoreDao.cleNbOpEASY + " INTEGER NOT NULL, " +
                ScoreDao.cleNbOpMEDIUM + " INTEGER NOT NULL, " +
                ScoreDao.cleNbOpDIFFICULT + " INTEGER NOT NULL, " +

                ScoreDao.cleNbSuccesEASY + " INTEGER NOT NULL, " +
                ScoreDao.cleNbSuccesMEDIUM + " INTEGER NOT NULL, " +
                ScoreDao.cleNbSuccesDIFFICULT + " INTEGER NOT NULL" +
                ")";
    }

    @Override
    protected String getDeleteSql() {
        return null;
    }
}
