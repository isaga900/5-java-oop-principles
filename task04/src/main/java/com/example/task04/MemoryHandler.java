package com.example.task04;

import java.util.ArrayList;
import java.util.List;

public class MemoryHandler implements MessageHandler {
    private final List<String> buffer;
    private final MessageHandler target;
    private final int bufferSize;

    public MemoryHandler(MessageHandler target, int bufferSize) {
        this.target = target;
        this.bufferSize = bufferSize;
        this.buffer = new ArrayList<>();
    }

    @Override
    public void handle(String message) {
        buffer.add(message);

        // Если буфер заполнен - сбрасываем в целевой handler
        if (buffer.size() >= bufferSize) {
            flush();
        }
    }

    public void flush() {
        for (String msg : buffer) {
            target.handle(msg);
        }
        buffer.clear();
    }
}