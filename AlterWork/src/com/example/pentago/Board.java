package com.example.pentago;

public class Board {
    private final Quadrant[] quadrants = new Quadrant[4];

    public Board() {
        for (int i = 0; i < 4; i++) quadrants[i] = new Quadrant();
    }

    // Перевод глобальных координат (0..5) в индекс квадранта и локальные координаты
    private int getQuadrantIndex(int row, int col) {
        return (row / 3) * 2 + (col / 3);
    }

    public void placeStone(int row, int col, char symbol) {
        int qIdx = getQuadrantIndex(row, col);
        int localRow = row % 3;
        int localCol = col % 3;
        quadrants[qIdx].setCell(localRow, localCol, symbol);
    }

    public void rotateQuadrant(int index, boolean clockwise) {
        quadrants[index].rotate(clockwise);
    }

    public char getSymbol(int row, int col) {
        int qIdx = getQuadrantIndex(row, col);
        return quadrants[qIdx].getCell(row % 3, col % 3);
    }

    public Quadrant getQuadrant(int index) { return quadrants[index]; }
}