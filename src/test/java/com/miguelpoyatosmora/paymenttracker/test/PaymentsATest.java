package com.miguelpoyatosmora.paymenttracker.test;

import com.miguelpoyatosmora.paymenttracker.services.Bank;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;


public class PaymentsATest {

    static final Currency CURRENCY_GBP = Currency.getInstance(Locale.UK);

    @Autowired
    Bank bank;

    @Given("^there is no money in the current balance$")
    public void there_is_no_money_in_the_current_balance() throws Throwable {

//        BigDecimal amount = bank.getBalances().get(CURRENCY_GBP);
//        assertTrue(amount == null || BigDecimal.ZERO.equals(amount));
    }

    @When("^£(\\d+) is paid$")
    public void £_is_paid(long amount) throws Throwable {
        Thread.sleep(10000);

        sendUserInput("GBP " + amount + "\\n");
        Thread.sleep(3000);
    }

    @Then("^the balance should be £(\\d+)$")
    public void the_balance_should_be_£(long balance) throws Throwable {

//        BigDecimal amount = bank.getBalances().get(CURRENCY_GBP);
//        assertNotNull(amount);
//        assertEquals(amount, BigDecimal.valueOf(balance));
    }

    private void sendUserInput(String data) throws UnsupportedEncodingException {

//        InputStream testInput = new ByteArrayInputStream(data.getBytes());
//        System.setIn(testInput);
    }
}
