package com.example.pentago;

public class PentagoApp {
    public static void main(String[] args) {
        // Вариант 1: Человек против Компьютера
        Player human = new HumanPlayer("Алексей", 'X');
        Player computer = new ComputerPlayer("Робот", 'O');

        // Выбираем отрисовщик
        Renderer renderer = new ConsoleRenderer();
        // Или: Renderer renderer = new SimpleRenderer();

        Game game = new Game(human, computer, renderer);
        game.start();
    }
}