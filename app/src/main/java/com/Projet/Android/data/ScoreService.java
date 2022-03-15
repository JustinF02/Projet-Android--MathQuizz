package com.Projet.Android.data;

public class ScoreService {
    private ScoreDao scoreDao;

    public ScoreService(ScoreDao scoreDao) {
        this.scoreDao = scoreDao;
    }

    public Long getCalculCount(){
        return scoreDao.count();
    }

    public void storeInDb(Score score){
        scoreDao.create(score);
    }

    public Score getLast(){
        return  scoreDao.lastOrNull();
    }

    public void clearTable(){
        scoreDao.delete();
    }
}
