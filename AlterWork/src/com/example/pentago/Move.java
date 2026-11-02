package com.example.pentago;

public class Move {
    final Coordinate place; // Куда ставим шарик
    final int quadrantIndex; // Какой квадрант крутим (0-3)
    final boolean clockwise; // true - по часовой, false - против

    public Move(Coordinate place, int quadrantIndex, boolean clockwise) {
        this.place = place;
        this.quadrantIndex = quadrantIndex;
        this.clockwise = clockwise;
    }
}