package com.example.Util;

import com.example.enums.Currency;

public class InitializationCurrencyFactor {
    public static void setFactorUsdToEurRatio(double factor){
        Currency.EUR.setFactorRatioToUSD(factor);
    }

    public static void setFactorUsdToRubRatio(double factor){
        Currency.RUB.setFactorRatioToUSD(factor);
    }

    public static void setFactorUsdToBynRatio(double factor){
        Currency.BYN.setFactorRatioToUSD(factor);
    }
}
