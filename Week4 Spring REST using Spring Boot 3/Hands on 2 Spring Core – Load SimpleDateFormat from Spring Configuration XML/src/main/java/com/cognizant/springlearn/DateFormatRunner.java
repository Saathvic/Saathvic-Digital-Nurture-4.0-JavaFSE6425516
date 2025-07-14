package com.cognizant.springlearn;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DateFormatRunner {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("date-format.xml");
        SimpleDateFormat format = context.getBean("dateFormat", SimpleDateFormat.class);
        try {
            Date parsedDate = format.parse("31/12/2018");
            System.out.println("Parsed Date: " + parsedDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
