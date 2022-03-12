package com.Projet.Android.data;

public class Calcul extends BaseEntity{
    Integer nbOpEASY;
    Integer nbSuccesEASY;

    Integer nbOpMEDIUM;
    Integer nbSuccesMEDIUM;

    Integer nbOpDIFFICULT;
    Integer nbSuccesDifficult;

    public Integer getNbOpEASY() {
        return nbOpEASY;
    }

    public void setNbOpEASY(Integer nbOpEASY) {
        if(this.nbOpEASY == null){
            this.nbOpEASY = 1;
        }else{
            this.nbOpEASY +=nbOpEASY;
        }
    }

    public Integer getNbSuccesEASY() {
        return nbSuccesEASY;
    }

    public void setNbSuccesEASY(Integer nbSuccesEASY) {
        if(this.nbOpEASY == null){
            this.nbSuccesEASY = 1;
        }else{
            this.nbSuccesEASY +=nbOpEASY;
        }
    }

    public Integer getNbOpMEDIUM() {
        return nbOpMEDIUM;
    }

    public void setNbOpMEDIUM(Integer nbOpMEDIUM) {
        this.nbOpMEDIUM += nbOpMEDIUM;
    }

    public Integer getNbSuccesMEDIUM() {
        return nbSuccesMEDIUM;
    }

    public void setNbSuccesMEDIUM(Integer nbSuccesMEDIUM) {
        this.nbSuccesMEDIUM += nbSuccesMEDIUM;
    }

    public Integer getNbOpDIFFICULT() {
        return nbOpDIFFICULT;
    }

    public void setNbOpDIFFICULT(Integer nbOpDIFFICULT) {
        this.nbOpDIFFICULT += nbOpDIFFICULT;
    }

    public Integer getNbSuccesDIFFICULT() {
        return nbSuccesDifficult;
    }

    public void setNbSuccesDIFFICULT(Integer nbSuccesDifficult) { this.nbSuccesDifficult = nbSuccesDifficult; }
}
