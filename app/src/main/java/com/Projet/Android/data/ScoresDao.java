package com.Projet.Android.data;

import android.content.ContentValues;
import android.database.Cursor;

import com.Projet.Android.model.Scores;

public class ScoresDao extends BaseDao<Scores>{
    public ScoresDao(DataBaseHelper helper) {
        super(helper);
    }

    @Override
    protected String getTableName() {
        return null;
    }

    @Override
    protected void putValues(ContentValues values, Scores entity) {

    }

    @Override
    protected Scores getEntity(Cursor cursor) {
        return null;
    }
}
