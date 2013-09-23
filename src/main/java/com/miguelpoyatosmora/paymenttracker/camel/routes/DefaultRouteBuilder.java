package com.miguelpoyatosmora.paymenttracker.camel.routes;

import com.miguelpoyatosmora.paymenttracker.camel.ShutdownProcessor;
import com.miguelpoyatosmora.paymenttracker.services.PaymentMapper;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DefaultRouteBuilder extends RouteBuilder {


    @Override
    public void configure() throws Exception {

        from("stream:in").to("activemq:paymentTracker.in");

        from("file:data?noop=true")
            .split().tokenize("\r\n").streaming()
                .to("activemq:paymentTracker.in");

        from("activemq:paymentTracker.in")
            .choice()
            .when(body().regex(PaymentMapper.PAYMENT_PATTERN))
                .bean(PaymentMapper.class)
                .to("bean:bank?method=deposit")
            .when(body().isEqualTo("quit"))
                .process(new ShutdownProcessor())
            .otherwise()
                .log(LoggingLevel.WARN, "Incorrect input ${body}")
                .to("activemq:paymentTracker.dlq");

        from("quartz://report?cron=0+*+*+*+*+?")
            .to("bean:bank?method=getBalances")
            .log(LoggingLevel.INFO, "${body}");
    }
}
