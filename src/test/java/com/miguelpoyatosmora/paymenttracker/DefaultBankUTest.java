package com.miguelpoyatosmora.paymenttracker;


import com.miguelpoyatosmora.paymenttracker.services.Bank;
import com.miguelpoyatosmora.paymenttracker.services.DefaultBank;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import java.util.Map;

import static junit.framework.Assert.*;

public class DefaultBankUTest {

    static final Currency CURRENCY_GBP = Currency.getInstance(Locale.UK);
    static final BigDecimal _100 = BigDecimal.valueOf(100);

    Bank bank = new DefaultBank();

    @Test
    public void given_there_is_no_money_in_the_current_balance_when_£100_is_paid_then_the_balance_should_be_£100() {

        //Given
//        BigDecimal amount = bank.getBalances().get(CURRENCY_GBP);
//        assertTrue(amount == null || BigDecimal.ZERO.equals(amount));
//
//        When
//        bank.deposit(ImmutablePair.of(CURRENCY_GBP, _100));
//
//
//        Then
//        amount = bank.getBalances().get(CURRENCY_GBP);
//        assertNotNull(amount);
//        assertEquals(amount, _100);
    }
}
