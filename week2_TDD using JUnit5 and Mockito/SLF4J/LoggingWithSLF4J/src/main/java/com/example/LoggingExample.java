package com.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class LoggingExample {
	private static final Logger l = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] a) {
        l.error("This is an error message");
        l.warn("This is a warning message");
    }
}
