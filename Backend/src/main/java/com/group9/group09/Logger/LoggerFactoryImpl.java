package com.group9.group09.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * Custom LoggerFactory implementation to provide a singleton logger instance.
 */
public class LoggerFactoryImpl {


    private static LoggerFactoryImpl instance;
    private Logger logger;

    /**
     * Private constructor to prevent direct instantiation.
     * The logger is initialized with the class of the LoggerFactoryImpl itself.
     */
    private LoggerFactoryImpl() {
        logger = LoggerFactory.getLogger(LoggerFactoryImpl.class);
    }

    /**
     * Returns the logger instance. If the instance doesn't exist, it creates a new one.
     *
     * @return The singleton logger instance.
     */
    public static Logger getLogger() {
        if (instance == null) {
            // Create the instance if it doesn't exist.
            instance = new LoggerFactoryImpl();
        }
        return instance.logger;
    }
}
