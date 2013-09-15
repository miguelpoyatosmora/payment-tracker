package com.miguelpoyatosmora.paymenttracker;

import com.miguelpoyatosmora.paymenttracker.model.Money;

import java.util.Set;

public interface Bank {

    void deposit(Money amount);

    Set<Money> getBalances();
}
