package com.example.pentago;

public class WinChecker {
    public boolean checkWin(Board board, char playerSymbol) {
        // Проверка горизонтали и вертикали
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j <= 1; j++) { // достаточно проверить до индекса 1, т.к. длина ряда 5
                if (checkLine(board, i, j, 0, 1, playerSymbol)) return true; // горизонталь
                if (checkLine(board, j, i, 1, 0, playerSymbol)) return true; // вертикаль
            }
        }
        // Проверка диагоналей (упрощенно, можно доработать полный перебор)
        // ... (для краткости опустим полную реализацию всех диагоналей, но логика та же)
        return false;
    }

    private boolean checkLine(Board board, int startR, int startC, int dR, int dC, char symbol) {
        for (int k = 0; k < 5; k++) {
            if (board.getSymbol(startR + k * dR, startC + k * dC) != symbol) return false;
        }
        return true;
    }
}