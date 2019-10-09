/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;

/**
 *
 * @author Daniel Gray and Peter Mitzel
 * This is the Bowling Class with the main method. By running the main
 * method, you will run a bowling game with five different players. To change
 * the number of players, simply change the number of times that the for loop
 * runs.
 */
public class Bowling {

    /**
     * @param args String[] args
     * This is the main method that is responsible for running the game 5 times
     */
    public static void main(String[] args) {       
        for(int i = 0; i<5; i++){
            Game myGame = new Game();
            myGame.playGame();
        }
    }
}