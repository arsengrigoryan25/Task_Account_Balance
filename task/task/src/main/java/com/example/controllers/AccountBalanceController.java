package com.example.controllers;

import com.example.DTO.Balance;
import com.example.DTO.Transactions;
import com.example.Util.CurrencyConversion;
import com.example.Util.WorkWithDB;
import com.example.enums.BalanceType;
import com.example.enums.Currency;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.Util.WorkWithDB.getBalanceByAccountName;
import static com.example.enums.Currency.*;

@RestController
@RequestMapping("/api")
public class AccountBalanceController {

    @PostMapping("/crateBalance") //    POST http://localhost:8080/api/crateBalance?accountName=arsen003
    public ResponseEntity<String> crateBalance(@RequestParam(name="accountName") String accountName_) {
        Balance balance = new Balance(accountName_);
        try{
            WorkWithDB.addBalance(balance);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("AccountName: " + accountName_ + " is created ", HttpStatus.OK);
    }

    @PostMapping("/credited") // mutq   POST http://localhost:8080/api/credited?accountName=arsen003&amount=200&currency=USD
    public ResponseEntity<String> credited(@RequestParam(name="accountName") String accountName_,
                                           @RequestParam(name="amount") String amount_,
                                           @RequestParam(name="currency") String currency_) {
        ResponseEntity<String> responseEntity;
        double amount = Double.parseDouble(amount_);

        switch (Currency.valueOf(currency_)) {
            case USD -> { }
            case EUR -> amount = CurrencyConversion.convertEurToUsd(amount);
            case RUB -> amount = CurrencyConversion.convertRubToUsd(amount);
            default -> new ResponseEntity<>("currency is invalid ", HttpStatus.BAD_REQUEST);
        }

        double currentBalance = getBalanceByAccountName(accountName_);
        WorkWithDB.updateBalance(accountName_, currentBalance + amount);

        Transactions transactions = new Transactions(accountName_, amount, BalanceType.CREDITED, USD);
        WorkWithDB.addTransactions(transactions);

        responseEntity = new ResponseEntity<>("AccountName: " + accountName_ + "amount incremented like " + amount_, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/debited") // elq     POST http://localhost:8080/api/debited?accountName=arsen003&amount=100&currency=USD
    public ResponseEntity<String> debited(@RequestParam(name="accountName") String accountName_,
                                          @RequestParam(name="amount") String amount_,
                                          @RequestParam(name="currency") String currency_) {
        ResponseEntity<String> responseEntity;
        double amount = Double.parseDouble(amount_);

        switch (Currency.valueOf(currency_)) {
            case USD -> { }
            case EUR -> amount = CurrencyConversion.convertEurToUsd(amount);
            case RUB -> amount = CurrencyConversion.convertRubToUsd(amount);
            default -> new ResponseEntity<>("currency is invalid ", HttpStatus.BAD_REQUEST);
        }

        double currentBalance = getBalanceByAccountName(accountName_);
        WorkWithDB.updateBalance(accountName_, currentBalance - amount);

        Transactions transactions = new Transactions(accountName_, amount, BalanceType.DEBITED, USD);
        WorkWithDB.addTransactions(transactions);

        responseEntity = new ResponseEntity<>("AccountName: " + accountName_ + "amount decrement like " + amount_, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/allTransactions/{accountName}") // GET http://localhost:8080/api/allTransactions/arsen003
    public ResponseEntity<List<Transactions>> getAllTransactionsByAccountId(@PathVariable(name="accountName") String accountName_) {
        ResponseEntity<List<Transactions>> responseEntity;

        List<Transactions> transactionsByAccountId = WorkWithDB.getTransactionsByAccountId(accountName_);

        responseEntity = new ResponseEntity<>(transactionsByAccountId, HttpStatus.OK);
        return responseEntity;
    }

}
