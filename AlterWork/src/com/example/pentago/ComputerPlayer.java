package com.example.pentago;
import java.util.Random;

public class ComputerPlayer extends Player {
    private final Random random = new Random();

    public ComputerPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public Move makeMove(Board board) {
        // Простая стратегия: случайная пустая клетка
        int r, c;
        do {
            r = random.nextInt(6);
            c = random.nextInt(6);
        } while (board.getSymbol(r, c) != '.');

        int q = random.nextInt(4);
        boolean cw = random.nextBoolean();

        System.out.println(name + " ставит фишку на [" + r + "," + c + "] и вращает квадрант " + q);
        return new Move(new Coordinate(r, c), q, cw);
    }
}