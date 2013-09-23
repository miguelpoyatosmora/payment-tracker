package com.miguelpoyatosmora.paymenttracker.services;

import org.apache.commons.lang3.tuple.ImmutablePair;

import java.math.BigDecimal;
import java.util.Map;

public interface Bank {

    Map<String, BigDecimal> getBalances();

    void deposit(ImmutablePair<String, BigDecimal> money);
}
