package com.miguelpoyatosmora.paymenttracker;


import com.miguelpoyatosmora.paymenttracker.services.PaymentMapper;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PaymentMapperUTest {

    public static final String GBP_100 = "GBP 100";
    public static final String GBP100 = "GBP100";

    PaymentMapper instance = new PaymentMapper();

    @Test
    public void given_as_input_GBP_100_when_is_matched_then_it_retrieves_GBP_100() throws Exception {

        Pattern pattern = Pattern.compile(PaymentMapper.PAYMENT_PATTERN);

        Matcher matcher = pattern.matcher(GBP_100);

        assertTrue(matcher.matches());
        assertEquals(2, matcher.groupCount());
        assertEquals("GBP", matcher.group(1));
        assertEquals("100", matcher.group(2));
    }

    @Test
    public void given_as_input_GBP_100_when_is_mapped_then_it_retrieves_100_and_currency_pounds() throws Exception {

        ImmutablePair<Currency, BigDecimal> currencyBigDecimalEntry = instance.map(GBP_100);

        assertEquals(Currency.getInstance(Locale.UK), currencyBigDecimalEntry.getKey());
        assertEquals(new BigDecimal(100), currencyBigDecimalEntry.getValue());
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_as_input_GBP100_when_is_mapped_then_IllegalArgumentException_is_thrown() throws Exception {

        instance.map(GBP100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void given_as_input_XSW_100_when_is_mapped_then_IllegalArgumentException_is_thrown() throws Exception {

        instance.map("XSW 100");
    }

}
