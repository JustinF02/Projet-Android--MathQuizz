package com.Projet.Android.data;

public class Score extends BaseEntity{

    Integer nbOpEASY=0;
    Integer nbSuccesEASY=0;

    Integer nbOpMEDIUM=0;
    Integer nbSuccesMEDIUM =0;

    Integer nbOpDIFFICULT =0;
    Integer nbSuccesDifficult = 0;

    public Integer getNbOpEASY() {
        return nbOpEASY;
    }

    public void setNbOpEASY(int nbOpEASY) {
            this.nbOpEASY +=nbOpEASY;
    }

    public Integer getNbSuccesEASY() {
        return nbSuccesEASY;
    }

    public void setNbSuccesEASY(int nbSuccesEASY) {
            this.nbSuccesEASY +=nbSuccesEASY;
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
