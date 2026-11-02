package com.example.pentago;

public class Quadrant {
    private char[][] cells = new char[3][3];

    public Quadrant() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                cells[i][j] = '.';
    }

    public char getCell(int r, int c) { return cells[r][c]; }

    public void setCell(int r, int c, char symbol) {
        if (cells[r][c] == '.') cells[r][c] = symbol;
    }

    public boolean isEmpty(int r, int c) { return cells[r][c] == '.'; }

    // Логика поворота матрицы 3x3
    public void rotate(boolean clockwise) {
        char[][] newCells = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (clockwise) {
                    newCells[j][2 - i] = cells[i][j];
                } else {
                    newCells[2 - j][i] = cells[i][j];
                }
            }
        }
        cells = newCells;
    }

    // Геттер для доступа к массиву (нужен для отрисовки)
    public char[][] getCells() { return cells; }
}