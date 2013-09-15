package com.miguelpoyatosmora.paymenttracker;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Map;

@Component
public class DefaultBank implements Bank {

    private Map<Currency, BigDecimal> balances = new HashMap<Currency, BigDecimal>();

    @Override
    public void deposit(Currency currency, BigDecimal amount) {

        BigDecimal currentBalance = balances.get(currency);
        if (currentBalance == null) {
            balances.put(currency, amount);
        } else {
            BigDecimal newAmount = currentBalance.add(amount);
            balances.put(currency, newAmount);
        }
    }

    @Override
    public Map<Currency, BigDecimal> getBalances() {
        return balances;
    }
}
