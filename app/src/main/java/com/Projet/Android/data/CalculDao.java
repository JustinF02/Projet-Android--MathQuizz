package com.Projet.Android.data;

import android.content.ContentValues;
import android.database.Cursor;

import com.Projet.Android.model.Calcul;


public class CalculDao  extends BaseDao<Calcul>{
    public CalculDao(DataBaseHelper helper) {
        super(helper);
    }

    static String cleNbOpEASY="cleNbOpEASY";
    static String cleNbSuccesEASY="cleNbSuccesEASY";

    static String cleNbOpMEDIUM="cleNbOpMEDIUM";
    static String cleNbSuccesMEDIUM="cleNbSuccesMEDIUM";

    static String cleNbOpDIFFICULT="cleNbOpDIFFICULT";
    static String cleNbSuccesDIFFICULT="cleNbSuccesDIFFICULT";


    @Override
    protected String getTableName() {
        return "historique";
    }

    @Override
    protected void putValues(ContentValues values, Calcul entity) {
        values.put(cleNbOpEASY, entity.getNbOpEASY());
        values.put(cleNbSuccesEASY, entity.getNbSuccesEASY());

        values.put(cleNbOpMEDIUM, entity.getNbOpMEDIUM());
        values.put(cleNbSuccesMEDIUM, entity.getNbSuccesMEDIUM());

        values.put(cleNbOpDIFFICULT, entity.getNbOpDIFFICULT());
        values.put(cleNbSuccesDIFFICULT, entity.getNbSuccesDIFFICULT());
    }

    @Override
    protected Calcul getEntity(Cursor cursor) {
        Calcul calcul = new Calcul();
        
        Integer indexNbOpEASY = cursor.getColumnIndex(cleNbOpEASY);
        Integer indexNbOpMEDIUM = cursor.getColumnIndex(cleNbOpMEDIUM);
        Integer indexNbOpDIFFICULT = cursor.getColumnIndex(cleNbOpDIFFICULT);

        Integer indexNbSuccesEASY = cursor.getColumnIndex(cleNbSuccesEASY);
        Integer indexNbSuccesMEDIUM = cursor.getColumnIndex(cleNbSuccesMEDIUM);
        Integer indexNbSuccesDIFFICULT = cursor.getColumnIndex(cleNbSuccesDIFFICULT);


        calcul.setNbOpEASY(cursor.getInt(indexNbOpEASY));
        calcul.setNbOpMEDIUM(cursor.getInt(indexNbOpMEDIUM));
        calcul.setNbOpDIFFICULT(cursor.getInt(indexNbOpDIFFICULT));

        calcul.setNbSuccesEASY(cursor.getInt(indexNbSuccesEASY));
        calcul.setNbSuccesMEDIUM(cursor.getInt(indexNbSuccesMEDIUM));
        calcul.setNbSuccesDIFFICULT(cursor.getInt(indexNbSuccesDIFFICULT));

        return calcul;
    }
}
