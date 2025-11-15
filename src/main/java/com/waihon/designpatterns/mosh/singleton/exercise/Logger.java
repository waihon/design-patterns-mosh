package com.waihon.designpatterns.mosh.singleton.exercise;

import java.util.HashMap;
import java.util.Map;

public class Logger {
    private static Map<String, Logger> loggers = new HashMap<>();
    private String content = "";

    private Logger() { }

    public static Logger getInstance(String fileName) {
        if (loggers.containsKey(fileName)) {
            return loggers.get(fileName);
        } else {
            var logger = new Logger();
            loggers.put(fileName, logger);
            return logger;
        }
    }

    public void write(String log) {
        if (content == null || content.isBlank()) {
            content = log;
        } else {
            content += "\n" + log;
        }
    }

    public String getContent() {
        return content;
    }
}
