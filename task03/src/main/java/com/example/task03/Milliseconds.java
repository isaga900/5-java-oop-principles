package com.example.task03;

public class Milliseconds implements TimeUnit {
    private final long amount;

    public Milliseconds(long amount) {
        this.amount = amount;
    }

    @Override
    public long toMillis() {
        return amount;
    }

    @Override
    public long toSeconds() {
        // Делим на дробное число и округляем
        return Math.round(amount / 1000.0);
    }

    @Override
    public long toMinutes() {
        // В минуте 60000 мс. Округляем результат.
        return Math.round(amount / 60000.0);
    }

    @Override
    public long getHours() {
        return Math.round(amount / 3_600_000.0);
    }
}