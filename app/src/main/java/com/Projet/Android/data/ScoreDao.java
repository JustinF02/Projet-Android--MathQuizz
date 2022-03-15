package com.Projet.Android.data;

import android.content.ContentValues;
import android.database.Cursor;

public class ScoreDao extends BaseDao<Score>{
    public ScoreDao(DataBaseHelper helper) {
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
    protected void putValues(ContentValues values, Score entity) {
        values.put(cleNbOpEASY, entity.getNbOpEASY());
        values.put(cleNbSuccesEASY, entity.getNbSuccesEASY());

        values.put(cleNbOpMEDIUM, entity.getNbOpMEDIUM());
        values.put(cleNbSuccesMEDIUM, entity.getNbSuccesMEDIUM());

        values.put(cleNbOpDIFFICULT, entity.getNbOpDIFFICULT());
        values.put(cleNbSuccesDIFFICULT, entity.getNbSuccesDIFFICULT());
    }

    @Override
    protected Score getEntity(Cursor cursor) {
        Score score = new Score();


        Integer indexNbOpEASY = cursor.getColumnIndex(cleNbOpEASY);
        Integer indexNbOpMEDIUM = cursor.getColumnIndex(cleNbOpMEDIUM);
        Integer indexNbOpDIFFICULT = cursor.getColumnIndex(cleNbOpDIFFICULT);

        Integer indexNbSuccesEASY = cursor.getColumnIndex(cleNbSuccesEASY);
        Integer indexNbSuccesMEDIUM = cursor.getColumnIndex(cleNbSuccesMEDIUM);
        Integer indexNbSuccesDIFFICULT = cursor.getColumnIndex(cleNbSuccesDIFFICULT);


        score.setNbOpEASY(cursor.getInt(indexNbOpEASY));
        score.setNbOpMEDIUM(cursor.getInt(indexNbOpMEDIUM));
        score.setNbOpDIFFICULT(cursor.getInt(indexNbOpDIFFICULT));

        score.setNbSuccesEASY(cursor.getInt(indexNbSuccesEASY));
        score.setNbSuccesMEDIUM(cursor.getInt(indexNbSuccesMEDIUM));
        score.setNbSuccesDIFFICULT(cursor.getInt(indexNbSuccesDIFFICULT));

        return score;
    }
}
