package com.waihon.designpatterns.mosh.singleton.exercise;

import java.util.HashMap;
import java.util.Map;

public class Logger {
    private static Map<String, Logger> instances = new HashMap<>();
    private String fileName;
    private String content = "";

    private Logger(String fileName) {
        this.fileName = fileName;
    }

    public static Logger getInstance(String fileName) {
        if (!instances.containsKey(fileName)) {
            instances.put(fileName, new Logger(fileName));
        }

        return instances.get(fileName);
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
