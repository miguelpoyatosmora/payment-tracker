package com.miguelpoyatosmora.paymenttracker;

import com.miguelpoyatosmora.paymenttracker.model.Money;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DefaultBank implements Bank {

    @Override
    public void deposit(Money amount) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Set<Money> getBalances() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
