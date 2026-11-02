package com.example.pentago;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private final Renderer renderer;
    private final WinChecker winChecker;

    public Game(Player p1, Player p2, Renderer renderer) {
        this.board = new Board();
        this.player1 = p1;
        this.player2 = p2;
        this.renderer = renderer;
        this.winChecker = new WinChecker();
    }

    public void start() {
        Player current = player1;
        int movesCount = 0;

        while (true) {
            renderer.render(board);
            System.out.println("Ход игрока: " + current.name + " (" + current.symbol + ")");

            Move move = current.makeMove(board);

            // 1. Ставим фишку
            board.placeStone(move.place.row, move.place.col, current.symbol);
            movesCount++;

            // 2. Проверяем победу СРАЗУ после установки (правило Пентаго)
            if (winChecker.checkWin(board, current.symbol)) {
                renderer.render(board);
                System.out.println("Победил " + current.name + "!");
                break;
            }

            // 3. Если победы нет, вращаем квадрант
            board.rotateQuadrant(move.quadrantIndex, move.clockwise);
            renderer.render(board);

            // 4. Проверяем победу ПОСЛЕ вращения
            if (winChecker.checkWin(board, current.symbol)) {
                System.out.println("Победил " + current.name + " (после вращения)!");
                break;
            }

            // 5. Проверка на ничью (заполнено поле)
            if (movesCount >= 36) {
                System.out.println("Ничья! Поле заполнено.");
                break;
            }

            // Смена хода
            current = (current == player1) ? player2 : player1;
        }
    }
}