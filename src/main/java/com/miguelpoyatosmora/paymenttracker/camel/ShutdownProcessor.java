package com.miguelpoyatosmora.paymenttracker.camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ShutdownProcessor implements Processor{

    @Override
    public void process(final Exchange exchange) throws Exception {
        new Thread() {
            @Override
            public void run() {
                try {
                    exchange.getContext().stop();
                    System.exit(0);
                } catch (Exception e) {
                    // log error
                }
            }
        }.start();
    }
}
