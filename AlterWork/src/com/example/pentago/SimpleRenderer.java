package com.example.pentago;

public class SimpleRenderer implements Renderer {
    @Override
    public void render(Board board) {
        System.out.println("--- Поле ---");
        for (int i = 0; i < 6; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 6; j++) {
                sb.append(board.getSymbol(i, j));
            }
            System.out.println(sb.toString());
        }
        System.out.println("--------------");
    }
}