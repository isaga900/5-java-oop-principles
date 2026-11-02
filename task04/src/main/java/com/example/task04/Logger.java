package com.example.task04;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Logger {

    public enum Level {
        DEBUG, INFO, WARNING, ERROR
    }

    private static final Map<String, Logger> instances = new HashMap<>();

    private final String name;
    private Level level;

    // НОВОЕ: Список обработчиков
    private final List<MessageHandler> handlers = new ArrayList<>();

    private Logger(String name) {
        this.name = name;
        this.level = Level.DEBUG;
    }

    public static Logger getLogger(String name) {
        if (!instances.containsKey(name)) {
            instances.put(name, new Logger(name));
        }
        return instances.get(name);
    }

    // НОВОЕ: Метод для добавления обработчика
    public void addHandler(MessageHandler handler) {
        this.handlers.add(handler);
    }

    public String getName() { return name; }
    public Level getLevel() { return level; }
    public void setLevel(Level level) { this.level = level; }

    public void debug(String message) { log(Level.DEBUG, message); }
    public void debug(String template, Object... args) { log(Level.DEBUG, template, args); }

    public void info(String message) { log(Level.INFO, message); }
    public void info(String template, Object... args) { log(Level.INFO, template, args); }

    public void warning(String message) { log(Level.WARNING, message); }
    public void warning(String template, Object... args) { log(Level.WARNING, template, args); }

    public void error(String message) { log(Level.ERROR, message); }
    public void error(String template, Object... args) { log(Level.ERROR, template, args); }

    public void log(Level level, String message) {
        if (shouldLog(level)) {
            printMessage(level, message);
        }
    }

    public void log(Level level, String template, Object... args) {
        if (shouldLog(level)) {
            String message = String.format(template, args);
            printMessage(level, message);
        }
    }

    private boolean shouldLog(Level messageLevel) {
        return messageLevel.ordinal() >= level.ordinal();
    }

    // ИЗМЕНЕНО: Теперь отправляем сообщение всем обработчикам
    private void printMessage(Level level, String message) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        String dateStr = date.format(DateTimeFormatter.ofPattern("yyyy.MM.dd"));
        String timeStr = time.format(DateTimeFormatter.ofPattern("HH:mm:ss"));

        String formattedMessage = String.format("[%s] %s %s %s - %s",
                level, dateStr, timeStr, name, message);

        for (MessageHandler handler : handlers) {
            handler.handle(formattedMessage);
        }
    }
}