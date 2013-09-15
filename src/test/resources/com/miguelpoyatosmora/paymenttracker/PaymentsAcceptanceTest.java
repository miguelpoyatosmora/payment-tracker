package com.miguelpoyatosmora.paymenttracker;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;


public class PaymentsAcceptanceTest {

    @Autowired
    DefaultBank bank;

    @Given("^there is no money in the current balance$")
    public void there_is_no_money_in_the_current_balance() throws Throwable {
        bank.getBalances();
    }

    @When("^£(\\d+) is paid$")
    public void £_is_paid(int arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        // throw new PendingException();
    }

    @Then("^the balance should be £(\\d+)$")
    public void the_balance_should_be_£(int arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        // throw new PendingException();
    }

}
