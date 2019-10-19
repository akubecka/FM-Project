package Fm;

import java.util.Random;

public enum Position{
    //enumerations declared here
    GOALKEEPER, 
    LEFTBACK, CENTERBACK, RIGHTBACK,
    LEFTWING, CENTERMID, RIGHTWING,
    STRIKER;
    private static Random rand = new Random();
    public static Position randomPos(){
        int randomInt = rand.nextInt(8);
        switch(randomInt){
            case 0:
                return Position.GOALKEEPER;
            case 1:
                return Position.LEFTBACK;
            case 2:
                return Position.CENTERBACK;
            case 3:
                return Position.RIGHTBACK;
            case 4:
                return Position.LEFTWING;
            case 5:
                return Position.CENTERMID;
            case 6:
                return Position.RIGHTWING;
            default:
                return Position.STRIKER;
        }
    }

} 