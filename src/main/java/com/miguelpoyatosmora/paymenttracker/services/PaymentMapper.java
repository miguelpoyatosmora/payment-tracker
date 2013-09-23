package com.miguelpoyatosmora.paymenttracker.services;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class PaymentMapper {

    public static final String PAYMENT_PATTERN = "^(\\w+)\\s(\\d+)$";
    private static final Pattern PATTERN = Pattern.compile(PAYMENT_PATTERN);

    /**
     * @param payment A payment that must follow the pattern {@link PaymentMapper#PAYMENT_PATTERN} otherwise {@link IllegalArgumentException} is thrown.
     * @return
     */
    public ImmutablePair<Currency, BigDecimal> map(String payment) {

        Matcher matcher = PATTERN.matcher(payment);

        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }

        Currency currency = Currency.getInstance(matcher.group(1));
        BigDecimal amount = new BigDecimal(matcher.group(2));
        return ImmutablePair.of(currency, amount);
    }
}
