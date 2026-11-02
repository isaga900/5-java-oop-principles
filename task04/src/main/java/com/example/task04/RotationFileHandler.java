package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RotationFileHandler implements MessageHandler {
    private final String filePrefix; // например "log"
    private final String fileExtension; // например ".txt"

    private PrintWriter currentWriter;
    private String currentFileName;
    private int currentHour;

    public RotationFileHandler(String filePrefix, String fileExtension) {
        this.filePrefix = filePrefix;
        this.fileExtension = fileExtension;
        this.currentHour = -1; // Чтобы гарантированно создать файл при первом вызове
    }

    @Override
    public void handle(String message) {
        int nowHour = LocalDateTime.now().getHour();

        if (nowHour != currentHour) {
            closeCurrentWriter();

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH"));
            currentFileName = filePrefix + "-" + timestamp + fileExtension;
            currentHour = nowHour;

            try {
                currentWriter = new PrintWriter(new FileWriter(currentFileName, true));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (currentWriter != null) {
            currentWriter.println(message);
            currentWriter.flush(); // Сразу записываем на диск
        }
    }

    private void closeCurrentWriter() {
        if (currentWriter != null) {
            currentWriter.close();
            currentWriter = null;
        }
    }
}