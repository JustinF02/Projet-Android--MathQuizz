package com.Projet.Android.data;

public class CalculService {
    private CalculDao calculDao;

    public CalculService(CalculDao calculDao) {
        this.calculDao = calculDao;
    }

    public Long getCalculCount(){
        return calculDao.count();
    }

    public void storeInDb(Calcul calcul){
        calculDao.create(calcul);
    }

    public Calcul getLast(){
        return  calculDao.lastOrNull();
    }

    public void clearTable(){
        calculDao.delete();
    }
}
