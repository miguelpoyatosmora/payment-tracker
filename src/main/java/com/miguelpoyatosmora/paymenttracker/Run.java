package com.miguelpoyatosmora.paymenttracker;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {
    public static void main(String args[]) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/spring/camel-context.xml");
        context.registerShutdownHook();
    }
}
