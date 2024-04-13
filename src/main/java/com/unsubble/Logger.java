package com.unsubble;

import org.apache.logging.log4j.LogManager;

public final class Logger {

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger();

    private Logger() {
    }

    public static org.apache.logging.log4j.Logger getLogger() {
        return logger;
    }
}
