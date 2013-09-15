package com.miguelpoyatosmora.paymenttracker;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;

public interface Bank {

    void deposit(Currency currency, BigDecimal amount);

    Map<Currency, BigDecimal> getBalances();
}
