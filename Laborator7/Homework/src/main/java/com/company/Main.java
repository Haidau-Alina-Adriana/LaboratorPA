package com.company;

import static java.lang.Thread.sleep;
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        game.addPlayer(new Player("PlayerOne"));
        game.addPlayer(new Player("PlayerTwo"));
        game.addPlayer(new Player("PlayerThree"));
        game.play();
        sleep(1000);

        if (game.getBag().getTiles().size() == 0) {
            int playerOneScore = game.getPlayers().get(0).getScore();
            int playerTwoScore = game.getPlayers().get(1).getScore();
            int playerThreeScore = game.getPlayers().get(2).getScore();

            System.out.println("Player 1 score: " + playerOneScore + "\nPlayer 2 score: " + playerTwoScore + "\nPlayer 3 score: " + playerThreeScore);
            System.out.print("Winner is: ");

            if (playerOneScore >= playerTwoScore && playerOneScore >= playerThreeScore)
                System.out.println(game.getPlayers().get(0).getName());
            else if (playerTwoScore >= playerOneScore && playerTwoScore >= playerThreeScore)
                System.out.println(game.getPlayers().get(1).getName());
            else
                System.out.println(game.getPlayers().get(2).getName());
        }

    }
}
