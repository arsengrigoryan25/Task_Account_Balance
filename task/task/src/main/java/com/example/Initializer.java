package com.example;

import com.example.Util.InitializationCurrencyFactor;
import com.example.Util.WorkWithDB;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Initializer implements CommandLineRunner {

	@Override
	public void run(String... args){
		WorkWithDB.createStatement();
		WorkWithDB.createBalanceTypeTable();
		WorkWithDB.createCurrencyTable();
		WorkWithDB.createBalanceTable();
		WorkWithDB.createTransactionsTable();

		WorkWithDB.fillTableBalanceType();
		WorkWithDB.fillTableCurrency();

        InitializationCurrencyFactor.setFactorUsdToEurRatio(0.88);           // 1 $  = €
        InitializationCurrencyFactor.setFactorUsdToRubRatio(78.50);          // 1 $  = ₽
        InitializationCurrencyFactor.setFactorUsdToBynRatio(3.27);           // 1 $  = Br
	}
}
