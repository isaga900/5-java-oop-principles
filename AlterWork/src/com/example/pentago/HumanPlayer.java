package com.example.pentago;
import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String name, char symbol) {
        super(name, symbol);
    }

    @Override
    public Move makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(name + ", ваш ход (" + symbol + "). Введите строку и столбец (0-5):");
        int r = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println("Выберите квадрант для поворота (0-3) и направление (1 - по часовой, 0 - против):");
        int q = scanner.nextInt();
        boolean cw = scanner.nextInt() == 1;

        return new Move(new Coordinate(r, c), q, cw);
    }
}