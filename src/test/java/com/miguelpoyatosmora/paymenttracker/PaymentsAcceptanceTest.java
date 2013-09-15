package com.miguelpoyatosmora.paymenttracker;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;


public class PaymentsAcceptanceTest {

    static final Currency CURRENCY_GBP = Currency.getInstance(Locale.UK);

    @Autowired
    Bank bank;

    @Given("^there is no money in the current balance$")
    public void there_is_no_money_in_the_current_balance() throws Throwable {

        BigDecimal amount = bank.getBalances().get(CURRENCY_GBP);
        assertTrue(amount == null || BigDecimal.ZERO.equals(amount));
    }

    @When("^£(\\d+) is paid$")
    public void £_is_paid(long amount) throws Throwable {

        bank.deposit(CURRENCY_GBP, BigDecimal.valueOf(amount));
    }

    @Then("^the balance should be £(\\d+)$")
    public void the_balance_should_be_£(long balance) throws Throwable {

        BigDecimal amount = bank.getBalances().get(CURRENCY_GBP);
        assertNotNull(amount);
        assertEquals(amount, BigDecimal.valueOf(balance));
    }

}
