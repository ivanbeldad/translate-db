package com.rackian.translatedb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class App 
{

    public static void main( String[] args )
    {
        String configLocation = "/application-context.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
        App app = context.getBean("app", App.class);
        app.run();
    }

    private void run() {
    }

}
