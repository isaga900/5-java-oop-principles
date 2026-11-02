package com.example.task04;

public class Task04Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("MyApp");

        // 1. Простой вывод в консоль
        logger.addHandler(new ConsoleHandler());

        // 2. Запись в файл
        logger.addHandler(new FileHandler("app.log"));

        // 3. Ротация по часам (файлы будут называться log-2026-11-03-15.txt и т.д.)
        logger.addHandler(new RotationFileHandler("log", ".txt"));

        // 4. Память: накапливает 3 сообщения, потом пишет в консоль
        logger.addHandler(new MemoryHandler(new ConsoleHandler(), 3));

        logger.info("Привет, мир!");
        logger.warning("Внимание: что-то пошло не так");
        logger.error("Критическая ошибка!");
    }
}