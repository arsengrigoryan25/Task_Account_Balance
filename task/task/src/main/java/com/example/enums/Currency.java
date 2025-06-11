package com.example.enums;

public enum Currency {
    USD, EUR, BYN, RUB;

    private double factorRatioToUSD;

    public double getFactorRatioToUSD() {
        return factorRatioToUSD;
    }
    public void setFactorRatioToUSD(double factorRatioToUSD) {
        this.factorRatioToUSD = factorRatioToUSD;
    }
}
