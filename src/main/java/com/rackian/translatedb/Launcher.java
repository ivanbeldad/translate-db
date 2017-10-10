package com.rackian.translatedb;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Launcher {

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("/application-context.xml")
                .getBean("application", Application.class).start();
    }

}
