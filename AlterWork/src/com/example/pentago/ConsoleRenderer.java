package com.example.pentago;

public class ConsoleRenderer implements Renderer {
    @Override
    public void render(Board board) {
        System.out.println("\n  0 1 2   3 4 5");
        for (int i = 0; i < 6; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 6; j++) {
                System.out.print(board.getSymbol(i, j) + " ");
                if (j == 2) System.out.print("| "); // Разделитель квадрантов
            }
            System.out.println();
            if (i == 2) System.out.println("  -------+-------"); // Горизонтальный разделитель
        }
        System.out.println();
    }
}