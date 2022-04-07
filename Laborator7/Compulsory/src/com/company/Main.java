package com.company;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.addPlayer(new Player("PlayerOne"));
        game.addPlayer(new Player("PlayerTwo"));
        game.addPlayer(new Player("PlayerThree"));
        game.play();
    }
}
