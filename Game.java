/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;
/**
 *
 * @author Daniel Gray and Peter Mitzel
 * This class is responsible for playing a game of bowling and printing out the
 * result.
 */
public class Game {
    String[] stringGameFrame = new String[22];
/**
 * This method is responsible for all of the "house keeping" in the class. It calls
 * the private methods and allows them to work together.
 */    
    public void playGame(){
        Integer[] gameFrame = makeGameFrame();
        Score score = new Score(gameFrame);
        Integer[] scoredArray = score.calculateScore();
        formatOutput(scoredArray);
    }
/**
 * 
 * @return Integer [] gameFrame
 * This private method is responsible for creating two arrays. One array (gameFrame)
 * is the integer representation of the game. This is used by the Score class to
 * calculate the score. The other array is a string representation of the score.
 * It is used to print the game.
 */
    private Integer[] makeGameFrame(){
        Integer[] gameFrame = new Integer[22];
        int counter = 0;
        int counterTwo = 0;
        Frame frame = new Frame();
        for(int i = 0; i < 10; i++){
            frame.makeFrame();
            gameFrame[counter] = frame.getScore1();
            stringGameFrame[counterTwo] = frame.getStringScore1();
            counterTwo++;
            counter++;
            stringGameFrame[counterTwo] = frame.getStringScore2();
            counterTwo++;
            if(frame.getScore1() != 10){
                gameFrame[counter] = frame.getScore2();
                counter ++;
            }
        }
        if(gameFrame[counter-1] + gameFrame[counter-2] == 10 && !stringGameFrame[counterTwo-2].equals("X")){
            frame.makeFrame();
            gameFrame[counter] = frame.getScore1();
            stringGameFrame[counterTwo] = frame.getStringScore1();
            if(stringGameFrame[counterTwo].equals("X")){
                stringGameFrame[counterTwo+1] = " ";
            }else{
                stringGameFrame[counterTwo+1] = "0";
            }
        }else if(gameFrame[counter-1] == 10){
            frame.makeFrame();
            gameFrame[counter] = frame.getScore1();
            gameFrame[counter+1] = frame.getScore2();
            stringGameFrame[counterTwo] = frame.getStringScore1();
            stringGameFrame[counterTwo + 1] = frame.getStringScore2();
        }
        return gameFrame;
    }

/**
 * 
 * @param scoredArray 
 * This method takes in a scored array and accesses a global variable that stores
 * the string representation of the bowling game. It uses these arrays to print
 * out the game.
 */    
    private void formatOutput(Integer[] scoredArray){
        for(int i = 0; i < 9; i++){
            System.out.print("+----Frame " + (i+1) +"----");
        }
        System.out.print("+----Frame 10---+---------------+\n+");
        int i = 0;
        while(i+1 < stringGameFrame.length && stringGameFrame[i+1] != null){
            System.out.print("   " + stringGameFrame[i] + "   |   " + stringGameFrame[++i] + "   +");
            i++;
        }
        if(i < stringGameFrame.length && stringGameFrame[i] != null){
            System.out.print("   " + stringGameFrame[i] + "   |       +");
        }
        if(i < stringGameFrame.length && stringGameFrame[i] == null){
            System.out.print("               +");
        }
        System.out.print("\n");
        for(i = 0; i < 11; i++){
            System.out.print("+---------------");
        }
        System.out.print("+\n+");
        
        for(Integer score : scoredArray){
           if(score < 10){
               System.out.print("       " + score + "       +");
           }else if(score < 100){
               System.out.print("       " + score + "      +");
           }else{
               System.out.print("      " + score + "      +");
           }
        }
        System.out.print("               +\n");
        for(i = 0; i < 11; i++){
            System.out.print("+---------------");
        }
        System.out.print("+\n\n\n\n");
    }
}