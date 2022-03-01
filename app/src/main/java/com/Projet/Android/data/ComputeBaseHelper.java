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
                CalculDao.cleNbOpEASY + " INTEGER NOT NULL, " +
                CalculDao.cleNbOpMEDIUM + " INTEGER NOT NULL, " +
                CalculDao.cleNbOpDIFFICULT + " INTEGER NOT NULL, " +

                CalculDao.cleNbSuccesEASY + " INTEGER NOT NULL, " +
                CalculDao.cleNbSuccesMEDIUM + " INTEGER NOT NULL, " +
                CalculDao.cleNbSuccesDIFFICULT + " INTEGER NOT NULL" +
                ")";
    }

    @Override
    protected String getDeleteSql() {
        return null;
    }
}
