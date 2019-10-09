/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;

/**
 *
 * @author Daniel Gray and Peter Mitzel
 * This is the Score class. This class is instantiated with an array that has
 * all of the frames from a game broken down into their individual scores. It
 * then takes that array and calculates the score for each frame. 
 * That score is then added to the calculatedScoreArray, which is returned 
 * at the end of the calculateScore() method.
 */
class Score {
    private Integer[] scoreArray;
    
    public Score(Integer[] scoreArray){
        this.scoreArray = scoreArray;
    }
/**
 * 
 * @return Integer[] calculatedScoreArray
 * This method is responsible for calculating the score of a given game composed
 * of frames, each frame composed of two scores.
 */    
    public Integer[] calculateScore(){
        Integer[] calculatedScoreArray = new Integer[10];
        Integer runningTotal = 0;
        Integer primary = 0;
        Integer counter = 0;
   
        for(int i = 0; i < this.scoreArray.length; i++){
            primary = scoreArray[i];
            /*This section handles the event of a strike*/
            if(i+1 < scoreArray.length && primary != null && scoreArray[i+1] != null && primary == 10){
                if(i+2 < scoreArray.length && scoreArray[i+2] != null){
                    if(scoreArray[i+1] != null){
                        runningTotal += 10;
                    }
                    runningTotal += scoreArray[i+1];
                    if(scoreArray[i+2] != null){
                        runningTotal += scoreArray[i+2];
                    }
                    calculatedScoreArray[counter] = runningTotal;
                }
                
                counter++;
            }else{
                /*This section handles the event of neither a strike nor a spare.*/
                if(i+1 < scoreArray.length && scoreArray[i+1] != null && primary + scoreArray[i+1] != 10 && counter < 10){
                    runningTotal += primary;
                    runningTotal += scoreArray[i+1];
                    calculatedScoreArray[counter] = runningTotal;
                /*This section handles spares.*/
                }else if(i+2 < scoreArray.length && scoreArray[i+1] != null && scoreArray[i+2] != null && primary + scoreArray[i+1] == 10){
                        runningTotal += 10;
                        runningTotal += scoreArray[i+2];
                        calculatedScoreArray[counter] = runningTotal;
                }
                    
                i++;
                counter++;    
            }
        }   
        return calculatedScoreArray;
    }
}