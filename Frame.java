/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;

import java.util.Random;

/**
 *
 * @author Del Peter
 * This class is in charge of calculating the two scores for the two bowls that occur each frame.
 */
public class Frame {
    //global variable and array declaration for weight of scoring.
    private int score1;
    private int score2;
    int chanceArray[] = {0,1,2,3,4,5,6,6,7,7,7,8,8,8,8,9,9,9,9,10,10,10};
    
    /*
    *Method that calculates the score of two rolls.
    */
    public void makeFrame(){
        Random ran = new Random();
        int pins = 10;
        score1 = chanceArray[ran.nextInt(22)];
        pins -= score1;
        score2 = ran.nextInt(pins + 1);
    }
    
    /*
    *Methods that get the values of the scores as well as strings for the scores.
    */
    public Integer getScore1(){
        return score1;
    }
    
    public Integer getScore2(){
        return score2;
    }
    /*
    *String for the case of a strike
    */
    public String getStringScore1(){
        if(score1 == 10){
            return "X";
        }else{
            return Integer.toString(score1);
        }
    }
    /*
    *String for the case of a spare
    */
    public String getStringScore2(){
        if(score1 + score2 == 10 && score1 != 10){
            return "S";
        }else if(score1 == 10){
            return " ";
        }else{
            return Integer.toString(score2);
        }
    }
}