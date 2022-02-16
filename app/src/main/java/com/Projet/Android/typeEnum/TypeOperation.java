package com.Projet.Android.typeEnum;

public enum TypeOperation {
    ADD("+"),
    MULTIPLY("x"),
    SUBSTRACT("-"),
    DIVIDE("/");

    private String symbol;

    TypeOperation(String symbol) {
        this.symbol=symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}

