package com.example.pentago;

public abstract class Player {
    protected final char symbol;
    protected final String name;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    // Абстрактный метод: каждый игрок делает ход по-своему
    public abstract Move makeMove(Board board);
}