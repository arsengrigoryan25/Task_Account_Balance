package com.example.Util;

import com.example.enums.Currency;

public class CurrencyConversion {
    public static double convertEurToUsd(double valueInEUR){
        return valueInEUR / Currency.EUR.getFactorRatioToUSD();
    }

    public static double convertEurToRub(double valueInEUR){
        return valueInEUR / Currency.EUR.getFactorRatioToUSD() * Currency.RUB.getFactorRatioToUSD();
    }

    public static double convertEurToByn(double valueInEUR){
        return valueInEUR / Currency.EUR.getFactorRatioToUSD() * Currency.BYN.getFactorRatioToUSD();
    }

    public static double convertRubToUsd(double valueInRub){
        return valueInRub / Currency.RUB.getFactorRatioToUSD();
    }

    public static double convertRubToEur(double valueInRub){
        return valueInRub / Currency.RUB.getFactorRatioToUSD() * Currency.EUR.getFactorRatioToUSD();
    }

    public static double convertRubToByn(double valueInRub){
        return valueInRub / Currency.RUB.getFactorRatioToUSD() * Currency.BYN.getFactorRatioToUSD();
    }

    public static double convertBynToUsd(double valueInByn){
        return valueInByn / Currency.BYN.getFactorRatioToUSD();
    }

    public static double convertBynToEur(double valueInRub){
        return valueInRub / Currency.BYN.getFactorRatioToUSD() * Currency.EUR.getFactorRatioToUSD();
    }

    public static double convertBynToRub(double valueInRub){
        return valueInRub / Currency.BYN.getFactorRatioToUSD() * Currency.RUB.getFactorRatioToUSD();
    }
}
